# ⏳ Asincronía y Promesas

Manejo de operaciones asincrónicas en JavaScript.

## 📚 Temas Cubiertos

- Callbacks
- Promesas
- Async/Await
- Fetch API
- Manejo de Errores
- Promise.all y Promise.race

## 📝 Contenido

### Callbacks
```javascript
function obtenerDatos(callback) {
    setTimeout(() => {
        callback("Datos obtenidos");
    }, 1000);
}
```

### Promesas
```javascript
const promesa = new Promise((resolve, reject) => {
    if (condicion) {
        resolve("Éxito");
    } else {
        reject("Error");
    }
});

promesa.then(resultado => console.log(resultado))
       .catch(error => console.error(error));
```

### Async/Await
```javascript
async function obtenerDatos() {
    try {
        const respuesta = await fetch("url");
        const datos = await respuesta.json();
        return datos;
    } catch (error) {
        console.error(error);
    }
}
```

### Fetch API
```javascript
fetch("https://api.ejemplo.com/datos")
    .then(respuesta => respuesta.json())
    .then(datos => console.log(datos))
    .catch(error => console.error(error));
```

## 🎯 Objetivos de Aprendizaje

- [x] Entender callbacks
- [x] Trabajar con Promesas
- [x] Usar async/await
- [x] Hacer peticiones HTTP
- [x] Manejar errores asincrónicos

## 📚 Concepto Importante

**Call Stack vs Event Loop:** JavaScript es single-threaded, pero puede manejar operaciones asincrónicas mediante el event loop.
