package Ejercicios.Intermedio;
import java.util.Scanner;

public class SistemaCalificaciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántas notas vas a introducir?: ");
        int cantidad = scanner.nextInt();

        double[] notas = new double[cantidad];
        double suma = 0;

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Introduce la nota del alumno " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            suma += notas[i];
        }

        double promedio = suma / cantidad;
        double max = notas[0];
        double min = notas[0];

        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > max) max = notas[i];
            if (notas[i] < min) min = notas[i];
        }

        System.out.println("\n--- ESTADÍSTICAS ---");
        System.out.println("Nota media de la clase: " + promedio);
        System.out.println("La nota más alta: " + max);
        System.out.println("La nota más baja: " + min);
    }
}
