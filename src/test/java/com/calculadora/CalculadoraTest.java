package com.calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la Calculadora.
 * Incluye tests para todas las operaciones y casos límite.
 */
@DisplayName("Pruebas de la Calculadora")
class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora();
    }

    // ===== PRUEBAS DE SUMA =====
    @Test
    @DisplayName("Prueba de suma: números positivos")
    void testSumarPositivos() {
        assertEquals(8.0, calc.sumar(5, 3), 0.001);
    }

    @Test
    @DisplayName("Prueba de suma: números negativos")
    void testSumarNegativos() {
        assertEquals(-8.0, calc.sumar(-5, -3), 0.001);
    }

    @Test
    @DisplayName("Prueba de suma: cero")
    void testSumarConCero() {
        assertEquals(5.0, calc.sumar(5, 0), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, 2",
        "10, 5, 15",
        "-5, 5, 0",
        "0.5, 0.5, 1.0"
    })
    @DisplayName("Prueba de suma: múltiples casos")
    void testSumarParametrizado(double a, double b, double esperado) {
        assertEquals(esperado, calc.sumar(a, b), 0.001);
    }

    // ===== PRUEBAS DE RESTA =====
    @Test
    @DisplayName("Prueba de resta: básica")
    void testRestarBasica() {
        assertEquals(2.0, calc.restar(5, 3), 0.001);
    }

    @Test
    @DisplayName("Prueba de resta: resultado negativo")
    void testRestarResultadoNegativo() {
        assertEquals(-2.0, calc.restar(3, 5), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
        "10, 5, 5",
        "0, 5, -5",
        "5, 5, 0",
        "-3, -3, 0"
    })
    @DisplayName("Prueba de resta: múltiples casos")
    void testRestarParametrizado(double a, double b, double esperado) {
        assertEquals(esperado, calc.restar(a, b), 0.001);
    }

    // ===== PRUEBAS DE MULTIPLICACIÓN =====
    @Test
    @DisplayName("Prueba de multiplicación: números positivos")
    void testMultiplicarPositivos() {
        assertEquals(15.0, calc.multiplicar(5, 3), 0.001);
    }

    @Test
    @DisplayName("Prueba de multiplicación: por cero")
    void testMultiplicarPorCero() {
        assertEquals(0.0, calc.multiplicar(5, 0), 0.001);
    }

    @Test
    @DisplayName("Prueba de multiplicación: números negativos")
    void testMultiplicarNegativos() {
        assertEquals(15.0, calc.multiplicar(-5, -3), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
        "2, 3, 6",
        "5, 0, 0",
        "-4, 2, -8",
        "0.5, 4, 2"
    })
    @DisplayName("Prueba de multiplicación: múltiples casos")
    void testMultiplicarParametrizado(double a, double b, double esperado) {
        assertEquals(esperado, calc.multiplicar(a, b), 0.001);
    }

    // ===== PRUEBAS DE DIVISIÓN =====
    @Test
    @DisplayName("Prueba de división: básica")
    void testDividirBasica() {
        assertEquals(2.5, calc.dividir(5, 2), 0.001);
    }

    @Test
    @DisplayName("Prueba de división: entre cero lanza excepción")
    void testDividirEntreCero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calc.dividir(5, 0);
        });
        assertEquals("No se puede dividir entre cero", exception.getMessage());
    }

    @Test
    @DisplayName("Prueba de división: cero entre número")
    void testDividirCeroEntreNumero() {
        assertEquals(0.0, calc.dividir(0, 5), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
        "10, 2, 5",
        "9, 3, 3",
        "-10, 2, -5",
        "7, 2, 3.5"
    })
    @DisplayName("Prueba de división: múltiples casos")
    void testDividirParametrizado(double a, double b, double esperado) {
        assertEquals(esperado, calc.dividir(a, b), 0.001);
    }

    // ===== PRUEBAS DE POTENCIA =====
    @Test
    @DisplayName("Prueba de potencia: básica")
    void testPotenciaBasica() {
        assertEquals(8.0, calc.potencia(2, 3), 0.001);
    }

    @Test
    @DisplayName("Prueba de potencia: exponente cero")
    void testPotenciaExponenteCero() {
        assertEquals(1.0, calc.potencia(5, 0), 0.001);
    }

    @Test
    @DisplayName("Prueba de potencia: exponente negativo")
    void testPotenciaExponenteNegativo() {
        assertEquals(0.25, calc.potencia(2, -2), 0.001);
    }

    // ===== PRUEBAS DE RAÍZ CUADRADA =====
    @Test
    @DisplayName("Prueba de raíz cuadrada: número positivo")
    void testRaizCuadradaPositivo() {
        assertEquals(3.0, calc.raizCuadrada(9), 0.001);
    }

    @Test
    @DisplayName("Prueba de raíz cuadrada: cero")
    void testRaizCuadradaCero() {
        assertEquals(0.0, calc.raizCuadrada(0), 0.001);
    }

    @Test
    @DisplayName("Prueba de raíz cuadrada: número negativo lanza excepción")
    void testRaizCuadradaNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.raizCuadrada(-9);
        });
        assertEquals("No se puede calcular la raíz cuadrada de un número negativo", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "4, 2",
        "16, 4",
        "25, 5",
        "1, 1"
    })
    @DisplayName("Prueba de raíz cuadrada: múltiples casos")
    void testRaizCuadradaParametrizado(double numero, double esperado) {
        assertEquals(esperado, calc.raizCuadrada(numero), 0.001);
    }

    // ===== PRUEBAS DE MÓDULO =====
    @Test
    @DisplayName("Prueba de módulo: básica")
    void testModuloBasico() {
        assertEquals(1.0, calc.modulo(7, 3), 0.001);
    }

    @Test
    @DisplayName("Prueba de módulo: divisor cero lanza excepción")
    void testModuloDivisorCero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calc.modulo(5, 0);
        });
        assertEquals("No se puede calcular el módulo con divisor cero", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "10, 3, 1",
        "15, 4, 3",
        "20, 5, 0"
    })
    @DisplayName("Prueba de módulo: múltiples casos")
    void testModuloParametrizado(double a, double b, double esperado) {
        assertEquals(esperado, calc.modulo(a, b), 0.001);
    }

    // ===== PRUEBAS DE VALOR ABSOLUTO =====
    @Test
    @DisplayName("Prueba de valor absoluto: número negativo")
    void testValorAbsolutoNegativo() {
        assertEquals(5.0, calc.valorAbsoluto(-5), 0.001);
    }

    @Test
    @DisplayName("Prueba de valor absoluto: número positivo")
    void testValorAbsolutoPositivo() {
        assertEquals(5.0, calc.valorAbsoluto(5), 0.001);
    }

    @Test
    @DisplayName("Prueba de valor absoluto: cero")
    void testValorAbsolutoCero() {
        assertEquals(0.0, calc.valorAbsoluto(0), 0.001);
    }

    // ===== PRUEBAS DE FACTORIAL =====
    @Test
    @DisplayName("Prueba de factorial: número pequeño")
    void testFactorialPequeño() {
        assertEquals(120, calc.factorial(5));
    }

    @Test
    @DisplayName("Prueba de factorial: cero")
    void testFactorialCero() {
        assertEquals(1, calc.factorial(0));
    }

    @Test
    @DisplayName("Prueba de factorial: uno")
    void testFactorialUno() {
        assertEquals(1, calc.factorial(1));
    }

    @Test
    @DisplayName("Prueba de factorial: número negativo lanza excepción")
    void testFactorialNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.factorial(-5);
        });
        assertEquals("El factorial no está definido para números negativos", exception.getMessage());
    }

    @Test
    @DisplayName("Prueba de factorial: número muy grande lanza excepción")
    void testFactorialMuyGrande() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.factorial(21);
        });
        assertEquals("El factorial es demasiado grande para n > 20", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "3, 6",
        "4, 24",
        "6, 720",
        "10, 3628800"
    })
    @DisplayName("Prueba de factorial: múltiples casos")
    void testFactorialParametrizado(int n, long esperado) {
        assertEquals(esperado, calc.factorial(n));
    }

    // ===== PRUEBAS DE PORCENTAJE =====
    @Test
    @DisplayName("Prueba de porcentaje: básico")
    void testCalcularPorcentajeBasico() {
        assertEquals(20.0, calc.calcularPorcentaje(100, 20), 0.001);
    }

    @Test
    @DisplayName("Prueba de porcentaje: 50%")
    void testCalcularPorcentajeMitad() {
        assertEquals(50.0, calc.calcularPorcentaje(100, 50), 0.001);
    }

    @ParameterizedTest
    @CsvSource({
        "200, 10, 20",
        "50, 20, 10",
        "150, 30, 45"
    })
    @DisplayName("Prueba de porcentaje: múltiples casos")
    void testCalcularPorcentajeParametrizado(double numero, double porcentaje, double esperado) {
        assertEquals(esperado, calc.calcularPorcentaje(numero, porcentaje), 0.001);
    }

    // ===== PRUEBAS DE ES PAR =====
    @Test
    @DisplayName("Prueba esPar: número par")
    void testEsParVerdadero() {
        assertTrue(calc.esPar(4));
    }

    @Test
    @DisplayName("Prueba esPar: número impar")
    void testEsParFalso() {
        assertFalse(calc.esPar(5));
    }

    @Test
    @DisplayName("Prueba esPar: cero es par")
    void testEsParCero() {
        assertTrue(calc.esPar(0));
    }

    @Test
    @DisplayName("Prueba esPar: número negativo par")
    void testEsParNegativo() {
        assertTrue(calc.esPar(-4));
    }

    // ===== PRUEBAS DE ES PRIMO =====
    @Test
    @DisplayName("Prueba esPrimo: número primo")
    void testEsPrimoVerdadero() {
        assertTrue(calc.esPrimo(7));
    }

    @Test
    @DisplayName("Prueba esPrimo: número no primo")
    void testEsPrimoFalso() {
        assertFalse(calc.esPrimo(8));
    }

    @Test
    @DisplayName("Prueba esPrimo: uno no es primo")
    void testEsPrimoUno() {
        assertFalse(calc.esPrimo(1));
    }

    @Test
    @DisplayName("Prueba esPrimo: dos es primo")
    void testEsPrimoDos() {
        assertTrue(calc.esPrimo(2));
    }

    @ParameterizedTest
    @CsvSource({
        "3, true",
        "5, true",
        "11, true",
        "13, true",
        "4, false",
        "9, false",
        "15, false"
    })
    @DisplayName("Prueba esPrimo: múltiples casos")
    void testEsPrimoParametrizado(int numero, boolean esperado) {
        assertEquals(esperado, calc.esPrimo(numero));
    }

    // ===== PRUEBAS DE MCD =====
    @Test
    @DisplayName("Prueba MCD: básico")
    void testMcdBasico() {
        assertEquals(6, calc.mcd(12, 18));
    }

    @Test
    @DisplayName("Prueba MCD: uno de los números es cero")
    void testMcdConCero() {
        assertEquals(5, calc.mcd(5, 0));
    }

    @Test
    @DisplayName("Prueba MCD: números negativos")
    void testMcdNegativos() {
        assertEquals(4, calc.mcd(-12, 8));
    }

    @ParameterizedTest
    @CsvSource({
        "48, 18, 6",
        "100, 50, 50",
        "7, 13, 1",
        "20, 30, 10"
    })
    @DisplayName("Prueba MCD: múltiples casos")
    void testMcdParametrizado(int a, int b, int esperado) {
        assertEquals(esperado, calc.mcd(a, b));
    }

    // ===== PRUEBAS DE MCM =====
    @Test
    @DisplayName("Prueba MCM: básico")
    void testMcmBasico() {
        assertEquals(36, calc.mcm(12, 18));
    }

    @Test
    @DisplayName("Prueba MCM: con cero lanza excepción")
    void testMcmConCero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.mcm(5, 0);
        });
        assertEquals("El MCM no está definido para cero", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "4, 6, 12",
        "3, 5, 15",
        "10, 15, 30",
        "7, 14, 14"
    })
    @DisplayName("Prueba MCM: múltiples casos")
    void testMcmParametrizado(int a, int b, int esperado) {
        assertEquals(esperado, calc.mcm(a, b));
    }
}
