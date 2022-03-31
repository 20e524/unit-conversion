package com.example.unitconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;


/**
 * A Unitconversion API to convert units from a predefined set of types
 *
 * @author Kim Lange
 * @author Friedrich Pick
 * @author Viktor Weindlmayr
 * @version 1.0
 */
@SpringBootApplication
@RestController
public class UnitConversionApplication {

    /**
     * Main program.
     *
     * @param args Commandline Parameter
     */
    public static void main(String[] args) {
        SpringApplication.run(UnitConversionApplication.class, args);


    }
}
