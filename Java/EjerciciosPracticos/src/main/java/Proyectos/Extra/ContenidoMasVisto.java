package main.java.Proyectos.Extra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ContenidoMasVisto {

    // Clase interna para modelar los registros de cada serie
    static class Serie {
        String nombre;
        int minutos;

        public Serie(String nombre, int minutos) {
            this.nombre = nombre;
            this.minutos = minutos;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Serie> coleccionSeries = new ArrayList<>();

        while (true) {
            System.out.println("Introduce el nombre de tu serie... (o 'salir' para terminar)");
            String nombre = scanner.nextLine().trim();

            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("Minutos:");
            int minutos;
            try {
                minutos = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada de minutos no válida. Por favor, introduce un número entero.");
                continue;
            }

            // Si la serie ya se introdujo con anterioridad, acumulamos el tiempo
            boolean encontrada = false;
            for (Serie s : coleccionSeries) {
                if (s.nombre.equalsIgnoreCase(nombre)) {
                    s.minutos += minutos;
                    encontrada = true;
                    break;
                }
            }

            // Si es una serie nueva, la añadimos a la lista
            if (!encontrada) {
                coleccionSeries.add(new Serie(nombre, minutos));
            }
        }

        // Filtrar las series que cumplan con la condición de haber sido vistas al menos 30 minutos
        ArrayList<Serie> seriesFiltradas = new ArrayList<>();
        for (Serie s : coleccionSeries) {
            if (s.minutos >= 30) {
                seriesFiltradas.add(s);
            }
        }

        // Ordenar la lista resultante por minutos de reproducción (de menor a mayor)
        Collections.sort(seriesFiltradas, new Comparator<Serie>() {
            @Override
            public int compare(Serie s1, Serie s2) {
                return Integer.compare(s1.minutos, s2.minutos);
            }
        });

        // Mostrar la salida formateada solicitada
        System.out.println("\nSalida:");
        System.out.println("Las series que has visto durante más de 30 minutos son:");
        for (Serie s : seriesFiltradas) {
            System.out.println(s.nombre + " con " + s.minutos + " minutos.");
        }
    }
}
