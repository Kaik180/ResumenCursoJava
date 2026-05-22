package Colecciones3.Mapitas;

public class Socio {
    private String nombre;
    private String tipoSuscripción; // "Mensual", "Anual", "VIP"
    private boolean mensualidadPagada;

    public Socio(String nombre, String tipoSuscripción, boolean mensualidadPagada) {
        this.nombre = nombre;
        this.tipoSuscripción = tipoSuscripción;
        this.mensualidadPagada = mensualidadPagada;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public boolean isMensualidadPagada() { return mensualidadPagada; }
    public void setMensualidadPagada(boolean mensualidadPagada) { this.mensualidadPagada = mensualidadPagada; }

    @Override
    public String toString() {
        return nombre + " [Pase: " + tipoSuscripción + " | Estado: " + (mensualidadPagada ? "PAGADO" : "DEUDA") + "]";
    }
}
