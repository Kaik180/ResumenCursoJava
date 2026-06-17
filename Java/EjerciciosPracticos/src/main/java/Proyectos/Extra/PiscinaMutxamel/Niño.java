package main.java.Proyectos.Extra.PiscinaMutxamel;


public class Niño extends Bañista {
    private String telefonoContactoAdulto;

    public Niño(Integer numero, String nombre, int edad, TipoUsuario tipo, String telefonoContactoAdulto) {
        super(numero, nombre, edad, tipo);
        this.telefonoContactoAdulto = telefonoContactoAdulto;
    }

    public String getTelefonoContactoAdulto() { return telefonoContactoAdulto; }
    public void setTelefonoContactoAdulto(String telefono) { this.telefonoContactoAdulto = telefono; }

    @Override
    public void pagar() {
        System.out.println("Niño (abono de tipo " + getTipo() + ") pagando " + getTipo().getPrecio() + "€");
    }
}
