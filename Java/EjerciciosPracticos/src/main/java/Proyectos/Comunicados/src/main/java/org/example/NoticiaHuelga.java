package org.example;

import java.util.ArrayList;
import java.util.List;

public class NoticiaHuelga extends Comunicado implements AccionPolitica {
    public NoticiaHuelga(String id, String texto, Integer valoracionPrioridad, EstadoMensaje estado) {
        super(id, texto, valoracionPrioridad, estado);
    }

    @Override
    public boolean evaluarRiesgo() {
        ArrayList<String> palabras = new ArrayList<>(List.of(getTexto().split(" ")));
        for (String a : palabras){
            if (a.equals("ratio")|| a.equals("manifestacion") || a.equals("huelga")){
                return true;
            }
        }
        return false;
    }

    @Override
    public void tramitar() {
        setEstado(EstadoMensaje.DIFUNDIDO);
    }

    @Override
    public void censurar() {
        setEstado(EstadoMensaje.BLOQUEADO);

    }
}
