# 🎓 Proyectos Integradores de SQL

Proyectos de bases de datos completos.

## 📋 Proyectos Desarrollados

### 1. Sistema de Gestión de Biblioteca
Base de datos para gestionar una biblioteca.

**Tablas:**
- Libros (id, titulo, autor, isbn, fecha_publicacion)
- Miembros (id, nombre, email, fecha_registro)
- Préstamos (id, id_libro, id_miembro, fecha_prestamo, fecha_devolución)
- Autores (id, nombre, nacionalidad)

**Consultas Principales:**
- Libros prestados actualmente
- Libros más prestados
- Deudores de libros
- Historial de préstamos por miembro

### 2. Sistema de Gestión de Tienda Online
Base de datos para una tienda online.

**Tablas:**
- Clientes (id, nombre, email, dirección)
- Categorías (id, nombre)
- Productos (id, nombre, precio, id_categoría)
- Órdenes (id, id_cliente, fecha_orden)
- Detalles_Orden (id, id_orden, id_producto, cantidad)

**Consultas Principales:**
- Ingresos por mes
- Productos más vendidos
- Clientes frecuentes
- Stock de productos

### 3. Sistema de Gestión de Universidad
Base de datos para una universidad.

**Tablas:**
- Estudiantes (id, nombre, matricula, carrera)
- Profesores (id, nombre, departamento)
- Cursos (id, nombre, id_profesor)
- Inscripciones (id, id_estudiante, id_curso)
- Calificaciones (id, id_inscripción, calificación)

**Consultas Principales:**
- Promedio de calificaciones por estudiante
- Profesores con más estudiantes
- Cursos con mayor demanda
- Reportes de desempeño

## 🎯 Objetivos

- Diseñar esquemas relacionales
- Crear bases de datos normalizadas
- Implementar integridad referencial
- Escribir consultas optimizadas
- Generar reportes

## 📊 Normalización

- 1NF: Atomicidad de datos
- 2NF: Sin dependencias parciales
- 3NF: Sin dependencias transitivas

---

*Estos proyectos sirven como referencia de diseño de bases de datos.*
