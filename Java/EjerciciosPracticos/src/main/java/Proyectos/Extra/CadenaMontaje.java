package main.java.Proyectos.Extra;

import java.util.Scanner;

public class CadenaMontaje {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los comandos de los sensores:");
        String entrada = scanner.nextLine().trim();

        // 1. Validar finalización con 'X' y que sea única
        if (!entrada.endsWith("X") || entrada.indexOf('X') != entrada.length() - 1) {
            System.out.println("El formato no es correcto.");
            return;
        }

        // Validar caracteres permitidos (P, E, C, X)
        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);
            if (c != 'P' && c != 'E' && c != 'C' && c != 'X') {
                System.out.println("El formato no es correcto.");
                return;
            }
        }

        // 2. Procesar lógica de empaquetado
        StringBuilder resultado = new StringBuilder();
        int piezasLote = 0;
        boolean primerLote = true;

        for (int i = 0; i < entrada.length(); i++) {
            char actual = entrada.charAt(i);

            if (actual == 'P') {
                piezasLote++;
            } else if (actual == 'E') {
                if (piezasLote > 0) piezasLote--; // Descarta una pieza defectuosa
            } else if (actual == 'C' || actual == 'X') {
                if (!primerLote) {
                    resultado.append(" ");
                }
                resultado.append(piezasLote);
                primerLote = false;

                if (actual == 'C') {
                    piezasLote = 0; // Se resetea el contador para el nuevo lote
                }
            }
        }
        System.out.println(resultado.toString());
    }
}
