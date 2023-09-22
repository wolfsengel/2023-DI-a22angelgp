package com.sanclemen.primerproxecto;

import java.util.Scanner; // Importación de la clase Scanner.

public class PrimerProxecto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res = 0;
        String operacion;
        boolean comprobar;

        do {
            String numero1;
            do {
                System.out.println("\n Por favor, dame el primer número de la operación. ");
                numero1 = sc.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            var n1 = Double.parseDouble(numero1);
            // Fin de la verificación de los datos puestos por el usuario del número 1.

            do {
                System.out.println("\n ¿Que operación desea hacer? (Solo coloque un signo)");
                System.out.println("""
                                   Teniendo en cuenta que: 
                                    + = sumar 
                                    - = restar 
                                    x = multiplicar 
                                    / = dividir 
                                    * = elevar primer n\u00famero al segundo numero.
                                    % = residuo""");
                operacion = sc.nextLine();
                comprobar = operacion.equals("+") || operacion.equals("-") || operacion.equals("x")
                        || operacion.equals("X") || operacion.equals("/") || operacion.equals("%")
                        || operacion.equals("*");
            } while (comprobar != true);

            // Verificación de los datos puestos por el usuario del número 2.
            String numero2;
            do {
                System.out.println("\n Por favor, dame el segundo número.");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double n2;
            // Fin de la verificación de los datos puestos por el usuario del número 2.
            n2 = Double.parseDouble(numero2);

            do {
                comprobar = true;
                switch (operacion) {
                    case "+" ->
                        res = n1 + n2;
                    case "-" ->
                        res = n1 - n2;
                    case "x", "X" ->
                        res = n1 * n2;
                    case "/" -> {
                        /* Por tal de evitar errores y añadir números complejos, si el usuario coloca 0 como segundo número, se piensa entonces que el denominador es 0, y por ello añado una condicional que lo verifique, y para hacer el codigo mas dinamico y no solo añadir un 1, le vuelvo a preguntar al usuario que añada un número distinto, podría volver a colocar 0, y es la razón por la que se encuentra en un ciclo, así que mientras n2 sea 0, el código seguirá ejecutando hasta que ponga otro. */
                        while (n2 == 0) {
                            do {
                                System.err.println("""
                                                    En el denominador se encuentra 
                                                   un cero, para evitar errores coloca otro n\u00famero.""");
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                            Double.valueOf(numero2);
                            n2 = Double.parseDouble(numero2);
                        }
                        res = n1 / n2;
                    }
                    case "*" ->
                        res = Math.pow(n1, n2);
                    case "%" -> {
                        while (n2 == 0) {
                            do {
                                System.err.println("""
                                                    En el denominador se encuentra 
                                                   un cero, para evitar errores coloca otro n\u00famero.""");
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                            Double.valueOf(numero2);
                            n2 = Double.parseDouble(numero2);
                        }
                        res = n1 % n2;
                    }
                }
            } while (comprobar != true);

            System.out.println("(" + numero1 + ") " + operacion + " (" + numero2 + ")" + " = " + res);
            System.out.println("\n ¿Desea hacer alguna otra operación? \n");
            System.out.println(" [s/n]");
            do {
                comprobar = true;
                operacion = sc.nextLine();

                switch (operacion) {
                    case "s", "S", "n", "N" -> {
                    }
                    default -> {
                        System.err.println("\n Error, ponga un literal valido. \n");
                        comprobar = false;
                    }
                }
            } while (comprobar != true);
        } while (operacion.equals("s") || operacion.equals("S"));

    }
}
