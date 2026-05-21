package POO2.EncapsulacionClasesObjetos;


public class MainObjetos {
    public static void main(String[] args) {
        // Creamos un objeto (instancia) de la clase Persona
        Persona p1 = new Persona("Carlos", 25);
        p1.saludar();

        // Intentamos poner una edad inválida gracias a la encapsulación
        p1.setEdad(-5);
        System.out.println("Edad actual de " + p1.getNombre() + ": " + p1.getEdad());
    }
}
