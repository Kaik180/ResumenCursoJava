package Ejercicios.Avanzado.GestorBiblioteca;
public class Libro {
    private String titulo;
    private String autor;
    private boolean disponible;

    // Constructor
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true; // Por defecto, un libro nuevo está libre
    }

    // Métodos de acceso (Getters y Setters)
    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Método especial para imprimir el libro de forma bonita en consola
    @Override
    public String toString() {
        return "\"" + titulo + "\" de " + autor + " [" + (disponible ? "Disponible" : "Prestado") + "]";
    }
}