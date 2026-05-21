package Ejercicios.Simples;

import java.util.Scanner;
import java.util.Random;

public class NumeroSecreto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(100) + 1;
        int intento = 0;
        int contadorIntentos = 0;

        System.out.println("¡Bienvenido al número secreto! Intenta adivinar el número entre 1 y 100.");

        while (intento != numeroSecreto) {
            System.out.print("Introduce tu número: ");
            intento = scanner.nextInt();
            contadorIntentos++;

            if (intento < numeroSecreto) {
                System.out.println("El número secreto es MAYOR.");
            } else if (intento > numeroSecreto) {
                System.out.println("El número secreto es MENOR.");
            } else {
                System.out.println("¡Felicidades! Lo has adivinado en " + contadorIntentos + " intentos.");
            }
        }
    }
}