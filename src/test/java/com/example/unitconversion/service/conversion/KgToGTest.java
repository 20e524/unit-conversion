package com.example.unitconversion.service.conversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

class KgToGTest {

    KgToG kgToG;

    @BeforeEach
    void setup() {
        kgToG = new KgToG();
    }

    @Test
    void getConversionCodeTest() {
        assertEquals("kg to g", kgToG.getConversionCode());
    }

    @Test
    void executeKgToG() throws Exception {
        assertEquals(2000f, kgToG.execute(2f, "kg", "g"));
    }

    @Test
    void executeKgToGWithCommaValue() throws Exception {
        assertEquals(2123.456f, kgToG.execute(2.123456f, "kg", "g"));
    }

    @Test
    void executeKgToGWithNegativeValue() throws Exception {
        assertThrows(ResponseStatusException.class,
        () -> kgToG.execute(-2f, "kg", "g"), "value < 0 throw Exception");
    }

    @Test
    void executeKgToGWithZeroValue() throws Exception {
        assertThrows(ResponseStatusException.class,
                () -> kgToG.execute(0f, "kg", "g"), "value == 0 throw Exception");
    }

}