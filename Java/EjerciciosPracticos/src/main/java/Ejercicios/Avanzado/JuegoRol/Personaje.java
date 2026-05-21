package Ejercicios.Avanzado.JuegoRol;

public class Personaje {
    private String nombre;
    private int vida;
    private int ataqueBase;

    // Constructor
    public Personaje(String nombre, int vida, int ataqueBase) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataqueBase = ataqueBase;
    }

    // Getters y Setters necesarios
    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaqueBase() { return ataqueBase; }

    public void setVida(int vida) {
        this.vida = vida;
    }

    // Método para comprobar salud
    public boolean estaVivo() {
        return this.vida > 0;
    }

    // Método para curarse
    public void curar(int cantidad) {
        this.vida += cantidad;
        System.out.println(nombre + " se ha curado " + cantidad + " puntos de vida.");
    }
}