package Proyectos.Parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Parking {

    private String        ciudad;
    private int           plazas_totales;
    private double        precio_minuto;
    private List<Ticket>  clientesActuales;

    public Parking(String ciudad, int plazas_totales, double precio_minuto) {
        this.ciudad           = ciudad;
        this.plazas_totales   = plazas_totales;
        this.precio_minuto    = precio_minuto;
        this.clientesActuales = new ArrayList<>();
    }

    // Getters
    public String       getCiudad()          { return ciudad;           }
    public int          getPlazas_totales()   { return plazas_totales;   }
    public double       getPrecio_minuto()    { return precio_minuto;    }
    public List<Ticket> getClientesActuales() { return clientesActuales; }

    // -------------------------------------------------------
    // Genera entre 1 y 10 tickets aleatorios (RECOGIDO)
    // sin matrículas repetidas
    // -------------------------------------------------------
    public void generarClientesAleatorios() {
        String letras  = "BCDFGHJKLMNPQRSTVWXYZ";
        String numeros = "0123456789";
        Random rnd     = new Random();

        int cantidad = rnd.nextInt(10) + 1;   // 1..10

        while (clientesActuales.size() < cantidad) {
            // Generar matrícula aleatoria 4 dígitos + 3 letras
            StringBuilder mat = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                mat.append(numeros.charAt(rnd.nextInt(numeros.length())));
            }
            for (int i = 0; i < 3; i++) {
                mat.append(letras.charAt(rnd.nextInt(letras.length())));
            }
            String matricula = mat.toString();

            // Comprobar que no está duplicada
            boolean existe = clientesActuales.stream()
                    .anyMatch(t -> t.getMatricula().equals(matricula));

            if (!existe) {
                int minutos = rnd.nextInt(300) + 1;   // 1..300 minutos
                clientesActuales.add(new Ticket(matricula, minutos, Estado.RECOGIDO));
            }
        }
    }

    // -------------------------------------------------------
    // Imprime la lista de clientes actuales
    // -------------------------------------------------------
    public void mostrarClientesActuales() {
        System.out.println("*** PARKING " + ciudad.toUpperCase() + " ***");
        for (int i = 0; i < clientesActuales.size(); i++) {
            System.out.println((i + 1) + ". " + clientesActuales.get(i));
        }
    }

    // -------------------------------------------------------
    // Añade un ticket a la lista de clientes actuales
    // -------------------------------------------------------
    public void anyadirCliente(Ticket ticket) {
        clientesActuales.add(ticket);
    }

    // -------------------------------------------------------
    // Busca un ticket por matrícula; devuelve null si no existe
    // -------------------------------------------------------
    public Ticket validarTicket(String matricula) {
        for (Ticket t : clientesActuales) {
            if (t.getMatricula().equalsIgnoreCase(matricula)) {
                return t;
            }
        }
        return null;
    }

    // -------------------------------------------------------
    // Imprime la lista ordenada por minutos (ascendente)
    // -------------------------------------------------------
    public void mostrarClientesOrdenadosPorMinutos() {
        List<Ticket> ordenada = new ArrayList<>(clientesActuales);
        ordenada.sort(Comparator.comparingInt(Ticket::getMinutos));
        System.out.println("*** PARKING " + ciudad.toUpperCase() + " ***");
        for (int i = 0; i < ordenada.size(); i++) {
            System.out.println((i + 1) + ". " + ordenada.get(i));
        }
    }

    // -------------------------------------------------------
    // Indica si el parking está completo
    // -------------------------------------------------------
    public boolean estaCompleto() {
        return clientesActuales.size() >= plazas_totales;
    }

    // -------------------------------------------------------
    // Plazas libres
    // -------------------------------------------------------
    public int plazasLibres() {
        return plazas_totales - clientesActuales.size();
    }
}
