package org.example;

import java.util.*;

public class infoMutxamelApp {
    static TreeSet<Comunicado> comunicadosEmitidos;

    static void generarRuidoPositivo(){
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for (int i =0; i>=5; ++i){
        Random rnd = new Random();
            StringBuilder texto = new StringBuilder();
            for (int y = 0; y <=100; i++) {
                texto.append(letras.charAt(rnd.nextInt(letras.length())));
            }
            String textoString = texto.toString();
    EventoFestivo evento = new EventoFestivo("CM"+i,textoString,1,EstadoMensaje.PENDIENTE);
    evento.aplicarRuido();
    comunicadosEmitidos.add(evento);
    }
    }
    static void mostrarComunicado(){
    for (Comunicado a : comunicadosEmitidos){
        a.leer();

    }
    }
    static void insertarComunicado(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("INSERTANDO NUEVO COMUNICADO...");
        String texto = teclado.nextLine();
        redactarComunicado(texto);
    }
    static Comunicado redactarComunicado(String texto){
        boolean repetir = true;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Elige el tipo de comunicado[FIESTAS,HUELGA]");
        String tipo = teclado.nextLine();
        while(repetir){
            if (tipo.equals("FIESTAS") || tipo.equals("Huelga")){
                repetir=false;
                int numero = comunicadosEmitidos.size()-1;
                Random rnd = new Random();
                if (tipo.equals("FIESTAS")){
                    int valoracion = rnd.nextInt(4)+1;


                    EventoFestivo festivo = new EventoFestivo("CM"+numero,texto,valoracion,EstadoMensaje.DIFUNDIDO);
                    System.out.println("Inserta la ubicacion");
                    String ubi = teclado.nextLine();
                    System.out.println("La actividad es gratuita?(S/N)");
                    String decision = teclado.nextLine();
                    if (decision.equals("S")){
                        boolean pagar = true;
                        festivo.setGratuito(pagar);
                    }else {
                        boolean pagar = false;
                        festivo.setGratuito(pagar);
                    }
                    festivo.setUbicacion(ubi);
                    festivo.leer();
                    return festivo;
                }else {
                    int valoracion = rnd.nextInt(6)+5;
                    NoticiaHuelga noticia = new NoticiaHuelga("CM"+numero,texto,valoracion,EstadoMensaje.PENDIENTE);
                    noticia.leer();
                    return noticia;
                }

            }else {
                System.out.println("tipo no valido. Inserta un valor correcto");
            }

        }

        return null;


    }
    static void revisarComunidadosHuelga(){
        for (Comunicado a : comunicadosEmitidos){
            if (a instanceof NoticiaHuelga){
                if (a.getEstado().equals(EstadoMensaje.PENDIENTE)){
                    if (((NoticiaHuelga) a).evaluarRiesgo()){
                        ((NoticiaHuelga) a).censurar();
                        System.out.print("Censurando. . .");
                    }else {
                        ((NoticiaHuelga) a).tramitar();
                        System.out.print("Tramitando. . .");
                    }

                }
            }
            a.leer();

        }

    }
    static void limpiarCriticas(){
        Iterator<Comunicado> iterador = comunicadosEmitidos.iterator();

        while (iterador.hasNext()) {
            Comunicado comunicado =iterador.next();

            if (comunicado.getEstado().equals(EstadoMensaje.BLOQUEADO)){
                iterador.remove();
            }
        }

    }
    static void generarEstadisticas(){
       double contadorP = 0;
       double contadorD = 0;
       double contadorB = 0;
       int cantidad = 0;
        for (Comunicado a : comunicadosEmitidos){
            if (a.getEstado().equals(EstadoMensaje.PENDIENTE)){
                contadorP++;
            } else if (a.getEstado().equals(EstadoMensaje.DIFUNDIDO)){
                contadorD++;

            }else {
                contadorB++;
            }
            cantidad++;
        }
        String p= String.valueOf(contadorP);
        String d=String.valueOf(contadorD);
        String b=String.valueOf(contadorB);
        int porcentajeP= (int) (contadorP*100/cantidad);
        int porcentajeD= (int) (contadorD*100/cantidad);
        int porcentajeB= (int) (contadorB*100/cantidad);
        String porP= " ("+String.valueOf(porcentajeP)+".00%)";
        String porD= " ("+String.valueOf(porcentajeD)+".00%)";
        String porB= " ("+String.valueOf(porcentajeB)+".00%)";

        String[][] estadisticas = {
                {"DIFUNDIDO: ",d , porD },
                {"PENDIENTE: ", p, porP },
                {"Bloqueado: ", b, porB },

        };
        for (int i = 0; i < estadisticas.length; i++) {
            for (int j = 0; j < estadisticas[i].length; j++) {
                System.out.println(estadisticas[i][j]);
            }
        }



    }

    static void main() {

    }
}
