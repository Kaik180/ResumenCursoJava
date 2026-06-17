package main.java.Proyectos.Extra.PiscinaMutxamel;

public enum TipoUsuario {
    ADULTO(30.0),
    NIÑO(15.0),
    INVITADO(3.5);

    private final double precio;

    // Constructor del enumerado
    TipoUsuario(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
