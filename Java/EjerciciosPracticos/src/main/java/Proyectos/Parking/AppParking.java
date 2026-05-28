package Proyectos.Parking;

import java.util.Scanner;

public class AppParking {

    static Parking parking = new Parking("Mutxamel Centro", 1000, 0.025);

    public static void main(String[] args) {
        // Ejercicio 2: generar clientes aleatorios e imprimirlos
        parking.generarClientesAleatorios();
        parking.mostrarClientesActuales();

        System.out.println();
        app1();

        System.out.println();
        app2();

        System.out.println();
        app3();
    }

    // =========================================================
    // APP 1 — Simulación de cola de entrada al Parking
    // =========================================================
    static void app1() {
        System.out.println("*** APP ACCESO ***");

        // a) Estado del parking
        if (parking.estaCompleto()) {
            System.out.println("COMPLETO");
        } else {
            System.out.println("LIBRE (" + parking.plazasLibres() + " plazas libres).");
        }

        // b) Simular entrada de un nuevo cliente
        Ticket ticket = new Ticket("", 1, Estado.PENDIENTE);
        ticket.generar();
        parking.anyadirCliente(ticket);
        ticket.recoger();

        // Prueba: mostrar lista actualizada
        parking.mostrarClientesActuales();
    }

    // =========================================================
    // APP 2 — Pagar importe del ticket
    // =========================================================
    static void app2() {
        System.out.println("*** PAGO DE TICKETS ***");

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu matricula: ");
        String matricula = sc.nextLine().trim();

        System.out.println("Validando...");
        Ticket ticket = parking.validarTicket(matricula);

        if (ticket == null) {
            System.out.println("El ticket no existe.");
            return;
        }

        // a) Mostrar importe
        double importe = ticket.getMinutos() * parking.getPrecio_minuto();
        System.out.println("Minutos: " + ticket.getMinutos()
                + " - Precio por minuto: " + parking.getPrecio_minuto() + "€");
        System.out.printf("Importe a pagar: %.3f€.%n", importe);

        // b) Simular pago
        ticket.pagar();
        System.out.println("Buen viaje!");

        // Prueba: mostrar lista actualizada
        parking.mostrarClientesActuales();
    }

    // =========================================================
    // APP 3 — Pagar importe sin ticket (perdido) — clase anónima
    // =========================================================
    static void app3() {
        System.out.println("*** APP TRABAJADORES ***");

        // a) Mostrar lista ordenada por minutos
        parking.mostrarClientesOrdenadosPorMinutos();

        // b) Cobro mediante clase anónima que implementa Acciones
        Scanner sc = new Scanner(System.in);

        Acciones trabajador = new Acciones() {

            @Override
            public void generar() {
                // No se usa en esta app
            }

            @Override
            public void recoger() {
                // No se usa en esta app
            }

            @Override
            public void pagar() {
                System.out.print("Introduce los minutos a cobrar: ");
                int minutos = Integer.parseInt(sc.nextLine().trim());
                double importe = minutos * parking.getPrecio_minuto();
                System.out.println("Minutos: " + minutos
                        + " - Precio por minuto: " + parking.getPrecio_minuto() + "€");
                System.out.printf("Importe a pagar: %.3f€.%n", importe);
                System.out.println("Pagando...");
                System.out.println("Pago realizado. El cliente puede abandonar el parking.");
            }
        };

        trabajador.pagar();
    }
}
