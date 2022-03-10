package com.example.unitconversion.service.conversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    void executeGtoKgWithZeroFromValue() throws Exception {
        assertThrows(Exception.class, () -> gramToKg.execute(0f, "g", "kg"));
    }

    @Test
    void executeGtoKgWithNegativeFromValue() throws Exception {
        assertThrows(Exception.class, () -> gramToKg.execute(-9f, "g", "kg"));
    }

    @Test
    void executeGtoKgMaxValue() throws Exception {
        assertEquals(20000000000000000000000000f, gramToKg.execute(20000000000000000000000000000f, "g", "kg"));
    }

    @Test
    void executeGtoKgWrongFromType() throws Exception {
        assertEquals(4.00099f, gramToKg.execute(4000.99f, "gg", "kg"));
    }

    /*
    @Test
    void executeGtoKgWrongDataType() throws Exception {
        assertEquals(4.00099f, gramToKg.execute(4000f, "g", "kg"));
    }
     */
}
