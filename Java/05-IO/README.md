# 📁 Entrada/Salida (I/O)

Lectura y escritura de archivos en Java.

## 📚 Temas Cubiertos

- Scanner
- BufferedReader y PrintWriter
- FileInputStream y FileOutputStream
- Serialización
- Manejo de Archivos
- Lectura y Escritura de Texto

## 📝 Contenido

### Scanner para Entrada
```java
Scanner scanner = new Scanner(System.in);
System.out.print("Ingresa tu nombre: ");
String nombre = scanner.nextLine();
```

### Lectura de Archivos
```java
try (BufferedReader reader = new BufferedReader(
        new FileReader("archivo.txt"))) {
    String linea;
    while ((linea = reader.readLine()) != null) {
        System.out.println(linea);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### Escritura de Archivos
```java
try (PrintWriter writer = new PrintWriter(
        new FileWriter("salida.txt"))) {
    writer.println("Contenido del archivo");
} catch (IOException e) {
    e.printStackTrace();
}
```

## 🎯 Objetivos de Aprendizaje

- [x] Leer entrada del usuario
- [x] Leer archivos de texto
- [x] Escribir en archivos
- [x] Manejar flujos de datos
- [x] Trabajar con recursos

## 📚 Clases Importantes

- Scanner
- BufferedReader
- PrintWriter
- FileInputStream
- FileOutputStream
- File
