package main.java.Proyectos.ExamOrdinary;

public class EventoFestivo extends Comunicado{

    private String ubicacion;
    private boolean gratuito;

    public EventoFestivo(String texto, int valoracionPrioridad, EstadoMensaje estado, String ubicacion, boolean gratuito) {
        super(texto, valoracionPrioridad, estado);
        this.ubicacion=ubicacion;
        this.gratuito=gratuito;
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
        return "EventoFestivo{" +
                super.toString() +
                "ubicacion='" + ubicacion + '\'' +
                ", gratuito=" + gratuito +
                '}';
    }

    @Override
    void leer() {
        System.out.println("\n - Leyendo fiesta...");
        System.out.println(super.getTexto() + " - ubicación: " + ubicacion + " - gratuito: " + gratuito);
    }

    public void aplicarRuido(){

        setEstado(EstadoMensaje.DIFUNDIDO);

    }

}
