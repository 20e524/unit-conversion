package com.example.unitconversion.service.conversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

class FToCTest {

    FToC fahrenheitToCelsius;

    @BeforeEach
    void setup() {
        fahrenheitToCelsius = new FToC();
    }

    @Test
    void executeFtoC() throws Exception {
        assertEquals(93.33333, fahrenheitToCelsius.execute(200f, "F", "C"), 0.0001);
    }

    @Test
    void executeFtoCWithLowerThanZeroKelvinValue() {
        assertThrows(ResponseStatusException.class, () -> fahrenheitToCelsius.execute(-459.68f, "F", "C"));
    }


    @Test
    void getCorrectConversionCode() {
        assertEquals("F to C", fahrenheitToCelsius.getConversionCode());
    }

}