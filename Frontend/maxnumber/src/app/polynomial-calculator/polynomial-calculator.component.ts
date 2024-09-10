import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-polynomial-calculator',
  templateUrl: './polynomial-calculator.component.html',
  standalone: true,
  imports: [HttpClientModule, FormsModule, CommonModule] // Asegúrate de incluir HttpClientModule y FormsModule
})
export class PolynomialCalculatorComponent implements OnInit {
  coefficients: number[] = [];
  xValue: number = 0;
  result: string = '';
  coefficientsInput: string = ''; 
  function: string = '';
  evaluationResult: string = '';

  // Variables para los cálculos de máximo, mínimo, suma, etc.
  num1: number = 0;
  num2: number = 0;
  num3: number = 0;
  num4: number = 0;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    console.log('PolynomialCalculatorComponent loaded');
  }

  formFunction(): string {
    const terms = [];
    
    if (this.num1) terms.push(`${this.num1}x^3`);
    if (this.num2) terms.push(`${this.num2}x^2`);
    if (this.num3) terms.push(`${this.num3}x`);
    if (this.num4) terms.push(`${this.num4}`);
    
    return terms.join(' + ');
  }
  

  calculateDerivative() {
    // Mostrar la función antes de derivarla
    this.function = this.formFunction();
  
    // Calcular la derivada
    this.http.get(`http://localhost:8080/dynamic-derivative?num1=${this.num1}&num2=${this.num2}&num3=${this.num3}&num4=${this.num4}`, { responseType: 'text' })
      .subscribe(
        (response: string) => {
          this.result = response;  // Mostrar la derivada
        },
        (error) => {
          console.error('Error al calcular la derivada:', error);
          this.result = 'Error al calcular la derivada.';
        }
      );
  }
  
  
  
    


  evaluateDerivative() {
    this.function = this.formFunction(); // Mostrar la función original primero

    // Calcular la derivada
    this.http.get(`http://localhost:8080/dynamic-derivative?num1=${this.num1}&num2=${this.num2}&num3=${this.num3}&num4=${this.num4}`, { responseType: 'text' })
      .subscribe(
        (response: string) => {
          this.result = response;  // Guardar la derivada de la función

          // Evaluar la derivada en el valor de x
          this.http.get(`http://localhost:8080/evaluate-dynamic-derivative?num1=${this.num1}&num2=${this.num2}&num3=${this.num3}&num4=${this.num4}&x=${this.xValue}`, { responseType: 'text' })
            .subscribe(
              (evalResponse: string) => {
                this.evaluationResult = evalResponse;  // Guardar el resultado de la evaluación
              },
              (error) => {
                console.error('Error al evaluar la derivada:', error);
                this.evaluationResult = 'Error al evaluar la derivada.';
              }
            );
        },
        (error) => {
          console.error('Error al calcular la derivada:', error);
          this.result = 'Error al calcular la derivada.';
        }
      );
  }
  


  getMaxNumber() {
    this.result = '';
    this.function = '';
    this.evaluationResult = '';
    this.http.get<number>(`http://localhost:8080/max-number?num1=${this.num1}&num2=${this.num2}&num3=${this.num3}&num4=${this.num4}`)
      .subscribe((response: number) => {
        this.result = `El número máximo es: ${response}`;
      }, (error) => {
        console.error('Error al obtener el número máximo:', error);
        this.result = 'Error al obtener el número máximo.';
      });
  }

  getMinNumber() {
    this.result = '';
    this.function = '';
    this.evaluationResult = '';
    this.http.get<number>(`http://localhost:8080/min-number?num1=${this.num1}&num2=${this.num2}&num3=${this.num3}&num4=${this.num4}`)
      .subscribe((response: number) => {
        this.result = `El número mínimo es: ${response}`;
      }, (error) => {
        console.error('Error al obtener el número mínimo:', error);
        this.result = 'Error al obtener el número mínimo.';
      });
  }

  getAverage() {
    this.result = '';
    this.function = '';
    this.evaluationResult = '';
    this.http.get<number>(`http://localhost:8080/average?num1=${this.num1}&num2=${this.num2}&num3=${this.num3}&num4=${this.num4}`)
      .subscribe((response: number) => {
        this.result = `El promedio es: ${response}`;
      }, (error) => {
        console.error('Error al obtener el promedio:', error);
        this.result = 'Error al obtener el promedio.';
      });
  }

  getSum() {
    this.result = '';
    this.function = '';
    this.evaluationResult = '';
    this.http.get<number>(`http://localhost:8080/sum?num1=${this.num1}&num2=${this.num2}&num3=${this.num3}&num4=${this.num4}`)
      .subscribe((response: number) => {
        this.result = `La suma es: ${response}`;
      }, (error) => {
        console.error('Error al obtener la suma:', error);
        this.result = 'Error al obtener la suma.';
      });
  }

  getSortedNumbers(order: string) {
    this.result = '';
    this.function = '';
    this.evaluationResult = '';
    this.http.get<number[]>(`http://localhost:8080/sort-numbers?num1=${this.num1}&num2=${this.num2}&num3=${this.num3}&num4=${this.num4}&order=${order}`)
      .subscribe((response: number[]) => {
        this.result = `Los números ordenados (${order}) son: ${response.join(', ')}`;
      }, (error) => {
        console.error('Error al ordenar los números:', error);
        this.result = 'Error al ordenar los números.';
      });
  }
}
