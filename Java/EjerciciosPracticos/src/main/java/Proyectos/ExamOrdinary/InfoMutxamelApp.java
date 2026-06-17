package main.java.Proyectos.ExamOrdinary;

import java.util.*;

public class InfoMutxamelApp {

    static Random aleatorio = new Random();
    static Scanner teclado = new Scanner(System.in);

    static TreeSet<Comunicado> comunicadosEmitidos = new TreeSet<>();

    public static void main(String[] args) {

        generarRuidoPositivo();

        mostrarComunicados();

        insertarComunicado();

        revisarComunicadosHuelga();

        limpiarCriticas();

        generarEstadisticas();

    }

    public static void generarRuidoPositivo(){

        System.out.println("[+] Generando ruido positivo a cascoporro...");

        for (int i = 0; i < 5; i++) {
            String texto = generarTextoAleatorio();
            EventoFestivo comunicado = new EventoFestivo(texto,1,EstadoMensaje.PENDIENTE,"Plaza del ayuntamiento",true);
            comunicado.aplicarRuido();
            comunicadosEmitidos.add(comunicado);
            System.out.println("\n " + comunicado);
        }

        System.out.println("\n Comunicados festivos insertados con éxito.");

    }

    public static String generarTextoAleatorio(){

        String letras = "     ABCDEFGHI    JKLMNO    PQRSTU    VWX      YZ";
        String texto = "";

        for (int i = 0; i < 100; i++) {
            texto += letras.charAt(aleatorio.nextInt(letras.length()-1));
        }

        return texto;
    }

    public static void mostrarComunicados(){

        System.out.println("\n MOSTRANDO LISTA DE COMUNICADOS: ");

        for (Comunicado comunicado : comunicadosEmitidos){
            comunicado.leer();
        }

    }

    public static void insertarComunicado(){

        System.out.println("\n INSERTANDO NUEVO COMUNICADO...");

        System.out.println("Escribe el texto: ");
        String texto = teclado.nextLine();

        Comunicado comunicado = redactarComunicado(texto);
        comunicadosEmitidos.add(comunicado);
        System.out.println("Comunicado insertado. " + comunicado);

    }

    public static Comunicado redactarComunicado(String texto){

        String valores_tipo[] = {"FIESTAS","HUELGA"};

        String tipo = "";
        do{

            System.out.println("Elige el tipo de comunicado [FIESTAS, HUELGA]: ");
            tipo = teclado.nextLine().toUpperCase();

            if (Arrays.asList(valores_tipo).contains(tipo)){
                break;
            }else{
                System.out.println("Tipo no válido. Inserta un valor correcto...");
            }

        }while(true);

        if (tipo.equals("FIESTAS")){
            System.out.println("Inserta la ubicación: ");
            String ubicacion =  teclado.nextLine();
            System.out.println("La actividad es gratuita? (S/N): ");
            char gratis = teclado.nextLine().toUpperCase().charAt(0);
            boolean gratuito = true;

            if (gratis == 'N'){
                gratuito=false;
            }

            int prioridad = aleatorio.nextInt(4)+1;

            return new EventoFestivo(texto,prioridad,EstadoMensaje.DIFUNDIDO,ubicacion,gratuito);

        }else{

            int prioridad = aleatorio.nextInt(6)+5;
            return new NoticiaHuelga(texto,prioridad,EstadoMensaje.PENDIENTE);
        }

    }

    public static void revisarComunicadosHuelga(){

        System.out.println("\n REVISANDO COMUNICADOS...");

        for (Comunicado comunicado : comunicadosEmitidos){

            if (comunicado instanceof NoticiaHuelga && comunicado.getEstado().equals(EstadoMensaje.PENDIENTE)){

                if (((NoticiaHuelga) comunicado).evaluarRiesgo()){
                    System.out.println("Censurando..." + comunicado);
                    ((NoticiaHuelga) comunicado).censurar();
                }else{
                    System.out.println("Tramitando..." + comunicado);
                    ((NoticiaHuelga) comunicado).tramitar();
                }

            }

        }

    }

    public static void limpiarCriticas(){

        System.out.println("\n LIMPIANDO BLOQUEADOS...");
        Iterator<Comunicado> it = comunicadosEmitidos.iterator();

        while(it.hasNext()){

            Comunicado comunicado = it.next();

            if (comunicado.getEstado().equals(EstadoMensaje.BLOQUEADO)){
                it.remove();
            }

        }

    }

    public static void generarEstadisticas(){

        double matriz[][] = new double[3][2];

        for (Comunicado comunicado : comunicadosEmitidos){

            switch(comunicado.getEstado()){
                case DIFUNDIDO:
                    matriz[0][0]++;
                    break;
                case PENDIENTE:
                    matriz[1][0]++;
                    break;
                case BLOQUEADO:
                    matriz[2][0]++;
                    break;
            }

        }

        matriz[0][1]=matriz[0][0]*100/comunicadosEmitidos.size();
        matriz[1][1]=matriz[1][0]*100/comunicadosEmitidos.size();
        matriz[2][1]=matriz[2][0]*100/comunicadosEmitidos.size();

        System.out.println("\n ESTADÍSTICAS DE COMUNICADOS: ");
        System.out.println(" - DIFUNDIDOS: " + matriz[0][0] + " comunicados. (" + matriz[0][1] + "%).");
        System.out.println(" - PENDIENTES: " + matriz[1][0] + " comunicados. (" + matriz[1][1] + "%).");
        System.out.println(" - BLOQUEADOS: " + matriz[2][0] + " comunicados. (" + matriz[2][1] + "%).");
        System.out.println("----------------------------------------------");
        System.out.println("Total de comunicados procesados: " + comunicadosEmitidos.size());

    }

}
