package Ejercicios.Intermedio;
import java.util.Arrays;
import java.util.Scanner;

public class OrdenarNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[5];

        System.out.println("Introduce 5 números enteros desordenados:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        // Ordenamos el array de menor a mayor automáticamente
        Arrays.sort(numeros);

        System.out.println("\nNúmeros ordenados de menor a mayor:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println(); // Salto de línea final
    }
}
