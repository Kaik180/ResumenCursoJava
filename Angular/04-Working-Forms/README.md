# 📋 Working with Forms en Angular

Trabajo con formularios en Angular.

## 📚 Temas Cubiertos

- Template-driven Forms
- Reactive Forms
- Form Validation
- Form Groups
- Form Arrays
- Custom Validators
- Error Handling

## 📝 Contenido

### Template-driven Forms
```typescript
// componente.ts
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  standalone: true,
  imports: [FormsModule]
})
export class FormularioComponent {
  usuario = {
    nombre: '',
    email: '',
    password: ''
  };

  onSubmit() {
    console.log('Formulario enviado:', this.usuario);
  }
}
```

```html
<!-- componente.html -->
<form (ngSubmit)="onSubmit()" #miForm="ngForm">
  <div>
    <label>Nombre:</label>
    <input 
      type="text" 
      name="nombre" 
      [(ngModel)]="usuario.nombre"
      required>
  </div>

  <div>
    <label>Email:</label>
    <input 
      type="email" 
      name="email" 
      [(ngModel)]="usuario.email"
      email
      required>
  </div>

  <div>
    <label>Contraseña:</label>
    <input 
      type="password" 
      name="password" 
      [(ngModel)]="usuario.password"
      minlength="6"
      required>
  </div>

  <button type="submit" [disabled]="!miForm.valid">Enviar</button>
</form>
```

### Reactive Forms
```typescript
// componente.ts
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  standalone: true,
  imports: [ReactiveFormsModule]
})
export class ReactiveFormComponent {
  formulario: FormGroup;

  constructor(private fb: FormBuilder) {
    this.formulario = this.fb.group({
      nombre: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required]
    }, { validators: this.passwordMatchValidator });
  }

  passwordMatchValidator(group: FormGroup) {
    const password = group.get('password')?.value;
    const confirmPassword = group.get('confirmPassword')?.value;
    return password === confirmPassword ? null : { passwordMismatch: true };
  }

  onSubmit() {
    if (this.formulario.valid) {
      console.log('Datos:', this.formulario.value);
    }
  }
}
```

```html
<!-- componente.html -->
<form [formGroup]="formulario" (ngSubmit)="onSubmit()">
  <div>
    <label>Nombre:</label>
    <input 
      type="text" 
      formControlName="nombre">
    <div *ngIf="formulario.get('nombre')?.hasError('required')">
      El nombre es requerido
    </div>
    <div *ngIf="formulario.get('nombre')?.hasError('minlength')">
      Mínimo 3 caracteres
    </div>
  </div>

  <div>
    <label>Email:</label>
    <input 
      type="email" 
      formControlName="email">
    <div *ngIf="formulario.get('email')?.hasError('email')">
      Email inválido
    </div>
  </div>

  <div>
    <label>Contraseña:</label>
    <input 
      type="password" 
      formControlName="password">
  </div>

  <div>
    <label>Confirmar Contraseña:</label>
    <input 
      type="password" 
      formControlName="confirmPassword">
  </div>

  <div *ngIf="formulario.hasError('passwordMismatch')">
    Las contraseñas no coinciden
  </div>

  <button type="submit" [disabled]="!formulario.valid">Enviar</button>
</form>
```

### Form Groups
```typescript
this.formulario = this.fb.group({
  datosPersonales: this.fb.group({
    nombre: ['', Validators.required],
    apellido: ['', Validators.required]
  }),
  datosContacto: this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    telefono: ['', Validators.required]
  })
});
```

```html
<form [formGroup]="formulario">
  <fieldset formGroupName="datosPersonales">
    <legend>Datos Personales</legend>
    <input formControlName="nombre" placeholder="Nombre">
    <input formControlName="apellido" placeholder="Apellido">
  </fieldset>

  <fieldset formGroupName="datosContacto">
    <legend>Datos de Contacto</legend>
    <input formControlName="email" placeholder="Email">
    <input formControlName="telefono" placeholder="Teléfono">
  </fieldset>
</form>
```

### Form Arrays
```typescript
this.formulario = this.fb.group({
  nombre: ['', Validators.required],
  telefonos: this.fb.array([
    this.fb.control('', Validators.required)
  ])
});

get telefonos() {
  return this.formulario.get('telefonos') as FormArray;
}

agregarTelefono() {
  this.telefonos.push(this.fb.control('', Validators.required));
}

eliminarTelefono(index: number) {
  this.telefonos.removeAt(index);
}
```

```html
<form [formGroup]="formulario">
  <input formControlName="nombre" placeholder="Nombre">

  <div formArrayName="telefonos">
    <div *ngFor="let telefono of telefonos.controls; let i = index">
      <input [formControlName]="i" placeholder="Teléfono">
      <button (click)="eliminarTelefono(i)">Eliminar</button>
    </div>
  </div>

  <button (click)="agregarTelefono()">Agregar Teléfono</button>
</form>
```

### Custom Validators
```typescript
import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export function noEspaciosValidator(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const valor = control.value;
    if (!valor) return null;
    const tieneEspacios = valor.includes(' ');
    return tieneEspacios ? { noEspacios: true } : null;
  };
}

// Usar en formulario
nombre: ['', [Validators.required, noEspaciosValidator()]]
```

## 🎯 Objetivos de Aprendizaje

- [x] Crear formularios template-driven
- [x] Implementar reactive forms
- [x] Validar formularios
- [x] Usar Form Groups y Arrays
- [x] Crear validadores personalizados
- [x] Manejar errores

## 📊 Validadores Integrados

| Validador | Descripción |
|-----------|------------|
| required | Campo requerido |
| minLength | Longitud mínima |
| maxLength | Longitud máxima |
| pattern | Patrón regex |
| email | Formato email |
| min | Valor mínimo |
| max | Valor máximo |

---

*Los formularios son esenciales para capturar datos de usuarios.*
