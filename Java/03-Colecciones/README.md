# 📦 Colecciones y Estructuras de Datos

Uso de colecciones en Java para gestionar grupos de objetos.

## 📚 Temas Cubiertos

- ArrayList
- LinkedList
- HashMap
- HashSet
- TreeSet
- Comparadores y Ordenamiento
- Iteradores

## 📝 Contenido

### ArrayList
```java
ArrayList<String> lista = new ArrayList<>();
lista.add("Elemento 1");
lista.add("Elemento 2");
lista.remove(0);
```

### HashMap
```java
HashMap<String, Integer> mapa = new HashMap<>();
mapa.put("Java", 95);
mapa.put("JavaScript", 4);
mapa.get("Java"); // 95
```

### HashSet
```java
HashSet<String> conjunto = new HashSet<>();
conjunto.add("Python");
conjunto.add("Java");
```

## 🎯 Objetivos de Aprendizaje

- [x] Usar ArrayList y LinkedList
- [x] Implementar HashMap y HashSet
- [x] Ordenar colecciones
- [x] Iterar sobre colecciones
- [x] Elegir la estructura adecuada

## 📊 Comparativa de Estructuras

| Estructura | Acceso | Inserción | Búsqueda |
|-----------|--------|-----------|----------|
| ArrayList | O(1) | O(n) | O(n) |
| LinkedList | O(n) | O(1) | O(n) |
| HashMap | O(1) | O(1) | O(1) |
| HashSet | - | O(1) | O(1) |
