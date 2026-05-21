package POO2.HerenciaYPolimorfismo;

public class Persona {
    // Atributos privados: nadie puede acceder a ellos directamente
    private String nombre;
    private int edad;

    // Constructor para inicializar el objeto
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        setEdad(edad); // Usamos el setter para aprovechar la validación
    }

    // Getter: Permite leer el nombre de forma segura
    public String getNombre() {
        return nombre;
    }

    // Setter: Permite cambiar el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para la edad
    public int getEdad() {
        return edad;
    }

    // Setter con validación: Evitamos que pongan edades imposibles
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("Error: La edad no puede ser negativa. Se asignará 0.");
            this.edad = 0;
        }
    }

    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }
}
