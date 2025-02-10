package com.simple.simple_validator;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Automata_Validator{

    enum AF_STATE {ZERO, START, RUNNING, STOPPED_BY_SIZE, STOPPED_BY_CHARACTER, INVALID_CHARACTER_LINE, ENDED};

    static AF_STATE actualState = AF_STATE.ZERO;

    public static boolean validate(String input) throws Exception{

            String charactersLine = input;

            actualState = AF_STATE.ZERO;

            // RG or CPF input
            // 00.000.000-0
            // 000.000.000-00

            // First AF - Size Verification
            actualState = AF_STATE.START;
            actualState = AF_STATE.RUNNING;

            int string_size = 0;
            try{
                while(true){
                    IsEmpty(charactersLine.charAt(string_size));
                    string_size++;
                }

            }catch(StringIndexOutOfBoundsException e){
                System.out.println("The Automata is Over!");
            }

            actualState = AF_STATE.ZERO;
            actualState = AF_STATE.START;
            actualState = AF_STATE.RUNNING;

            switch(string_size){
                case 9:
                    return MaybeRG(charactersLine, false);
                case 11:
                    return MaybeCPF(charactersLine, false);
                case 12:
                    return MaybeRG(charactersLine, true);
                case 14:
                    return MaybeCPF(charactersLine, true);
                default:
                    actualState = AF_STATE.STOPPED_BY_SIZE;
                    return Ender();
            }

    }

    // Verificators
    public static boolean IsEmpty(char T){
        return (T == '0') ? true : false;
    }

    public static boolean IsEmpty(String T){
        return (T.isEmpty()) ? true : false;
    }

    public static boolean IsNumber(char T){
        return (T >= 48 && T <= 57 ) ? true : false;
    }

    public static boolean IsDot(char T){
        return (T == 46 ) ? true : false;
    }

    public static boolean IsMinus(char T){
        return (T == 45 ) ? true : false;
    }

    public static boolean MaybeRG(String charactersLine, boolean withPonctuation){

        int start_index = 0;

        if(!(IsNumber(charactersLine.charAt(start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if(!(IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if(!IsDot(charactersLine.charAt(++start_index)) && withPonctuation){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }
        else if (!withPonctuation){start_index--;}

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if(!IsDot(charactersLine.charAt(++start_index)) && withPonctuation){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }
        else if (!withPonctuation){start_index--;}

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if(!IsMinus(charactersLine.charAt(++start_index)) && withPonctuation){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }
        else if (!withPonctuation){start_index--;}

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if(validateRG(charactersLine)){
            actualState = AF_STATE.ENDED;
            return Ender();
        }
        else{
            actualState = AF_STATE.INVALID_CHARACTER_LINE;
            return Ender();
        }

    }

    public static boolean MaybeCPF(String charactersLine, boolean withPonctuation){

        int start_index = 0;

        if(!(IsNumber(charactersLine.charAt(start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if(!(IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if(!(IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if(!IsDot(charactersLine.charAt(++start_index)) && withPonctuation){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }
        else if (!withPonctuation){start_index--;}

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if(!IsDot(charactersLine.charAt(++start_index)) && withPonctuation){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }
        else if (!withPonctuation){start_index--;}

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if(!IsMinus(charactersLine.charAt(++start_index)) && withPonctuation){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }
        else if (!withPonctuation){start_index--;}

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if((!IsNumber(charactersLine.charAt(++start_index)))){
            actualState = AF_STATE.STOPPED_BY_CHARACTER;
            return Ender();
        }

        if(validateCPF(charactersLine)){
            actualState = AF_STATE.ENDED;
            return Ender();
        }
        else{
            actualState = AF_STATE.INVALID_CHARACTER_LINE;
            return Ender();
        }

    }

    public static boolean validateCPF(String cpf) {
        // Remove non-numeric characters
        cpf = cpf.replaceAll("[^0-9]", "");

        // Calculate the first verification digit
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int remainder = sum % 11;
        int digit1 = (remainder < 2) ? 0 : 11 - remainder;

        // Calculate the second verification digit
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        remainder = sum % 11;
        int digit2 = (remainder < 2) ? 0 : 11 - remainder;

        // Check if the calculated digits match the provided ones
        return Character.getNumericValue(cpf.charAt(9)) == digit1 &&
               Character.getNumericValue(cpf.charAt(10)) == digit2;
    }

    public static boolean validateRG(String rg) {
        // Remove non-numeric characters
        rg = rg.replaceAll("[^0-9X]", "");

        // Compute the verification digit
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            sum += Character.getNumericValue(rg.charAt(i)) * (9 - i);
        }

        int remainder = sum % 11;
        int digit = (remainder == 10) ? 'X' : remainder;

        // Compare with the last character (which could be 'X')
        char lastChar = rg.charAt(8);
        return (lastChar == 'X' && digit == 'X') || (Character.getNumericValue(lastChar) == digit);
    }

    // Final method
    public static boolean Ender() {
        switch(actualState){
            case RUNNING:
                System.out.println("Automata can Continue!!");
                return true;
            case STOPPED_BY_CHARACTER:
                System.out.println("Automata Stopped Because a Character Error!!");
                return false;
            case STOPPED_BY_SIZE:
                System.out.println("Automata Stopped Because a Size Error!!");
                return false;
            case INVALID_CHARACTER_LINE:
                System.out.println("Automata validaded the line as INVALID!!");
                return false;
            case ENDED:
                System.out.println("Automata Ended With Success!!");
                return true;
            default:
                return false;
        }
    }

}
