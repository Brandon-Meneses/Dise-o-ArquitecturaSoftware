package com.example.maxnumber;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class MathService {

    public int getMaxNumber(int num1, int num2, int num3, int num4) {
        return Math.max(Math.max(num1, num2), Math.max(num3, num4));
    }

    public int getMinNumber(int num1, int num2, int num3, int num4) {
        return Math.min(Math.min(num1, num2), Math.min(num3, num4));
    }

    public double getAverage(int num1, int num2, int num3, int num4) {
        return (num1 + num2 + num3 + num4) / 4.0;
    }

    public int getSum(int num1, int num2, int num3, int num4) {
        return num1 + num2 + num3 + num4;
    }

    public List<Integer> getSortedNumbers(int num1, int num2, int num3, int num4, String order) {
        List<Integer> numbers = Arrays.asList(num1, num2, num3, num4);

        if ("desc".equals(order)) {
            numbers.sort(Collections.reverseOrder());
        } else {
            Collections.sort(numbers);
        }

        return numbers;
    }

    public String getDynamicDerivative(int num1, int num2, int num3, int num4) {
        List<Integer> coefficients = Arrays.asList(num1, num2, num3, num4);
        int degree = coefficients.size() - 1;
        StringBuilder derivative = new StringBuilder("f'(x) = ");
        boolean firstTerm = true;

        for (int i = 0; i < coefficients.size(); i++) {
            int coefficient = coefficients.get(i);
            int currentDegree = degree - i;

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

    public String evaluateDynamicDerivative(int num1, int num2, int num3, int num4, int x) {
        List<Integer> coefficients = Arrays.asList(num1, num2, num3, num4);
        int degree = coefficients.size() - 1;
        int derivativeValue = 0;

        for (int i = 0; i < coefficients.size(); i++) {
            int coefficient = coefficients.get(i);
            int currentDegree = degree - i;

            if (currentDegree == 0) continue;

            derivativeValue += coefficient * currentDegree * Math.pow(x, currentDegree - 1);
        }

        return String.format("El valor de la derivada f'(x) en x = %d es: %d", x, derivativeValue);
    }
}
