package Proyectos.Extra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Problema2Streaming {

    // Clase interna para modelar cada serie
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
        ArrayList<Serie> listaSeries = new ArrayList<>();

        while (true) {
            System.out.println("Introduce el nombre de tu serie... (o 'salir' para terminar)");
            String nombre = scanner.nextLine().trim();

            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("Minutos:");
            int minutos = 0;
            try {
                minutos = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Minutos inválidos. Introduce un número.");
                continue;
            }

            // Comprobar si ya existe la serie para acumular el tiempo
            boolean encontrada = false;
            for (Serie s : listaSeries) {
                if (s.nombre.equalsIgnoreCase(nombre)) {
                    s.minutos += minutos;
                    encontrada = true;
                    break;
                }
            }

            if (!encontrada) {
                listaSeries.add(new Serie(nombre, minutos));
            }
        }

        // Filtrar series vistas durante al menos 30 minutos
        ArrayList<Serie> filtradas = new ArrayList<>();
        for (Serie s : listaSeries) {
            if (s.minutos >= 30) {
                filtradas.add(s);
            }
        }

        // Ordenar de menor a mayor por minutos de reproducción (según se deduce del ejemplo)
        Collections.sort(filtradas, new Comparator<Serie>() {
            @Override
            public int compare(Serie s1, Serie s2) {
                return Integer.compare(s1.minutos, s2.minutos);
            }
        });

        System.out.println("Salida:");
        System.out.println("Las series que has visto durante más de 30 minutos son:");
        for (Serie s : filtradas) {
            System.out.println(s.nombre + " con " + s.minutos + " minutos.");
        }
    }
}