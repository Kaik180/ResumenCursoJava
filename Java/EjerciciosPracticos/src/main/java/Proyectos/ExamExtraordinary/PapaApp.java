package main.java.Proyectos.ExamExtraordinary;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PapaApp {

    static Scanner teclado = new Scanner(System.in);

    static LinkedHashSet<Peregrino> registrados =  new LinkedHashSet<>();
    static Queue<Peregrino> fila = new LinkedList<>();

    public static void main(String[] args) {

        registrados.add(new Nacional(1,"Sor Quisquilla","Madriz"));
        registrados.add(new Nacional(2,"Obispo de Orihuela","Alicante"));
        registrados.add(new Nacional(3,"Mario Vaquerizo","Toledo"));
        registrados.add(new Extranjero(4,"Llados","EEUU"));
        registrados.add(new Extranjero(5,"Meloni","Italia"));
        mostrarRegistrados();

        llegadaPeregrino();
        llegadaPeregrino();
        llegadaPeregrino();

        bendicionPapal();
        mostrarRegistrados();

        peregrinosExtranjeros();

    }

    public static void mostrarRegistrados(){

        System.out.println(registrados);

    }

    public static void llegadaPeregrino(){

        System.out.println("> Intorduce num reserva: ");
        Integer numReserva = teclado.nextInt();
        teclado.nextLine();

        Peregrino peregrino = buscarPeregrino(numReserva);

        if (peregrino!=null){
            fila.offer(peregrino);
            System.out.println("[+] Fiel " + peregrino.getNombre() + " añadido a la fila.");
        }

    }

    public static Peregrino buscarPeregrino(Integer numReserva){

        for (Peregrino peregrino : registrados){

            if (peregrino.getNumReserva().equals(numReserva)){

                if (peregrino.getEstado().equals(EstadoPeregrino.BENDECIDO)){
                    System.out.println("¡Pecador! Ya has recibido tu besico, deja paso a otros");
                    return null;
                }else{
                    peregrino.setEstado(EstadoPeregrino.EN_COLA);
                    return peregrino;
                }

            }

        }

        System.out.println("Reserva no encontrada.");
        return null;

    }

    public static void bendicionPapal(){

        if (fila.isEmpty()){
            System.out.println("Su Santidad está descansando, no hay nadie en la cola.");
        }else{

            System.out.println("> El Papa bendice: ");

            while(!fila.isEmpty()){
                Peregrino peregrino = fila.peek();
                System.out.println("[!] El Papa le da un besico en la frente a " + fila.poll().getNombre() + " y l@ despacha con una sonrisa");
                modificarEstadoBendecido(peregrino);
            }

        }

    }

    public static void modificarEstadoBendecido(Peregrino peregrino){

        for (Peregrino pere : registrados){
            if (peregrino.equals(pere)){
                pere.setEstado(EstadoPeregrino.BENDECIDO);
                break;
            }
        }

    }

    public static void peregrinosExtranjeros(){

        System.out.println("> Lista de extranjeros bendecidos: ");

        for (Peregrino peregrino : registrados){
            if (peregrino instanceof Extranjero && peregrino.getEstado().equals(EstadoPeregrino.BENDECIDO)){
                System.out.println("[!] Extranjero " + peregrino.getNombre() + " bendecido por el Papa.");
            }
        }

    }


}
