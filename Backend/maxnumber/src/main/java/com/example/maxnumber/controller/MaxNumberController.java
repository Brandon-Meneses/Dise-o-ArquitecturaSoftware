package com.example.maxnumber.controller;

import com.example.maxnumber.service.MathService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MaxNumberController {

    private final MathService mathService;

    public MaxNumberController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/max-number")
    public int getMaxNumber(@RequestParam int num1,
                            @RequestParam int num2,
                            @RequestParam int num3,
                            @RequestParam int num4) {
        return mathService.getMaxNumber(num1, num2, num3, num4);
    }

    @GetMapping("/min-number")
    public int getMinNumber(@RequestParam int num1,
                            @RequestParam int num2,
                            @RequestParam int num3,
                            @RequestParam int num4) {
        return mathService.getMinNumber(num1, num2, num3, num4);
    }

    @GetMapping("/average")
    public double getAverage(@RequestParam int num1,
                             @RequestParam int num2,
                             @RequestParam int num3,
                             @RequestParam int num4) {
        return mathService.getAverage(num1, num2, num3, num4);
    }

    @GetMapping("/sum")
    public int getSum(@RequestParam int num1,
                      @RequestParam int num2,
                      @RequestParam int num3,
                      @RequestParam int num4) {
        return mathService.getSum(num1, num2, num3, num4);
    }

    @GetMapping("/sort-numbers")
    public List<Integer> getSortedNumbers(@RequestParam int num1,
                                          @RequestParam int num2,
                                          @RequestParam int num3,
                                          @RequestParam int num4,
                                          @RequestParam(defaultValue = "asc") String order) {
        return mathService.getSortedNumbers(num1, num2, num3, num4, order);
    }

    @GetMapping("/dynamic-derivative")
    public String getDynamicDerivative(@RequestParam int num1,
                                       @RequestParam int num2,
                                       @RequestParam int num3,
                                       @RequestParam int num4) {
        return mathService.getDynamicDerivative(num1, num2, num3, num4);
    }

    @GetMapping("/evaluate-dynamic-derivative")
    public String evaluateDynamicDerivative(@RequestParam int num1,
                                            @RequestParam int num2,
                                            @RequestParam int num3,
                                            @RequestParam int num4,
                                            @RequestParam int x) {
        return mathService.evaluateDynamicDerivative(num1, num2, num3, num4, x);
    }
}