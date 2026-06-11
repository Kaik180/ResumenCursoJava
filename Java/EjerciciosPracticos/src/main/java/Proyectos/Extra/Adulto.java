package Proyectos.Extra;

public class Adulto extends Bañista {

    public Adulto(Integer numero, String nombre, int edad, TipoUsuario tipo) {
        super(numero, nombre, edad, tipo);
    }

    @Override
    public void pagar() {
        System.out.println("Adulto (abono de tipo " + getTipo() + ") pagando " + getTipo().getPrecio() + "€");
    }
}
