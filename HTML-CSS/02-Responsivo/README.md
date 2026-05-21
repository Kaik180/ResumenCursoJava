# 📱 Diseño Responsivo

Creación de sitios web que se adaptan a diferentes dispositivos.

## 📚 Temas Cubiertos

- Viewport Meta Tag
- Media Queries
- Flexbox
- CSS Grid
- Mobile-First Design
- Breakpoints

## 📝 Contenido

### Viewport Meta Tag
```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

### Media Queries
```css
/* Pantallas pequeñas */
@media (max-width: 768px) {
    .container {
        width: 100%;
    }
}

/* Pantallas grandes */
@media (min-width: 1024px) {
    .container {
        width: 1000px;
    }
}
```

### Flexbox
```css
.container {
    display: flex;
    justify-content: center;    /* Alineación horizontal */
    align-items: center;        /* Alineación vertical */
    flex-wrap: wrap;            /* Envolver elementos */
}

.item {
    flex: 1;                    /* Crecer proporcionalmente */
}
```

### CSS Grid
```css
.grid {
    display: grid;
    grid-template-columns: repeat(3, 1fr);  /* 3 columnas iguales */
    gap: 10px;                               /* Espacio entre elementos */
}
```

## 🎯 Objetivos de Aprendizaje

- [x] Crear diseños responsivos
- [x] Usar Media Queries
- [x] Dominar Flexbox
- [x] Implementar CSS Grid
- [x] Seguir Mobile-First

## 📊 Breakpoints Comunes

| Dispositivo | Resolución |
|------------|-----------|
| Mobile | < 768px |
| Tablet | 768px - 1024px |
| Desktop | > 1024px |

---

*El diseño responsivo es esencial en el desarrollo web moderno.*
