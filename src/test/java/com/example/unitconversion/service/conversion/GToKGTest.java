package com.example.unitconversion.service.conversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


import static org.junit.jupiter.api.Assertions.*;

class GToKGTest {

    GToKG gramToKg;

    @BeforeEach
    void setup() {
        gramToKg = new GToKG();
    }

    @Test
    void executeGtoKg() throws Exception {
        assertEquals(2f, gramToKg.execute(2000f, "g", "kg"));
    }

    @Test
    void executeGtoKgWithZeroFromValue() {
        assertThrows(ResponseStatusException.class, () -> gramToKg.execute(0f, "g", "kg"));
    }

    @Test
    void executeGtoKgWithNegativeFromValue() {
        assertThrows(ResponseStatusException.class, () -> gramToKg.execute(-9f, "g", "kg"));
    }

    @Test
    void executeGtoKgMaxValue() throws Exception {
        assertEquals(20000000000000000000000000f, gramToKg.execute(20000000000000000000000000000f, "g", "kg"));
    }

    @Test
    void getCorrectConversionCode() {
        assertEquals("g to kg", gramToKg.getConversionCode());
    }
}
