package Ejercicios.Simples;

import java.util.Scanner;

public class CalculadoraSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Introduce el operador (+, -, *, /): ");
        char operador = scanner.next().charAt(0);

        System.out.print("Introduce el segundo número: ");
        double num2 = scanner.nextDouble();

        double resultado = 0;
        boolean operacionValida = true;

        switch (operador) {
            case '+': resultado = num1 + num2; break;
            case '-': resultado = num1 - num2; break;
            case '*': resultado = num1 * num2; break;
            case '/':
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("Error: No se puede dividir entre cero.");
                    operacionValida = false;
                }
                break;
            default:
                System.out.println("Operador no válido.");
                operacionValida = false;
        }

        if (operacionValida) {
            System.out.println("Resultado: " + resultado);
        }
    }
}