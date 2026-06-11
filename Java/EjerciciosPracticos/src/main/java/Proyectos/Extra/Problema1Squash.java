package Proyectos.Extra;

import java.util.Scanner;

public class Problema1Squash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los tantos para cada jugador:");
        String entrada = scanner.nextLine().trim();

        // 1. Validar formato: Debe terminar en 'F' y no tener otra 'F' antes
        if (!entrada.endsWith("F") || entrada.indexOf('F') != entrada.length() - 1) {
            System.out.println("El formato no es correcto.");
            return;
        }

        // Validar caracteres permitidos (A, B, S, F)
        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);
            if (c != 'A' && c != 'B' && c != 'S' && c != 'F') {
                System.out.println("El formato no es correcto.");
                return;
            }
        }

        // 2. Procesar la puntuación
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
                // Si es un fin de set ('S') o fin de partido ('F') se añade el marcador acumulado
                if (!primerSet) {
                    marcadorFinal.append(" ");
                }
                marcadorFinal.append(puntosA).append("-").append(puntosB);
                primerSet = false;

                // Si es 'S', reiniciamos los puntos para el siguiente set
                if (actual == 'S') {
                    puntosA = 0;
                    puntosB = 0;
                }
            }
        }

        System.out.println(marcadorFinal.toString());
    }
}