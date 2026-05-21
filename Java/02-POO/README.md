# 🏗️ Programación Orientada a Objetos (POO)

Conceptos fundamentales de la Programación Orientada a Objetos en Java.

## 📚 Temas Cubiertos

- Clases y Objetos
- Herencia
- Polimorfismo
- Encapsulación
- Abstracción
- Interfaces y Clases Abstractas
- Composición vs Herencia

## 📝 Contenido

### Clases y Objetos
```java
public class Persona {
    private String nombre;
    private int edad;
    
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
}
```

### Herencia
```java
public class Estudiante extends Persona {
    private String matricula;
    
    public Estudiante(String nombre, int edad, String matricula) {
        super(nombre, edad);
        this.matricula = matricula;
    }
}
```

### Interfaces
```java
public interface Vehiculo {
    void acelerar();
    void frenar();
}
```

## 🎯 Objetivos de Aprendizaje

- [x] Crear y manipular clases
- [x] Implementar herencia correctamente
- [x] Aplicar polimorfismo
- [x] Entender la encapsulación
- [x] Trabajar con interfaces

## 📚 Recursos Recomendados

- Clean Code - Robert C. Martin
- Design Patterns - Gang of Four
