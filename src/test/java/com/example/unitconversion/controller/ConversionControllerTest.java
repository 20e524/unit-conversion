package com.example.unitconversion.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ConversionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void returnsOk() throws Exception {
        String jsonRequest = "{\"fromValue\":10,\"fromType\":\"kg\", \"toType\":\"g\"}";

        this.mockMvc.perform(
                post("/api/convert/")
                        .content(jsonRequest)
                        .header(HttpHeaders.CONTENT_TYPE, "application/json")
        ).andExpect(status().isOk());

    }

}