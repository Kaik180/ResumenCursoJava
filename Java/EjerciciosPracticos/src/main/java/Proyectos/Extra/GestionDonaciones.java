package main.java.Proyectos.Extra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GestionDonaciones {
    static class Donante {
        String nombre;
        double totalAportado;

        public Donante(String nombre, double totalAportado) {
            this.nombre = nombre;
            this.totalAportado = totalAportado;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Donante> listaDonantes = new ArrayList<>();

        while (true) {
            System.out.println("Introduce el nombre del donante (o 'cerrar' para finalizar):");
            String nombre = scanner.nextLine().trim();
            if (nombre.equalsIgnoreCase("cerrar")) break;

            System.out.println("Introduce el importe de la donación (€):");
            double importe = Double.parseDouble(scanner.nextLine().trim());

            boolean encontrado = false;
            for (Donante d : listaDonantes) {
                if (d.nombre.equalsIgnoreCase(nombre)) {
                    d.totalAportado += importe; // Acumulación de dinero
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                listaDonantes.add(new Donante(nombre, importe));
            }
        }

        // Filtrar donantes con aportaciones >= 50€
        ArrayList<Donante> premium = new ArrayList<>();
        for (Donante d : listaDonantes) {
            if (d.totalAportado >= 50.0) {
                premium.add(d);
            }
        }

        // Ordenar de MENOR a MAYOR (Ascendente) por importe aportado
        Collections.sort(premium, new Comparator<Donante>() {
            @Override
            public int compare(Donante d1, Donante d2) {
                return Double.compare(d1.totalAportado, d2.totalAportado);
            }
        });

        System.out.println("\nDonantes destacados (>= 50€):");
        for (Donante d : premium) {
            System.out.println("- " + d.nombre + " con un total de " + d.totalAportado + "€.");
        }
    }
}
