package org.example;

public class EventoFestivo extends Comunicado {
    public EventoFestivo(String id, String texto, Integer valoracionPrioridad, EstadoMensaje estado) {
        super(id, texto, valoracionPrioridad, estado);
        this.ubicacion = "PLAZA DEL AYUNTAMIENTO";
        this.gratuito = true;

    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }



    @Override
    public String toString() {
        return "EventoFestivo{" + "id='" + getId() + '\'' + ", texto='" + getTexto() + '\'' + ", valoracionPrioridad=" + getValoracionPrioridad() + ", estado=" + getEstado()+ "ubicacion='" + ubicacion + '\'' + ", gratuito=" + gratuito + '}';
    }

    public void aplicarRuido(){
    setEstado(EstadoMensaje.DIFUNDIDO);
    }

    private String ubicacion;
    private boolean gratuito;

}
