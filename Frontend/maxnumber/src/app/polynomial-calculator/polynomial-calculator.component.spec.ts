import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PolynomialCalculatorComponent } from './polynomial-calculator.component';

describe('PolynomialCalculatorComponent', () => {
  let component: PolynomialCalculatorComponent;
  let fixture: ComponentFixture<PolynomialCalculatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PolynomialCalculatorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PolynomialCalculatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
