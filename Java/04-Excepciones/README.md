# ⚠️ Excepciones y Manejo de Errores

Gestión de errores y excepciones en Java.

## 📚 Temas Cubiertos

- Try-Catch-Finally
- Tipos de Excepciones
- Lanzamiento de Excepciones
- Excepciones Personalizadas
- Multi-catch
- Try-with-resources

## 📝 Contenido

### Try-Catch-Finally
```java
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
} finally {
    System.out.println("Bloque finally siempre se ejecuta");
}
```

### Excepciones Personalizadas
```java
public class EdadInvalidaException extends Exception {
    public EdadInvalidaException(String mensaje) {
        super(mensaje);
    }
}
```

### Try-with-resources
```java
try (Scanner scanner = new Scanner(System.in)) {
    String linea = scanner.nextLine();
} catch (IOException e) {
    e.printStackTrace();
}
```

## 🎯 Objetivos de Aprendizaje

- [x] Entender jerarquía de excepciones
- [x] Manejar excepciones correctamente
- [x] Crear excepciones personalizadas
- [x] Usar try-with-resources
- [x] Propagar excepciones adecuadamente

## 📊 Tipos de Excepciones

| Tipo | Descripción |
|------|-------------|
| Exception | Excepciones verificadas |
| RuntimeException | Excepciones no verificadas |
| Error | Errores graves del sistema |
