package com.example.unitconversion.service.conversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}
