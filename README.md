<div align="center">

# 🧮 Calculadora · Team08 PSW

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=24&pause=1000&color=7EE787&center=true&vCenter=true&width=780&lines=Calculadora+en+Java+con+CI%2FCD+en+Jenkins%3B+87+pruebas+JUnit+y+100%25+de+cobertura%3B+Notificaciones+automaticas+a+Slack" alt="Calculadora en Java con CI/CD en Jenkins, 87 pruebas JUnit, 100% de cobertura y notificaciones automáticas a Slack" />

<br/>

![Java](https://img.shields.io/badge/Java-11-E76F00?logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9-C71A36?logo=apachemaven&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-5.9.3-25A162?logo=junit5&logoColor=white)
![tests](https://img.shields.io/badge/tests-87%20passed-4c1)
![JaCoCo](https://img.shields.io/badge/JaCoCo-100%25%20lineas-brightgreen)
![build](https://img.shields.io/badge/build-Jenkins-2496ED?logo=jenkins&logoColor=white)
![Slack](https://img.shields.io/badge/Slack-notificaciones-C4145C?logo=slack&logoColor=white)
[![GitHub stars](https://img.shields.io/github/stars/GenesisRodriguezArcos/Team08_PSW_Calculadora?logo=github&label=stars)](https://github.com/GenesisRodriguezArcos/Team08_PSW_Calculadora)

<br/>

<img src="docs/demo.gif" width="680" alt="Demo animada: ejecución de mvn test, cobertura JaCoCo y notificaciones a Slack" />

</div>

---

## 🎯 ¿De qué se trata?

Una calculadora Java con operaciones **básicas y avanzadas** (suma, resta, multiplicación, división, potencia, raíz cuadrada, módulo, valor absoluto, factorial, porcentaje, par/primo, MCD y MCM) que además viene con una **integración completa de CI/CD**:

> [!TIP]
> Cada `git push` dispara un pipeline en **Jenkins** → compila con **Maven** → ejecuta **87 pruebas JUnit** → mide la cobertura con **JaCoCo** → y publica una tarjeta en **Slack** con el resultado, las pruebas y la cobertura.

**En una frase:** código + pruebas + integración continua + notificaciones en tiempo real.

<img src="https://skillicons.dev/icons?i=java,maven,jenkins,git,github,eclipse,vscode&theme=dark" alt="Java, Maven, Jenkins, Git, GitHub, Eclipse, VS Code" />

---

## ✨ Características

| | Característica | Detalle |
|:-:|---|---|
| ➕ | **14 operaciones** | sumar, restar, multiplicar, dividir, potencia, raíz, módulo, absoluto, factorial, porcentaje, esPar, esPrimo, MCD, MCM |
| 🧪 | **87 pruebas** | 42 pruebas unitarias + 11 parametrizadas (45 casos) |
| 📊 | **100 % de cobertura** | líneas, métodos, clases e instrucciones (97 % ramas) |
| 🤖 | **Pipeline Jenkins** | 3 etapas: descargar → compilar → probar + reportar |
| 💬 | **Slack Block Kit** | tarjeta con color, campos y botones clicables |
| 🧯 | **Falla ruidosa** | si una prueba cae, el build se pone rojo **y** avisa en Slack |
| 🔁 | **Portable** | `sh` en Linux/macOS y `bat` en Windows (`isUnix()`) |

---

## 🛠 Tecnologías

| Tecnología | Versión | Para qué |
|---|:---:|---|
| ☕ Java | 11 | Lenguaje del proyecto (compilado con JDK moderno) |
| 📦 Maven | 3.9 | Gestión de dependencias y ejecución del ciclo de vida |
| 🧪 JUnit 5 | 5.9.3 | Pruebas unitarias (`surefire` 3.0.0) |
| 📈 JaCoCo | 0.8.15 | Instrumentación y reporte de cobertura |
| 🔁 Jenkins | 2.568 | Orquestación del pipeline (`Jenkinsfile` declarativo) |
| 💬 Slack | plugin 795.v4b | Notificaciones con `slackSend` |
| 🔐 Credenciales | Jenkins | Token de Slack cifrado (`slack-token`, scope global) |

---

## ▶️ Uso rápido

```bash
# 1. clonar
git clone https://github.com/GenesisRodriguezArcos/Team08_PSW_Calculadora.git
cd Team08_PSW_Calculadora

# 2. ejecutar las 87 pruebas + reporte de cobertura
mvn test

# 3. ver el reporte
open target/site/jacoco/index.html
```

> [!NOTE]
> No existe clase `main`: es una **librería con pruebas**. El "ejecutable" es el propio pipeline de Jenkins.

<details>
<summary>📁 <b>Estructura del proyecto</b> (clic)</summary>

```text
Team08_PSW_Calculadora/
├── Jenkinsfile                 # pipeline + notificaciones Slack
├── pom.xml                     # Maven + JaCoCo
├── docs/
│   ├── demo.gif                # demo animada del pipeline
│   └── evidencias/             # capturas de las 3 corridas
└── src/
    ├── main/java/com/calculadora/
    │   └── Calculadora.java    # 14 operaciones
    └── test/java/com/calculadora/
        └── CalculadoraTest.java# 87 pruebas
```

</details>

---

## 🧪 Pruebas

**87 pruebas · 0 fallos** en `CalculadoraTest`.

| Bloque de pruebas | Contenido |
|---|---|
| Aritmética | suma, resta, multiplicación, división (incl. división por cero) |
| Avanzadas | potencia, raíz cuadrada, módulo, valor absoluto |
| Enteros | factorial, esPar, esPrimo |
| Números | porcentaje, MCD, MCM |

Cada operación de la clase `Calculadora` tiene **su propio grupo de pruebas** (14 grupos).

```bash
[INFO] Tests run: 87, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## 📊 Cobertura JaCoCo

| Métrica | Valor | Progreso |
|---|:---:|:---:|
| Líneas | **46 / 46 = 100 %** | ![100](https://img.shields.io/badge/100%25-3fb950) |
| Métodos | **15 / 15 = 100 %** | ![100](https://img.shields.io/badge/100%25-3fb950) |
| Clases | **1 / 1 = 100 %** | ![100](https://img.shields.io/badge/100%25-3fb950) |
| Instrucciones | **178 / 178 = 100 %** | ![100](https://img.shields.io/badge/100%25-3fb950) |
| Ramas | **29 / 30 = 97 %** | ![97](https://img.shields.io/badge/97%25-d29922) |

---

## 🔁 Pipeline (Jenkins)

```mermaid
flowchart LR
    A["git push"] --> B["Checkout SCM"]
    B --> C["Descargar proyecto"]
    C --> D["Compilar (Maven)"]
    D --> E["Pruebas JUnit"]
    E --> F["JaCoCo + junit() + artifacts"]
    F --> G{"¿pruebas OK?"}
    G -->|si| H["slackSend :white_check_mark: good"]
    G -->|no| I["slackSend :x: danger"]
    H --> J["#notificaciones-jenkins"]
    I --> J
```

```mermaid
sequenceDiagram
    participant G as GitHub
    participant J as Jenkins
    participant M as Maven/JUnit
    participant S as Slack
    G->>J: push a main
    J->>M: mvn -B test
    M-->>J: 87 pruebas + jacoco.exec
    J->>J: resumen de pruebas y cobertura
    alt build correcto
        J->>S: tarjeta verde (good)
    else build fallido
        J->>S: tarjeta roja (danger)
    end
    S-->>J: HTTP 200
```

<details>
<summary>🧩 <b>Etapas del Jenkinsfile</b> (clic)</summary>

| Etapa | Qué hace |
|---|---|
| **Checkout SCM** | trae el `Jenkinsfile` desde GitHub |
| **Descargar proyecto** | `git` sobre la rama `main` |
| **Compilar** | `mvn -B -DskipTests compile` |
| **Pruebas** | `mvn -B test` |
| **`post/always`** | lee los reportes Surefire + JaCoCo, `junit()`, `archiveArtifacts`, `jacoco()` |
| **`post/success · failure`** | arma la tarjeta y llama a `slackSend` |

</details>

<details>
<summary>💬 <b>Cómo se arma la tarjeta de Slack</b> (clic)</summary>

El plugin rechaza `color` dentro de un mensaje con `blocks`
(`IllegalArgumentException: Color is not supported when blocks are set`),
así que la tarjeta combina **attachment** (color + campos) con **blocks** (botones):

```groovy
slackSend(
    channel:   env.CANAL,
    color:     color,                       // good | danger | warning
    message:   aviso,                       // texto push / fallback
    attachments: [[ 'color': color,
                    'pretext': encabezado,   // ✅ Build SUCCESS | calculadora-ci #7
                    'fields': campos,        // Resultado · Rama · Pruebas · Cobertura · Duración
                    'mrkdwn_in': ['pretext', 'fields'] ]],
    blocks: [ [ 'type': 'actions', 'elements': [
        ['type':'button','text':['type':'plain_text','text':'Ver logs'],   'url': env.BUILD_URL],
        ['type':'button','text':['type':'plain_text','text':'Consola'],   'url': "${env.BUILD_URL}console"],
        ['type':'button','text':['type':'plain_text','text':'Cobertura'], 'url': "${env.BUILD_URL}jacoco/"]
    ] ] ]
)
```

| Estado | Color | Tarjeta |
|---|:---:|---|
| `SUCCESS` | 🟢 `good` | verde |
| `FAILURE` | 🔴 `danger` | rojo |
| `UNSTABLE` | 🟡 `warning` | amarillo |
| `ABORTED` | 🔵 `#439FE0` | azul |

</details>

---

## 🚀 Corridas de validación

Tres corridas obligatorias para comprobar que **avisa tanto el éxito como el fallo**:

| # | Commit | Resultado | Duración | Notificación |
|:--:|---|:-:|---:|---|
| 5 | `8c86881` fix Slack | 🟢 **SUCCESS** | 36 s | `87 ejecutadas · 0 fallidas` |
| 6 | `c0d85ce` fallo deliberado | 🔴 **FAILURE** | 39 s | `87 ejecutadas · 1 fallidas` |
| 7 | `4f1bb61` revert | 🟢 **SUCCESS** | 29 s | `87 ejecutadas · 0 fallidas` |

---

## 📸 Evidencias

<div align="center">

| ✅ Éxito | ❌ Fallo |
|---|---|
| <img src="docs/evidencias/02_build_success.png" width="430" alt="Build #4 SUCCESS" /> | <img src="docs/evidencias/06_build_failure.png" width="430" alt="Build #3 FAILURE" /> |
| <img src="docs/evidencias/03_consola_notificacion.png" width="430" alt="Consola: notificación SUCCESS" /> | <img src="docs/evidencias/07_consola_failure.png" width="430" alt="Consola: notificación FAILURE" /> |
| <img src="docs/evidencias/05_resultados_junit.png" width="430" alt="87 pruebas aprobando" /> | <img src="docs/evidencias/08_resultado_junit_failure.png" width="430" alt="1 prueba fallida" /> |

</div>

### 💬 Notificaciones en Slack (`#notificaciones-jenkins`)

<div align="center">
<img src="docs/evidencias/12_slack_canal_ciclo.png" width="900" alt="Ciclo SUCCESS → FAILURE → SUCCESS en Slack" />
</div>

<details>
<summary>🖼️ <b>Galería completa</b> (14 evidencias · clic)</summary>

| | | |
|---|---|---|
| <img src="docs/evidencias/00_dashboard.png" width="420" alt="Dashboard Jenkins" /> | <img src="docs/evidencias/01_job_calculadora-ci.png" width="420" alt="Job calculadora-ci" /> | <img src="docs/evidencias/04_reporte_cobertura.png" width="420" alt="Reporte JaCoCo" /> |
| <img src="docs/evidencias/09_slack_success_1946.png" width="420" alt="Tarjeta Slack SUCCESS" /> | <img src="docs/evidencias/10_slack_failure_2016.png" width="420" alt="Tarjeta Slack FAILURE" /> | <img src="docs/evidencias/11_slack_success_2017.png" width="420" alt="Tarjeta Slack SUCCESS" /> |
| <img src="docs/evidencias/verif_root.png" width="420" alt="Acceso a Jenkins" /> | <img src="docs/evidencias/05_resultados_junit.png" width="420" alt="Resultados JUnit" /> | <img src="docs/evidencias/08_resultado_junit_failure.png" width="420" alt="Resultado JUnit con fallo" /> |

</details>

---

## 👥 Equipo

| Integrante | Rol en este proyecto |
|---|---|
| **Christopher Lucas Leyva Chumpitaz** | Fase 2 · Jenkins, pipeline, JaCoCo y notificaciones a Slack |
| **Genesis de los Ángeles Rodríguez Arcos** | Fase 1 · proyecto Java, operaciones y 87 pruebas JUnit |
| **Carlos Andres Guerrero Almeyda** | Integrante |
| **María Nayeli Madeleine Ávila Conde** | Integrante |

**Tutora:** Valery Giselle Chumpitaz Caycho · **Módulo:** Soporte Técnico y Ofimática · **Cañete, Perú — Septiembre 2026**

---

<div align="center">

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=500&size=16&pause=900&color=58A6FF&center=true&width=700&lines=%3E+87+pruebas+%C2%B7+100%25+cobertura+%C2+B+3+corridas+validadas+%C2%B7+0+fallos+ignorados" alt="87 pruebas · 100% cobertura · 3 corridas validadas" />

[![GitHub](https://img.shields.io/badge/GitHub-GenesisRodriguezArcos%2FTeam08__PSW__Calculadora-181717?logo=github&logoColor=white)](https://github.com/GenesisRodriguezArcos/Team08_PSW_Calculadora)

</div>
