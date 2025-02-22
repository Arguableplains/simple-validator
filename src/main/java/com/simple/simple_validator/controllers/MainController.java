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
import com.simple.simple_validator.Automata_Validator.Validation;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "validator";
    }

    @PostMapping("/validate")
    public String validate(@RequestParam String document, Model model) {

        Validation result = Validation.INVALID;
        String message = "";

        try{result = Automata_Validator.validate(document);}
        catch(Exception e){model.addAttribute("message", "Something went wrong!");}

        switch (result) {
            case RG:
                message = "Valid RG!";
                break;
            case CPF:
                message = "Valid CPF!";
                break;
            case INVALID:
                message = "Invalid Input!";
                break;
        }

        model.addAttribute("message", message);
        model.addAttribute("valid", result != Validation.INVALID);
        return "validator";
    }
}

