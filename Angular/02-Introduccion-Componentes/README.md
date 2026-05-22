# 🧩 Introducción a los Componentes de Angular

Conceptos fundamentales de componentes en Angular.

## 📚 Temas Cubiertos

- ¿Qué es un Componente?
- Anatomía de un Componente
- Decorador @Component
- Templates
- Styles
- Component Lifecycle

## 📝 Contenido

### Estructura Básica de un Componente
```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'app-hello',
  template: '<h1>Hola Mundo</h1>',
  styles: ['h1 { color: blue; }']
})
export class HelloComponent {
  
}
```

### Component con Template y Styles Externos
```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'app-mensaje',
  templateUrl: './mensaje.component.html',
  styleUrls: ['./mensaje.component.css']
})
export class MensajeComponent {
  titulo = 'Mi Primera Aplicación';
  mensaje = 'Bienvenido a Angular';
}
```

### Template HTML
```html
<div class="container">
  <h1>{{ titulo }}</h1>
  <p>{{ mensaje }}</p>
</div>
```

### CSS
```css
.container {
  padding: 20px;
  background-color: #f5f5f5;
}
```

### Lifecycle Hooks
```typescript
import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-lifecycle',
  template: '<p>Ciclo de vida</p>'
})
export class LifecycleComponent implements OnInit, OnDestroy {
  
  constructor() {
    console.log('Constructor - instancia creada');
  }

  ngOnInit() {
    console.log('ngOnInit - componente inicializado');
  }

  ngOnDestroy() {
    console.log('ngOnDestroy - componente destruido');
  }
}
```

## 🎯 Objetivos de Aprendizaje

- [x] Entender la estructura de componentes
- [x] Crear componentes básicos
- [x] Usar templates y styles
- [x] Entender el ciclo de vida
- [x] Registrar componentes en módulos

## 📊 Ciclo de Vida de un Componente

| Hook | Cuándo se Ejecuta |
|------|------------------|
| constructor | Instanciación |
| ngOnInit | Inicialización |
| ngOnChanges | Cambio de @Input |
| ngDoCheck | Detección de cambios |
| ngAfterViewInit | Vista inicializada |
| ngOnDestroy | Destrucción |

---

*Los componentes son la base de Angular.*
