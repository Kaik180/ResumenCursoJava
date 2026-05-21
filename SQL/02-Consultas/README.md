# 📊 Consultas SQL Avanzadas

Consultas complejas y operaciones en SQL.

## 📚 Temas Cubiertos

- SELECT
- WHERE
- INSERT, UPDATE, DELETE
- JOINs
- Subconsultas
- Funciones de Agregación
- GROUP BY y HAVING
- ORDER BY

## 📝 Contenido

### SELECT Básico
```sql
SELECT nombre, email FROM Estudiantes;
SELECT * FROM Estudiantes WHERE edad > 18;
SELECT DISTINCT ciudad FROM Clientes;
```

### JOINs
```sql
-- INNER JOIN
SELECT e.nombre, c.calificacion
FROM Estudiantes e
INNER JOIN Calificaciones c ON e.id = c.id_estudiante;

-- LEFT JOIN
SELECT e.nombre, c.calificacion
FROM Estudiantes e
LEFT JOIN Calificaciones c ON e.id = c.id_estudiante;
```

### Funciones de Agregación
```sql
SELECT COUNT(*) FROM Estudiantes;
SELECT AVG(calificacion) FROM Calificaciones;
SELECT MAX(edad) FROM Estudiantes;
SELECT SUM(precio) FROM Ordenes;
```

### GROUP BY y HAVING
```sql
SELECT materia, AVG(calificacion) as promedio
FROM Calificaciones
GROUP BY materia
HAVING AVG(calificacion) > 7;
```

### INSERT, UPDATE, DELETE
```sql
INSERT INTO Estudiantes (nombre, edad, email) 
VALUES ('Juan', 20, 'juan@mail.com');

UPDATE Estudiantes SET edad = 21 WHERE id = 1;

DELETE FROM Estudiantes WHERE id = 1;
```

## 🎯 Objetivos de Aprendizaje

- [x] Escribir consultas SELECT complejas
- [x] Usar JOINs correctamente
- [x] Aplicar funciones de agregación
- [x] Agrupar y filtrar datos
- [x] Modificar datos

## 📊 Operadores Comunes

| Operador | Descripción |
|----------|------------|
| = | Igual |
| != o <> | No igual |
| > | Mayor que |
| < | Menor que |
| IN | En una lista |
| BETWEEN | Entre dos valores |
| LIKE | Búsqueda de patrones |
| IS NULL | Valor nulo |
