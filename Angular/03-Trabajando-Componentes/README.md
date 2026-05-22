# 💻 Trabajando con los Componentes

Técnicas avanzadas de trabajo con componentes en Angular.

## 📚 Temas Cubiertos

- Property Binding
- Event Binding
- Two-way Binding
- Property Decorators (@Input, @Output)
- View Encapsulation
- Component Communication
- Content Projection

## 📝 Contenido

### Property Binding
```typescript
// componente.ts
export class ProductoComponent {
  nombre = 'Producto 1';
  precio = 100;
  disponible = true;
}
```

```html
<!-- componente.html -->
<h1>{{ nombre }}</h1>
<p>Precio: {{ precio }}</p>
<p [title]="nombre">Pasa el mouse</p>
<img [src]="urlImagen" [alt]="nombre">
```

### Event Binding
```html
<button (click)="comprar()">Comprar</button>
<input (change)="onPrecioChange($event)">
<div (mouseover)="onMouseOver()">Hover aquí</div>
```

```typescript
export class ProductoComponent {
  comprar() {
    console.log('Producto comprado');
  }

  onPrecioChange(event: any) {
    console.log('Nuevo precio:', event.target.value);
  }

  onMouseOver() {
    console.log('Mouse sobre elemento');
  }
}
```

### Two-way Binding
```html
<input [(ngModel)]="nombre" placeholder="Ingresa nombre">
<p>Nombre: {{ nombre }}</p>
```

```typescript
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ejemplo',
  template: '...',
  standalone: true,
  imports: [FormsModule]
})
export class EjemploComponent {
  nombre = '';
}
```

### @Input - Pasar Datos al Componente
```typescript
// componente-hijo.ts
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-hijo',
  template: '<p>{{ mensaje }}</p>'
})
export class HijoComponent {
  @Input() mensaje: string = '';
}
```

```html
<!-- componente-padre.html -->
<app-hijo [mensaje]="'Hola desde padre'"></app-hijo>
```

### @Output - Enviar Eventos al Padre
```typescript
// componente-hijo.ts
import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-hijo',
  template: '<button (click)="enviarMensaje()">Enviar</button>'
})
export class HijoComponent {
  @Output() mensajeEvent = new EventEmitter<string>();

  enviarMensaje() {
    this.mensajeEvent.emit('Mensaje desde hijo');
  }
}
```

```html
<!-- componente-padre.html -->
<app-hijo (mensajeEvent)="recibirMensaje($event)"></app-hijo>
```

### View Encapsulation
```typescript
import { Component, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-encapsulation',
  template: '<h1>Encapsulation</h1>',
  styles: ['h1 { color: red; }'],
  encapsulation: ViewEncapsulation.Emulated // None, Native
})
export class EncapsulationComponent {
}
```

### Content Projection
```typescript
// componente-contenedor.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-card',
  template: `
    <div class="card">
      <ng-content></ng-content>
    </div>
  `,
  styles: ['.card { border: 1px solid #ccc; padding: 20px; }']
})
export class CardComponent {
}
```

```html
<!-- uso en padre -->
<app-card>
  <h2>Título de la tarjeta</h2>
  <p>Contenido personalizado</p>
</app-card>
```

## 🎯 Objetivos de Aprendizaje

- [x] Usar property binding
- [x] Manejar eventos
- [x] Implementar two-way binding
- [x] Usar @Input y @Output
- [x] Comunicación entre componentes
- [x] Content projection

## 📊 Tipos de Binding

| Tipo | Sintaxis | Descripción |
|------|----------|------------|
| Interpolación | {{ valor }} | Mostrar valor |
| Property Binding | [prop]="valor" | Establecer propiedad |
| Event Binding | (evento)="función()" | Manejar eventos |
| Two-way | [(ngModel)]="valor" | Bidireccional |
| Class Binding | [class.activo]="booleano" | Clases dinámicas |
| Style Binding | [style.color]="color" | Estilos dinámicos |

---

*La comunicación entre componentes es esencial en Angular.*
