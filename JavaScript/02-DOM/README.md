# 🎨 DOM y Manipulación de Eventos

Interacción con el DOM y manejo de eventos en JavaScript.

## 📚 Temas Cubiertos

- Seleccionar elementos del DOM
- Modificar contenido y atributos
- Crear y eliminar elementos
- Event Listeners
- Delegación de eventos
- Manipulación de clases y estilos

## 📝 Contenido

### Seleccionar Elementos
```javascript
const elemento = document.getElementById("id");
const elementos = document.querySelectorAll(".clase");
const porClase = document.getElementsByClassName("clase");
```

### Modificar Contenido
```javascript
elemento.textContent = "Nuevo texto";
elemento.innerHTML = "<p>HTML nuevo</p>";
elemento.setAttribute("data-valor", "123");
```

### Event Listeners
```javascript
const boton = document.getElementById("boton");
boton.addEventListener("click", function() {
    console.log("Botón clickeado");
});
```

### Manipular Clases
```javascript
elemento.classList.add("activo");
elemento.classList.remove("inactivo");
elemento.classList.toggle("visible");
```

## 🎯 Objetivos de Aprendizaje

- [x] Navegar el árbol del DOM
- [x] Seleccionar elementos eficientemente
- [x] Modificar propiedades y contenido
- [x] Manejar eventos correctamente
- [x] Usar delegación de eventos

## 📚 Métodos Comunes del DOM

- `getElementById()`
- `querySelector()`
- `addEventListener()`
- `classList`
- `setAttribute()`
- `appendChild()`
