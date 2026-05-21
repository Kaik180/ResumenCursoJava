# 🎨 Fundamentos de HTML y CSS

Conceptos básicos de maquetación web con HTML y estilos con CSS.

## 📚 Temas Cubiertos

### HTML
- Estructura semántica
- Elementos básicos
- Formularios
- Multimedia
- SEO

### CSS
- Selectores
- Box Model
- Posicionamiento
- Display (block, inline, inline-block)
- Especificidad y Cascada

## 📝 Contenido

### Estructura HTML5
```html
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <title>Mi Página</title>
</head>
<body>
    <header>Encabezado</header>
    <nav>Navegación</nav>
    <main>Contenido principal</main>
    <footer>Pie de página</footer>
</body>
</html>
```

### Selectores CSS
```css
/* Por clase */
.container { }

/* Por ID */
#header { }

/* Por elemento */
h1 { }

/* Combinadores */
div > p { }
div p { }
```

### Box Model
```css
div {
    margin: 10px;      /* Espacio externo */
    border: 1px solid; /* Borde */
    padding: 10px;     /* Espacio interno */
    width: 100%;       /* Ancho */
}
```

## 🎯 Objetivos de Aprendizaje

- [x] Entender estructura semántica de HTML
- [x] Dominar selectores CSS
- [x] Comprender el Box Model
- [x] Trabajar con formularios
- [x] Crear layouts básicos

## 📚 Elementos Semánticos

- `<header>` - Encabezado
- `<nav>` - Navegación
- `<main>` - Contenido principal
- `<article>` - Artículo
- `<section>` - Sección
- `<aside>` - Contenido lateral
- `<footer>` - Pie de página
