package com.example.reverseproject.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Igor Hnes on 14.09.2022.
 */
@SpringBootTest
@AutoConfigureMockMvc
class ReverseControllerTest {

    private static final String API = "http://localhost:8080/api/reverse";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void reverse() throws Exception {
        String text = "123";
        this.mockMvc.perform(get(API + "?text=" + text)).andExpect(status().isOk())
                .andExpect(content().string(equalTo("321")));
    }
}
