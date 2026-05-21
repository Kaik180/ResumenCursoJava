package POO2.HerenciaYPolimorfismo;

// Al estar en la misma carpeta, detecta a 'Persona' automáticamente sin importarla
public class Estudiante extends Persona {
    private String matricula;

    public Estudiante(String nombre, int edad, String matricula) {
        super(nombre, edad); // Llama al constructor de Persona
        this.matricula = matricula;
    }

    // Polimorfismo: Redefinimos el saludo para el estudiante
    @Override
    public void saludar() {
        System.out.println("Hola! Soy el estudiante " + getNombre() + " (Matrícula: " + matricula + ")");
    }
}