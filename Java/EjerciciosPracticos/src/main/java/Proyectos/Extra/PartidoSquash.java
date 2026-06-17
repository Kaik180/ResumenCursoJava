package main.java.Proyectos.Extra;

import java.util.Scanner;

public class PartidoSquash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los tantos para cada jugador:");
        String entrada = scanner.nextLine().trim();

        // 1. Validar que termine en 'F' y que no aparezca en ninguna otra posición
        if (!entrada.endsWith("F") || entrada.indexOf('F') != entrada.length() - 1) {
            System.out.println("El formato no es correcto.");
            return;
        }

        // Validar que solo contenga los caracteres válidos permitidos (A, B, S, F)
        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);
            if (c != 'A' && c != 'B' && c != 'S' && c != 'F') {
                System.out.println("El formato no es correcto.");
                return;
            }
        }

        // 2. Procesar el partido y calcular el marcador
        StringBuilder marcadorFinal = new StringBuilder();
        int puntosA = 0;
        int puntosB = 0;
        boolean primerSet = true;

        for (int i = 0; i < entrada.length(); i++) {
            char actual = entrada.charAt(i);

            if (actual == 'A') {
                puntosA++;
            } else if (actual == 'B') {
                puntosB++;
            } else if (actual == 'S' || actual == 'F') {
                // Añadimos espacio de separación si no es el primer set impreso
                if (!primerSet) {
                    marcadorFinal.append(" ");
                }
                marcadorFinal.append(puntosA).append("-").append(puntosB);
                primerSet = false;

                // Si fue fin de set (S), se reinician las puntuaciones parciales
                if (actual == 'S') {
                    puntosA = 0;
                    puntosB = 0;
                }
            }
        }

        // Imprimir el resultado final obtenido
        System.out.println(marcadorFinal.toString());
    }
}
