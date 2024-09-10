import { Routes } from '@angular/router';
import { PolynomialCalculatorComponent } from './polynomial-calculator/polynomial-calculator.component';
import { AlumnosComponent } from './alumnos/alumnos.component';

export const routes: Routes = [
    { path: '', redirectTo: 'polynomial-calculator', pathMatch: 'full' },
    { path: 'polynomial-calculator', component: PolynomialCalculatorComponent },
    { path: 'alumnos', component: AlumnosComponent }
  ];
