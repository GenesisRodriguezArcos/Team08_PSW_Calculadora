def ejecutarMaven(String comando) {
    if (isUnix()) {
        sh comando
    } else {
        bat comando
    }
}

def prepararReportes() {
    try {
        if (isUnix()) {
            sh 'cat target/surefire-reports/*.txt > target/resumen-tests.txt'
        } else {
            bat 'type target\\surefire-reports\\*.txt > target\\resumen-tests.txt'
        }
    } catch (Exception ignorada) {
        echo 'Aun no hay reportes de pruebas disponibles'
    }
    if (fileExists('target/jacoco.exec') && !fileExists('target/site/jacoco/jacoco.csv')) {
        try {
            ejecutarMaven('mvn -B jacoco:report')
        } catch (Exception e) {
            echo 'No se pudo generar el reporte de cobertura'
        }
    }
}

def resumenDePruebas() {
    try {
        if (!fileExists('target/resumen-tests.txt')) {
            return 'Sin datos'
        }
        def texto = readFile('target/resumen-tests.txt')
        int total = 0
        int fallidas = 0
        def coincidencias = texto =~ /Tests run:\s*(\d+),\s*Failures:\s*(\d+),\s*Errors:\s*(\d+)/
        while (coincidencias.find()) {
            total += Integer.parseInt(coincidencias.group(1))
            fallidas += Integer.parseInt(coincidencias.group(2))
            fallidas += Integer.parseInt(coincidencias.group(3))
        }
        if (total == 0) {
            return 'Sin datos'
        }
        return "${total} ejecutadas | ${fallidas} fallidas"
    } catch (Exception e) {
        return 'Sin datos'
    }
}

def coberturaDeCodigo() {
    try {
        if (!fileExists('target/site/jacoco/jacoco.csv')) {
            return 'Sin datos'
        }
        def lineas = readFile('target/site/jacoco/jacoco.csv').trim().split('\n')
        long cubiertas = 0
        long perdidas = 0
        for (int i = 1; i < lineas.length; i++) {
            def columnas = lineas[i].split(',')
            if (columnas.length > 8) {
                perdidas += Integer.parseInt(columnas[7].trim())
                cubiertas += Integer.parseInt(columnas[8].trim())
            }
        }
        long total = cubiertas + perdidas
        if (total == 0) {
            return 'Sin datos'
        }
        int porcentaje = (int) (cubiertas * 100.0 / total + 0.5)
        return "${porcentaje}% lineas (${cubiertas}/${total})"
    } catch (Exception e) {
        return 'Sin datos'
    }
}

def notificarSlack(String estado, String color, String emoji) {
    def pruebas = resumenDePruebas()
    def cobertura = coberturaDeCodigo()
    echo "Notificacion Slack -> ${estado} | pruebas: ${pruebas} | cobertura: ${cobertura} | canal: ${env.CANAL}"
    def aviso = "Build ${estado}: ${env.JOB_NAME} #${env.BUILD_NUMBER} ${env.BUILD_URL}"
    def encabezado = "${emoji} *Build ${estado}*  |  `${env.JOB_NAME}` *#${env.BUILD_NUMBER}*"

    def campos = [
        ['title': 'Resultado', 'value': estado, 'short': true],
        ['title': 'Rama', 'value': env.RAMA, 'short': true],
        ['title': 'Pruebas JUnit', 'value': pruebas, 'short': true],
        ['title': 'Cobertura JaCoCo', 'value': cobertura, 'short': true],
        ['title': 'Duracion', 'value': currentBuild.durationString, 'short': true]
    ]

    def bloques = [
        [
            'type': 'actions',
            'elements': [
                ['type': 'button', 'text': ['type': 'plain_text', 'text': 'Ver logs'], 'url': env.BUILD_URL],
                ['type': 'button', 'text': ['type': 'plain_text', 'text': 'Consola'], 'url': "${env.BUILD_URL}console"],
                ['type': 'button', 'text': ['type': 'plain_text', 'text': 'Cobertura'], 'url': "${env.BUILD_URL}jacoco/"]
            ]
        ]
    ]

    slackSend(
        channel: env.CANAL,
        color: color,
        message: aviso,
        attachments: [[
            'color': color,
            'pretext': encabezado,
            'fields': campos,
            'mrkdwn_in': ['pretext', 'fields']
        ]],
        blocks: bloques
    )
}

pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '20'))
        disableConcurrentBuilds()
        timeout(time: 20, unit: 'MINUTES')
    }

    environment {
        REPO = 'https://github.com/GenesisRodriguezArcos/Team08_PSW_Calculadora.git'
        RAMA = 'main'
        CANAL = '#notificaciones-jenkins'
    }

    stages {
        stage('Descargar proyecto') {
            steps {
                git branch: env.RAMA, url: env.REPO
            }
        }

        stage('Compilar') {
            steps {
                script {
                    ejecutarMaven('mvn -B clean compile')
                }
            }
        }

        stage('Pruebas unitarias') {
            steps {
                script {
                    try {
                        ejecutarMaven('mvn -B test')
                    } finally {
                        prepararReportes()
                    }
                }
            }
        }
    }

    post {
        always {
            script {
                prepararReportes()
                junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
                try {
                    archiveArtifacts artifacts: 'target/site/jacoco/**', allowEmptyArchive: true
                } catch (Exception e) {
                    echo 'Sin reporte de cobertura para archivar'
                }
                try {
                    jacoco execPattern: 'target/jacoco.exec'
                } catch (Exception e) {
                    echo 'Plugin JaCoCo no disponible en Jenkins'
                }
            }
        }
        success {
            script {
                notificarSlack('SUCCESS', 'good', ':white_check_mark:')
            }
        }
        failure {
            script {
                notificarSlack('FAILURE', 'danger', ':x:')
            }
        }
        unstable {
            script {
                notificarSlack('UNSTABLE', 'warning', ':warning:')
            }
        }
        aborted {
            script {
                notificarSlack('ABORTED', '#439FE0', ':no_entry_sign:')
            }
        }
    }
}
