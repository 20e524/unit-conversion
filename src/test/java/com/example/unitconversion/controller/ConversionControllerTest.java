package com.example.unitconversion.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ConversionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void returnsOk() throws Exception {
        List<String> jsonRequests = new ArrayList<>();
        jsonRequests.add("{\"fromValue\":10,\"fromType\":\"kg\", \"toType\":\"g\"}");
        jsonRequests.add("{\"fromValue\":10,\"fromType\":\"g\", \"toType\":\"kg\"}");
        jsonRequests.add("{\"fromValue\":10,\"fromType\":\"F\", \"toType\":\"C\"}");
        jsonRequests.add("{\"fromValue\":10,\"fromType\":\"C\", \"toType\":\"F\"}");

        for (String jsonRequest : jsonRequests) {
            this.mockMvc.perform(
                            post("/api/convert/")
                                    .content(jsonRequest)
                                    .header(HttpHeaders.CONTENT_TYPE, "application/json")
                    )
                    .andExpect(
                            status()
                                    .isOk()
                    );
        }



    }

    @Test
    void returnsNotOk() throws Exception {
        String jsonRequest = "{\"fromValue\":10,\"fromType\":\"something-else\", \"toType\":\"g\"}";

        this.mockMvc.perform(
                        post("/api/convert/")
                                .content(jsonRequest)
                                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                )
                .andExpect(
                        status()
                                .is4xxClientError()
                );

    }

}