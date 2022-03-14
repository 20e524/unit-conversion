package com.example.unitconversion.service.conversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

class CToFTest {

    CToF celsiusToFahrenheit;

    @BeforeEach
    void setup() {
        celsiusToFahrenheit = new CToF();
    }

    @Test
    void executeFtoC() throws Exception {
        assertEquals(392, celsiusToFahrenheit.execute(200f, "F", "C"), 0.0001);
    }

    @Test
    void executeFtoCWithLowerThanZeroKelvinValue() {
        assertThrows(ResponseStatusException.class, () -> celsiusToFahrenheit.execute(-273.16f, "F", "C"));
    }


    @Test
    void getCorrectConversionCode() {
        assertEquals("C to F", celsiusToFahrenheit.getConversionCode());
    }

}