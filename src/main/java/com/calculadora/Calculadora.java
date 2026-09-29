package com.calculadora;

/**
 * Clase Calculadora con operaciones básicas y avanzadas.
 * Incluye validaciones y manejo de casos especiales.
 */
public class Calculadora {

    /**
     * Suma dos números.
     * @param a primer número
     * @param b segundo número
     * @return la suma de a y b
     */
    public double sumar(double a, double b) {
        return a + b;
    }

    /**
     * Resta dos números.
     * @param a primer número
     * @param b segundo número
     * @return la resta de a menos b
     */
    public double restar(double a, double b) {
        return a - b;
    }

    /**
     * Multiplica dos números.
     * @param a primer número
     * @param b segundo número
     * @return el producto de a por b
     */
    public double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     * Divide dos números.
     * @param a dividendo
     * @param b divisor
     * @return el cociente de a entre b
     * @throws ArithmeticException si el divisor es cero
     */
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return a / b;
    }

    /**
     * Calcula la potencia de un número.
     * @param base la base
     * @param exponente el exponente
     * @return base elevado a exponente
     */
    public double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    /**
     * Calcula la raíz cuadrada de un número.
     * @param numero el número
     * @return la raíz cuadrada del número
     * @throws IllegalArgumentException si el número es negativo
     */
    public double raizCuadrada(double numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo");
        }
        return Math.sqrt(numero);
    }

    /**
     * Calcula el módulo (resto de la división) de dos números.
     * @param a dividendo
     * @param b divisor
     * @return el resto de dividir a entre b
     * @throws ArithmeticException si el divisor es cero
     */
    public double modulo(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede calcular el módulo con divisor cero");
        }
        return a % b;
    }

    /**
     * Calcula el valor absoluto de un número.
     * @param numero el número
     * @return el valor absoluto del número
     */
    public double valorAbsoluto(double numero) {
        return Math.abs(numero);
    }

    /**
     * Calcula el factorial de un número entero no negativo.
     * @param n el número
     * @return el factorial de n
     * @throws IllegalArgumentException si n es negativo o mayor que 20
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }
        if (n > 20) {
            throw new IllegalArgumentException("El factorial es demasiado grande para n > 20");
        }
        
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    /**
     * Calcula el porcentaje de un número.
     * @param numero el número base
     * @param porcentaje el porcentaje a calcular
     * @return el porcentaje del número
     */
    public double calcularPorcentaje(double numero, double porcentaje) {
        return (numero * porcentaje) / 100.0;
    }

    /**
     * Determina si un número es par.
     * @param numero el número a verificar
     * @return true si el número es par, false en caso contrario
     */
    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    /**
     * Determina si un número es primo.
     * @param numero el número a verificar
     * @return true si el número es primo, false en caso contrario
     */
    public boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero == 2) {
            return true;
        }
        if (numero % 2 == 0) {
            return false;
        }
        
        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calcula el máximo común divisor (MCD) de dos números.
     * @param a primer número
     * @param b segundo número
     * @return el máximo común divisor
     */
    public int mcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Calcula el mínimo común múltiplo (MCM) de dos números.
     * @param a primer número
     * @param b segundo número
     * @return el mínimo común múltiplo
     * @throws IllegalArgumentException si alguno de los números es cero
     */
    public int mcm(int a, int b) {
        if (a == 0 || b == 0) {
            throw new IllegalArgumentException("El MCM no está definido para cero");
        }
        return Math.abs(a * b) / mcd(a, b);
    }
}
