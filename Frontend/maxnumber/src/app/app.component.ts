import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { RouterModule } from '@angular/router';
import { PolynomialCalculatorComponent } from './polynomial-calculator/polynomial-calculator.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,PolynomialCalculatorComponent, RouterModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'maxnumber';
  log(tabName: string): void {
    console.log(`Navigating to: ${tabName}`);
  }
}
