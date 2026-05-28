package org.example;

public abstract class Comunicado {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getValoracionPrioridad() {
        return valoracionPrioridad;
    }

    public void setValoracionPrioridad(Integer valoracionPrioridad) {
        this.valoracionPrioridad = valoracionPrioridad;
    }

    public EstadoMensaje getEstado() {
        return estado;
    }

    public void setEstado(EstadoMensaje estado) {
        this.estado = estado;
    }

    public Comunicado(String id, String texto, Integer valoracionPrioridad, EstadoMensaje estado) {
        this.id = id;
        this.texto = texto;
        this.valoracionPrioridad = valoracionPrioridad;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Comunicado{" + "id='" + id + '\'' + ", texto='" + texto + '\'' + ", valoracionPrioridad=" + valoracionPrioridad + ", estado=" + estado + '}';
    }
   void leer(){
    String string = toString();
    System.out.println(string);
}

    private String id;
    private String texto;
    private Integer valoracionPrioridad;
    private EstadoMensaje estado;

}

