# 📘 Fundamentos de TypeScript

Introducción a TypeScript y sistema de tipos.

## 📚 Temas Cubiertos

- Tipos Básicos
- Type Annotations
- Tipos Opcionales
- Uniones de Tipos
- Tipo Any y Unknown
- Type Aliases

## 📝 Contenido

### Tipos Básicos
```typescript
let nombre: string = "Juan";
let edad: number = 25;
let activo: boolean = true;
let valores: number[] = [1, 2, 3];
let tupla: [string, number] = ["texto", 10];
```

### Type Annotations
```typescript
function saludar(nombre: string): string {
    return "Hola " + nombre;
}

const suma = (a: number, b: number): number => a + b;
```

### Tipos Opcionales
```typescript
function gritar(mensaje?: string) {
    if (mensaje) {
        console.log(mensaje.toUpperCase());
    }
}

let usuario: string | null = null;
```

### Type Aliases
```typescript
type Usuario = {
    nombre: string;
    edad: number;
    email?: string;
};

const usuario: Usuario = {
    nombre: "María",
    edad: 30
};
```

## 🎯 Objetivos de Aprendizaje

- [x] Entender el sistema de tipos
- [x] Usar type annotations
- [x] Trabajar con tipos opcionales
- [x] Crear type aliases
- [x] Usar uniones de tipos

## 📚 Tipos Primitivos en TypeScript

- `string` - Texto
- `number` - Números
- `boolean` - Verdadero/Falso
- `any` - Cualquier tipo
- `unknown` - Tipo desconocido
- `null` - Nulo
- `undefined` - No definido
- `void` - Sin retorno

---

*TypeScript agrega seguridad de tipos a JavaScript.*
