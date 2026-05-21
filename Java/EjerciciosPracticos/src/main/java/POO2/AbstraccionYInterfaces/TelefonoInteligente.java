package POO2.AbstraccionYInterfaces;

public class TelefonoInteligente extends DispositivoInteligente {
    private String numeroTelefono;

    public TelefonoInteligente(String modelo, String numeroTelefono) {
        super(modelo); // Llama al constructor de la clase abstracta
        this.numeroTelefono = numeroTelefono;
    }

    // Obligatorio: Implementamos el método abstracto de la clase padre
    @Override
    public void ejecutarFuncionPrincipal() {
        if (isEncendido()) {
            System.out.println("Abriendo WhatsApp desde el teléfono " + numeroTelefono + "...");
        } else {
            System.out.println("Error: El teléfono debe estar encendido para usar aplicaciones.");
        }
    }
}