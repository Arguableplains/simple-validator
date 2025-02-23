package com.simple.simple_validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Automata_ValidatorTest {

    @Test
    public void testValidateRG_Valid() {
        // Valid RG with punctuation
        assertTrue(Automata_Validator.validateRG("37.387.950-7"));
        // Valid RG without punctuation
        assertTrue(Automata_Validator.validateRG("373879507"));
    }

    @Test
    public void testValidateRG_Invalid() {
        // Invalid RG (wrong check digit)
        assertFalse(Automata_Validator.validateRG("12.345.678-9"));
        // Invalid RG (incorrect format)
        assertFalse(Automata_Validator.validateRG("12.345.678"));
    }

    @Test
    public void testValidateCPF_Valid() {
        // Valid CPF with punctuation
        assertTrue(Automata_Validator.validateCPF("627.811.290-62"));
        // Valid CPF without punctuation
        assertTrue(Automata_Validator.validateCPF("62781129062"));
    }

    @Test
    public void testValidateCPF_Invalid() {
        // Invalid CPF (wrong check digits)
        assertFalse(Automata_Validator.validateCPF("123.456.789-00"));
        // Invalid CPF (incorrect format)
        assertFalse(Automata_Validator.validateCPF("123.456.789"));
    }

    @Test
    public void testValidate_RG() {
        assertEquals(Automata_Validator.Validation.RG, Automata_Validator.validate("37.387.950-7"));
    }

    @Test
    public void testValidate_CPF() {
        assertEquals(Automata_Validator.Validation.CPF, Automata_Validator.validate("627.811.290-62"));
    }

    @Test
    public void testValidate_Invalid() {
        assertEquals(Automata_Validator.Validation.INVALID, Automata_Validator.validate("invalid_input"));
    }
}
