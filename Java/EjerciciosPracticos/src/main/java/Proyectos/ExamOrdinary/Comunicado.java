package main.java.Proyectos.ExamOrdinary;

public abstract class Comunicado implements Comparable<Comunicado> {

    static int comunicadosCreados = 0;

    private String id;
    private String texto;
    private Integer valoracionPrioridad;
    private EstadoMensaje estado;

    public Comunicado(String texto, int valoracionPrioridad, EstadoMensaje estado) {
        setId();
        this.texto = texto;
        this.valoracionPrioridad = valoracionPrioridad;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        comunicadosCreados++;
        id = "CM" + comunicadosCreados;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getValoracionPrioridad() {
        return valoracionPrioridad;
    }

    public void setValoracionPrioridad(int valoracionPrioridad) {
        this.valoracionPrioridad = valoracionPrioridad;
    }

    public EstadoMensaje getEstado() {
        return estado;
    }

    public void setEstado(EstadoMensaje estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Comunicado{" +
                "id='" + id + '\'' +
                ", texto='" + texto + '\'' +
                ", valoracionPrioridad=" + valoracionPrioridad +
                ", estado=" + estado +
                '}';
    }

    @Override
    public int compareTo(Comunicado o) {
        int comparar = valoracionPrioridad.compareTo(o.getValoracionPrioridad());

        // SI LAS PRIORIDADES SON IGUALES, DESEMPATAMOS POR ID
        if (comparar == 0) {
            return id.compareTo(o.id);
        }

        return comparar;
    }

    abstract void leer();

}
