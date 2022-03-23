package com.nathan.insultgenerator.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nathan.insultgenerator.InsultGeneratorApplication;

import com.nathan.insultgenerator.models.Insult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { InsultGeneratorApplication.class })
@WebAppConfiguration
public class InsultControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    
    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void getInsultForName() throws Exception {
        ResultActions result = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/insult/name/{name}", "Nathan"))
                .andDo(
                        print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.personToInsult").value("Nathan"));

        //check the response body can be converted to an Insult Object.
        assertDoesNotThrow(() -> {
            new ObjectMapper().readValue(result.andReturn().getResponse().getContentAsString(), Insult.class);
        });



    }
}
