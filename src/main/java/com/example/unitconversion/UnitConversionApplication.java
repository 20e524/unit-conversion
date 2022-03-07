package com.example.unitconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@SpringBootApplication
@RestController
public class UnitConversionApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnitConversionApplication.class, args);

        Scanner sc=new Scanner (System.in);
        System.out.println("Please choose unit conversion");
        System.out.println("1. grams to kg");
        System.out.println("2. kg to grams");
        int n = sc.nextInt();
        System.out.println("enter data for conversion");
        double d = sc.nextDouble();
        String st = "";
        double result = 1;
        if(n==1) {
            result = d * 0.01;
            st = "kg";
        }
        else {
            result = d * 100;
            st = "lbs";
        }

        System.out.println("after conversion: " + result + " " + st);

    }

    /*
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
     */

}
