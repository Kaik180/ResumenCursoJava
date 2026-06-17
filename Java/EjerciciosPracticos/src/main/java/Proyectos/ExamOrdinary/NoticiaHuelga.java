package main.java.Proyectos.ExamOrdinary;

public class NoticiaHuelga extends Comunicado implements AccionPolitica{

    public NoticiaHuelga(String texto, int valoracionPrioridad, EstadoMensaje estado) {
        super(texto, valoracionPrioridad, estado);
    }

    @Override
    public String toString() {
        return "NoticiaHuelga{" +
                super.toString();
    }

    @Override
    void leer() {
        System.out.println("\n - Leyendo huelga...");
        System.out.println(super.getTexto());
    }

    @Override
    public boolean evaluarRiesgo() {

        if (getTexto().toLowerCase().contains("ratio") || getTexto().toLowerCase().contains("huelga") || getTexto().toLowerCase().contains("manifestación")){
            return true;
        }else{
            return false;
        }

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
