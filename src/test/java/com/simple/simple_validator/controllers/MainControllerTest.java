package com.simple.simple_validator.controllers;

import java.io.InputStream;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MainController.class)
public class MainControllerTest{

    @Autowired
    private MockMvc mockMvc;

    InputStream is;
    BufferedReader reader;
    JsonNode rootNode;
    Random random;

    MainControllerTest() throws Exception{
        random = new Random();
        is = getClass().getClassLoader().getResourceAsStream("people.json");
        if (is == null) throw new FileNotFoundException("Error: people.json not found");

        ObjectMapper mapper = new ObjectMapper();
        rootNode = mapper.readTree(is);

        if(!rootNode.isArray()){throw new Exception();}
    }

    @Test
    public void testValidate_ValidRG() throws Exception {

        JsonNode randomPerson = rootNode.get(random.nextInt(rootNode.size()));

        mockMvc.perform(post("/validate")
                .param("document", randomPerson.get("rg").asText()))
                .andExpect(status().isOk())
                .andExpect(model().attribute("message", "Valid RG!"))
                .andExpect(model().attribute("valid", true))
                .andExpect(view().name("validator"));
    }

    @Test
    public void testValidate_ValidCPF() throws Exception {

        JsonNode randomPerson = rootNode.get(random.nextInt(rootNode.size()));

        mockMvc.perform(post("/validate")
                .param("document", randomPerson.get("cpf").asText()))
                .andExpect(status().isOk())
                .andExpect(model().attribute("message", "Valid CPF!"))
                .andExpect(model().attribute("valid", true))
                .andExpect(view().name("validator"));
    }

    @Test
    public void testValidate_InvalidInput() throws Exception {
        mockMvc.perform(post("/validate")
                .param("document", "invalid_input"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("message", "Invalid Input!"))
                .andExpect(model().attribute("valid", false))
                .andExpect(view().name("validator"));
    }

}
