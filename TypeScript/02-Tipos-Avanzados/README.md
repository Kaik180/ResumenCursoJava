# 🚀 Tipos Avanzados de TypeScript

Conceptos avanzados del sistema de tipos de TypeScript.

## 📚 Temas Cubiertos

- Interfaces
- Clases
- Genéricos
- Tipos Condicionales
- Mapped Types
- Utility Types

## 📝 Contenido

### Interfaces
```typescript
interface Persona {
    nombre: string;
    edad: number;
    saludar(): void;
}

interface Empleado extends Persona {
    salario: number;
    id_empleado: string;
}
```

### Clases
```typescript
class Estudiante implements Persona {
    nombre: string;
    edad: number;
    matricula: string;
    
    constructor(nombre: string, edad: number, matricula: string) {
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
    }
    
    saludar(): void {
        console.log(`Hola, soy ${this.nombre}`);
    }
}
```

### Genéricos
```typescript
function obtenerPrimero<T>(array: T[]): T {
    return array[0];
}

interface Contenedor<T> {
    valor: T;
    obtener(): T;
    establecer(valor: T): void;
}
```

### Utility Types
```typescript
type Usuario = {
    id: number;
    nombre: string;
    email: string;
};

type UsuarioOpcional = Partial<Usuario>;
type UsuarioSoloLectura = Readonly<Usuario>;
type Claves = keyof Usuario;
```

## 🎯 Objetivos de Aprendizaje

- [x] Crear interfaces
- [x] Usar clases con tipos
- [x] Trabajar con genéricos
- [x] Usar utility types
- [x] Crear tipos complejos

## 📚 Utility Types Comunes

| Tipo | Descripción |
|------|------------|
| Partial<T> | Todas las propiedades opcionales |
| Required<T> | Todas las propiedades requeridas |
| Readonly<T> | Todas las propiedades de solo lectura |
| Record<K, T> | Objeto con claves específicas |
| Pick<T, K> | Seleccionar propiedades |
| Omit<T, K> | Excluir propiedades |

---

*Los tipos avanzados permiten crear código más robusto.*
