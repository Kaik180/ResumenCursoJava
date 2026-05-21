package POO2.TodoEnUno;

public class Coche {
    private String marca;
    private int gasolina;
    private EstadoCoche estado;

    public Coche(String marca, int gasolinaInicial) {
        this.marca = marca;
        this.gasolina = gasolinaInicial;
        this.estado = EstadoCoche.APAGADO;
    }

    // Indicamos explícitamente que arroja SinCombustibleException
    public void arrancar() throws SinCombustibleException {
        System.out.println("Intentando arrancar el " + marca + "...");

        if (gasolina <= 0) {
            this.estado = EstadoCoche.SIN_GASOLINA;
            // Lanzamos la excepción con el nombre correcto
            throw new SinCombustibleException("¡Error crítico! El depósito del " + marca + " está completamente vacío.");
        }

        this.estado = EstadoCoche.EN_MARCHA;
        this.gasolina -= 5;
        System.out.println("¡Brum brum! El coche ha arrancado con éxito. Estado: " + estado);
    }

    public void viajar(int kilometros) {
        if (estado == EstadoCoche.EN_MARCHA) {
            System.out.println("El coche está viajando " + kilometros + " km por la carretera.");
        } else {
            System.out.println("No puedes viajar, el coche no está en marcha. Estado actual: " + estado);
        }
    }

    public EstadoCoche getEstado() {
        return estado;
    }
}
