package com.example.maxnumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MaxNumberRunner implements CommandLineRunner {

    @Autowired
    private MaxNumberClient maxNumberClient;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el primer número: ");
        int num1 = scanner.nextInt();

        System.out.print("Ingresa el segundo número: ");
        int num2 = scanner.nextInt();

        System.out.print("Ingresa el tercer número: ");
        int num3 = scanner.nextInt();

        System.out.print("Ingresa el cuarto número: ");
        int num4 = scanner.nextInt();

        int max = maxNumberClient.getMaxNumber(num1, num2, num3, num4);
        System.out.println("El número máximo es: " + max);
    }
}
