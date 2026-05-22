# 📦 Working with Angular Modules

Módulos y organización en Angular.

## 📚 Temas Cubiertos

- ¿Qué es un Módulo?
- Decorador @NgModule
- Imports, Declarations, Providers
- Feature Modules
- Shared Modules
- Lazy Loading
- Module Organization

## 📝 Contenido

### Módulo Raíz (AppModule)
```typescript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

### Feature Module
```typescript
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { ProductosComponent } from './productos/productos.component';
import { ProductoDetailComponent } from './producto-detail/producto-detail.component';
import { ProductosRoutingModule } from './productos-routing.module';

@NgModule({
  declarations: [
    ProductosComponent,
    ProductoDetailComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    ProductosRoutingModule
  ]
})
export class ProductosModule { }
```

### Shared Module
```typescript
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { PaginationComponent } from './pagination/pagination.component';

@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
    PaginationComponent
  ],
  imports: [CommonModule],
  exports: [
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
    PaginationComponent
  ]
})
export class SharedModule { }
```

### Lazy Loading
```typescript
// app-routing.module.ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/inicio', pathMatch: 'full' },
  {
    path: 'productos',
    loadChildren: () => import('./productos/productos.module')
      .then(m => m.ProductosModule)
  },
  {
    path: 'usuarios',
    loadChildren: () => import('./usuarios/usuarios.module')
      .then(m => m.UsuariosModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
```

### Módulo de Características con Routing
```typescript
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { ProductosComponent } from './productos/productos.component';
import { ProductoDetailComponent } from './producto-detail/producto-detail.component';

const routes: Routes = [
  {
    path: '',
    component: ProductosComponent
  },
  {
    path: ':id',
    component: ProductoDetailComponent
  }
];

@NgModule({
  declarations: [
    ProductosComponent,
    ProductoDetailComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class ProductosModule { }
```

### Core Module
```typescript
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthService } from './services/auth.service';
import { HttpInterceptorService } from './interceptors/http-interceptor.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';

@NgModule({
  declarations: [],
  imports: [CommonModule],
  providers: [
    AuthService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }
  ]
})
export class CoreModule { }
```

### Standalone Components (Angular 14+)
```typescript
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class ProductoComponent {
  // ...
}
```

## 🎯 Objetivos de Aprendizaje

- [x] Entender la estructura de módulos
- [x] Crear módulos de características
- [x] Implementar módulos compartidos
- [x] Usar lazy loading
- [x] Organizar aplicaciones grandes
- [x] Usar standalone components

## 📊 Estructura Recomendada

```
src/
├── app/
│   ├── core/
│   │   ├── services/
│   │   ├── interceptors/
│   │   └── core.module.ts
│   ├── shared/
│   │   ├── components/
│   │   ├── directives/
│   │   ├── pipes/
│   │   └── shared.module.ts
│   ├── features/
│   │   ├── productos/
│   │   ├── usuarios/
│   │   └── ordenes/
│   ├── app.component.ts
│   ├── app.module.ts
│   └── app-routing.module.ts
```

## 📊 Decorador @NgModule

| Propiedad | Descripción |
|-----------|------------|
| declarations | Componentes, directivas, pipes |
| imports | Otros módulos requeridos |
| providers | Servicios (inyección) |
| exports | Qué se expone a otros módulos |
| bootstrap | Componente raíz (solo AppModule) |

---

*Una buena estructura modular facilita el mantenimiento.*
