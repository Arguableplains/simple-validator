package com.simple.simple_validator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import com.simple.simple_validator.Automata_Validator;

@Controller
public class MainController {

    boolean isValid;

    @GetMapping("/")
    public String home() {
        return "validator";
    }

    @PostMapping("/validate")
    public String validate(@RequestParam String document, Model model) {

        try{isValid = Automata_Validator.validate(document);}
        catch(Exception e){model.addAttribute("message", "Something went wrong!");}

        model.addAttribute("message", isValid ? "Valid RG/CPF!" : "Invalid RG/CPF!");
        model.addAttribute("valid", isValid);
        return "validator";
    }
}

