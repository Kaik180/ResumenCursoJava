# 🗄️ Fundamentos de SQL

Conceptos básicos de lenguaje SQL y bases de datos.

## 📚 Temas Cubiertos

- Estructura de Bases de Datos
- Tablas y Campos
- Tipos de Datos
- Claves Primarias y Foráneas
- Constraints
- Vistas

## 📝 Contenido

### Crear Tabla
```sql
CREATE TABLE Estudiantes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    edad INT,
    email VARCHAR(100) UNIQUE,
    fecha_registro DATE DEFAULT CURRENT_DATE
);
```

### Tipos de Datos
```sql
INT             -- Números enteros
VARCHAR(n)      -- Texto variable
DECIMAL(p,s)    -- Números decimales
DATE            -- Fecha
DATETIME        -- Fecha y hora
BOOLEAN         -- Verdadero/Falso
TEXT            -- Texto largo
```

### Constraints
```sql
NOT NULL        -- No puede ser vacío
UNIQUE          -- Valor único en la tabla
PRIMARY KEY     -- Identificador único
FOREIGN KEY     -- Referencia a otra tabla
CHECK           -- Validación de valor
DEFAULT         -- Valor por defecto
```

## 🎯 Objetivos de Aprendizaje

- [x] Crear bases de datos y tablas
- [x] Definir tipos de datos
- [x] Entender relaciones
- [x] Usar constraints
- [x] Diseñar esquemas normalizados

## 📊 Ejemplo de Relación

```
Estudiantes (1) -----> (N) Calificaciones
    id                     id
    nombre                 id_estudiante (FK)
    email                  materia
                           calificacion
```

---

*Una buena estructura de base de datos es fundamental.*
