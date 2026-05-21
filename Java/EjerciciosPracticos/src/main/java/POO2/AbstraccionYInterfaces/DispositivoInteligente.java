package POO2.AbstraccionYInterfaces;

// Implementa la interfaz automáticamente sin necesidad de programar todos los métodos aquí
public abstract class DispositivoInteligente implements DispositivoBateria {
    private String modelo;
    private int nivelBateria;
    private boolean encendido;

    // Constructor común para todos los hijos
    public DispositivoInteligente(String modelo) {
        this.modelo = modelo;
        this.nivelBateria = 100; // Todos los dispositivos nuevos vienen cargados
        this.encendido = false;
    }

    // Código reutilizable ya programado para todos los hijos (Implementación de la interfaz)
    @Override
    public void encender() {
        if (nivelBateria > 0) {
            encendido = true;
            System.out.println(modelo + " se está iniciando...");
        } else {
            System.out.println("No se puede encender " + modelo + ". Sin batería.");
        }
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println(modelo + " se ha apagado.");
    }

    @Override
    public void cargarBateria(int porcentaje) {
        nivelBateria += porcentaje;
        if (nivelBateria > 100) nivelBateria = 100;
        System.out.println(modelo + " cargado. Batería actual: " + nivelBateria + "%");
    }

    // Getters para que los hijos puedan leer las variables privadas
    public String getModelo() { return modelo; }
    public boolean isEncendido() { return encendido; }

    // METODO ABSTRACTO NUEVO: Cada dispositivo tendrá su propia función especial
    public abstract void ejecutarFuncionPrincipal();
}
