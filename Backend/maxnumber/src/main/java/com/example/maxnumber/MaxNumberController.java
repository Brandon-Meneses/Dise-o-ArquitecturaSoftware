package com.example.maxnumber;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MaxNumberController {

    @GetMapping("/max-number")
    public int getMaxNumber(@RequestParam int num1,
                            @RequestParam int num2,
                            @RequestParam int num3,
                            @RequestParam int num4) {
        return Math.max(Math.max(num1, num2), Math.max(num3, num4));
    }
    @GetMapping("/min-number")
    public int getMinNumber(@RequestParam int num1,
                            @RequestParam int num2,
                            @RequestParam int num3,
                            @RequestParam int num4) {
        return Math.min(Math.min(num1, num2), Math.min(num3, num4));
    }

    @GetMapping("/average")
    public double getAverage(@RequestParam int num1,
                             @RequestParam int num2,
                             @RequestParam int num3,
                             @RequestParam int num4) {
        return (num1 + num2 + num3 + num4) / 4.0;
    }

    @GetMapping("/sum")
    public int getSum(@RequestParam int num1,
                      @RequestParam int num2,
                      @RequestParam int num3,
                      @RequestParam int num4) {
        return num1 + num2 + num3 + num4;
    }
    @GetMapping("/sort-numbers")
    public List<Integer> getSortedNumbers(@RequestParam int num1,
                                          @RequestParam int num2,
                                          @RequestParam int num3,
                                          @RequestParam int num4,
                                          @RequestParam(defaultValue = "asc") String order) {
        List<Integer> numbers = Arrays.asList(num1, num2, num3, num4);

        if ("desc".equals(order)) {
            numbers.sort(Collections.reverseOrder());
        } else {
            Collections.sort(numbers);
        }

        return numbers;
    }
    @GetMapping("/dynamic-derivative")
    public String getDynamicDerivative(@RequestParam int num1,
                                       @RequestParam int num2,
                                       @RequestParam int num3,
                                       @RequestParam int num4) {
        List<Integer> coefficients = Arrays.asList(num1, num2, num3, num4);
        int degree = coefficients.size() - 1;
        StringBuilder derivative = new StringBuilder("f'(x) = ");
        boolean firstTerm = true; // Para manejar el signo '+' correctamente

        // Iterar sobre los coeficientes para calcular la derivada
        for (int i = 0; i < coefficients.size(); i++) {
            int coefficient = coefficients.get(i);
            int currentDegree = degree - i;

            // La derivada del término constante es 0, así que se omite
            if (currentDegree == 0) continue;

            int derivedCoefficient = coefficient * currentDegree;

            if (derivedCoefficient == 0) continue;

            if (!firstTerm) {
                derivative.append(" + ");
            }

            if (currentDegree > 1) {
                derivative.append(derivedCoefficient).append("x^").append(currentDegree - 1);
            } else {
                derivative.append(derivedCoefficient);
            }

            firstTerm = false;
        }

        return derivative.toString();
    }


    @GetMapping("/evaluate-dynamic-derivative")
    public String evaluateDynamicDerivative(@RequestParam int num1,
                                            @RequestParam int num2,
                                            @RequestParam int num3,
                                            @RequestParam int num4,
                                            @RequestParam int x) {
        List<Integer> coefficients = Arrays.asList(num1, num2, num3, num4);
        int degree = coefficients.size() - 1;
        int derivativeValue = 0;

        // Iterar sobre los coeficientes para calcular el valor de la derivada en x
        for (int i = 0; i < coefficients.size(); i++) {
            int coefficient = coefficients.get(i);
            int currentDegree = degree - i;

            if (currentDegree == 0) continue; // El término constante desaparece en la derivada

            derivativeValue += coefficient * currentDegree * Math.pow(x, currentDegree - 1);
        }

        return String.format("El valor de la derivada f'(x) en x = %d es: %d", x, derivativeValue);
    }



}