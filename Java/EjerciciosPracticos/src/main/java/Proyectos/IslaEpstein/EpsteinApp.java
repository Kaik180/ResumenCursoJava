package Proyectos.IslaEpstein;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

public class EpsteinApp {

    static Scanner teclado = new Scanner(System.in);

    static ArrayList<Famoso> listaEpstein = new ArrayList<>();

    public static void main(String[] args) {

        procesarDatos();

        System.out.println("\n**** APP MANTENIMIENTO LISTA EPSTEIN ****");

        nuevoFamoso();

        buscarFamoso();

        eliminarMenores();

        Estadistica estadistica = generarEstadisticas();

        estadistica.verPoliticos();
        estadistica.informeJuzgado();
        estadistica.verRanking();

    }

    public static void procesarDatos(){

        System.out.println("\nProcesando datos desde EntradaDatos...");

        EntradaDatos.generarDatos();
        Queue<Famoso> cola = EntradaDatos.getDatosActuales();

        while(!cola.isEmpty()){
            System.out.println(" --Grabando " + cola.peek());
            listaEpstein.add(cola.poll());
        }

        System.out.println("Procesado de datos finalizado.");

    }

    public static void nuevoFamoso(){

        System.out.println("\nInsertando famoso...");
        Famoso famoso = pedirDatos();
        listaEpstein.add(famoso);
        System.out.println("Famoso insertado.");

    }

    public static void buscarFamoso(){

        System.out.println("\nBuscando famoso...");
        Famoso famoso = pedirDatos();
        if (listaEpstein.contains(famoso)){
            System.out.println("El famoso HA ACUDIDO a la Isla...");
        }else{
            System.out.println("El famoso no está en la lista Epstein. No ha acudido a la Isla...");
        }

    }

    public static Famoso pedirDatos(){

        System.out.println("Nombre: ");
        String nombre = teclado.next();
        System.out.println("País: ");
        String pais = teclado.next();
        System.out.println("Profesión: ");
        String profesion = teclado.next();
        System.out.println("Edad: ");
        int edad = teclado.nextInt();
        teclado.nextLine();
        return new Famoso(nombre,pais,profesion,edad);
    }

    public static void eliminarMenores(){

        System.out.println("\nEliminando menores de edad...");

        Iterator<Famoso> it = listaEpstein.iterator();

        while (it.hasNext()){

            Famoso famoso = it.next();

            if (famoso.getEdad()<18){
                System.out.println(" -- " + famoso.getNombre() + " fulminado.");
                it.remove();
            }

        }

    }

    public static Estadistica generarEstadisticas(){

        System.out.println("\nGenerando estadísticas...");

        return new Estadistica(listaEpstein);

    }

}
