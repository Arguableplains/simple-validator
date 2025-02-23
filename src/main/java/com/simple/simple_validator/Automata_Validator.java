package com.simple.simple_validator;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Automata_Validator{

        // Define our PDA states:
        enum State {
            Q0,  // start
            Q1,  // main loop
            Q2   // accepting
        }

        public enum Validation {
            RG,
            CPF,
            INVALID
        }

        public static Validation validate(String input){

            if(validateRG(input))
                return Validation.RG;

            if(validateCPF(input))
                return Validation.CPF;

            return Validation.INVALID;
        }

        public static boolean validateRG(String input) {

            State currentState = State.Q0;

            Stack<Character> stack = new Stack<>();


            if (currentState == State.Q0) {

                for (int i = "nnnnnnnnf".length() - 1; i >= 0; i--) {
                    stack.push("nnnnnnnnf".charAt(i));
                }

                currentState = State.Q1;
            }

            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);

                switch (currentState) {
                    case Q1:
                        if (stack.isEmpty()) {

                            return false;
                        }

                        char top = stack.peek();

                        if (Character.isDigit(symbol) && top == 'n') {
                            stack.pop();
                        }

                        else if ((Character.isDigit(symbol) || symbol == 'X') && top == 'f') {
                            stack.pop();
                            currentState = State.Q2;
                        }

                        else if ((symbol == '.') && top == 'n') {

                            for (int k = 0; k < "nnnnnnf".length(); k++) {
                                if (stack.peek() == "nnnnnnf".charAt(k)){
                                    stack.pop();
                                }
                                else{
                                    return false;
                                }
                            }

                            for (int j = "nnn.nnn-f".length() - 1; j >= 0; j--) {
                                stack.push("nnn.nnn-f".charAt(j));
                            }
                        }

                        else if ((symbol == '.') && top == '.') {
                            stack.pop();
                        }

                        else if ((symbol == '-') && top == '-') {
                            stack.pop();
                        }

                        else {
                            return false;
                        }
                        break;

                    case Q2:
                        return false;

                    default:
                        return false;
                }
            }

            input = input.replaceAll("[^0-9X]", "");
            if (input.length() != 9) return false;

            int sum = 0;
            for (int i = 0; i < 8; i++) {
                sum += Character.getNumericValue(input.charAt(i)) * (9 - i);
            }

            int remainder = sum % 11;
            int digit = (remainder == 10) ? 'X' : remainder;

            char lastChar = input.charAt(8);

            return (currentState == State.Q2 && ((lastChar == 'X' && digit == 'X') || (Character.getNumericValue(lastChar) == digit)));
        }

        public static boolean validateCPF(String input) {

            State currentState = State.Q0;

            Stack<Character> stack = new Stack<>();

            if (currentState == State.Q0) {

                for (int i = "nnnnnnnnnnf".length() - 1; i >= 0; i--) {
                    stack.push("nnnnnnnnnnf".charAt(i));
                }

                currentState = State.Q1;
            }

            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);

                switch (currentState) {
                    case Q1:
                        if (stack.isEmpty()) {

                            return false;
                        }

                        char top = stack.peek();

                        if (Character.isDigit(symbol) && top == 'n') {
                            stack.pop();
                        }

                        else if (Character.isDigit(symbol) && top == 'f') {
                            stack.pop();
                            currentState = State.Q2;
                        }

                        else if ((symbol == '.') && top == 'n') {

                            for (int k = 0; k < "nnnnnnnf".length(); k++) {
                                if (stack.peek() == "nnnnnnnf".charAt(k)){
                                    stack.pop();
                                }
                                else{
                                    return false;
                                }
                            }

                            for (int j = "nnn.nnn-nf".length() - 1; j >= 0; j--) {
                                stack.push("nnn.nnn-nf".charAt(j));
                            }

                        }

                        else if ((symbol == '.') && top == '.') {
                            stack.pop();
                        }

                        else if ((symbol == '-') && top == '-') {
                            stack.pop();
                        }

                        else {
                            return false;
                        }
                        break;

                    case Q2:
                        return false;

                    default:
                        return false;
                }
            }

            input = input.replaceAll("[^0-9]", "");
            if (input.length() != 11) return false;

            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += Character.getNumericValue(input.charAt(i)) * (10 - i);
            }
            int remainder = sum % 11;
            int digit1 = (remainder < 2) ? 0 : 11 - remainder;

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += Character.getNumericValue(input.charAt(i)) * (11 - i);
            }
            remainder = sum % 11;
            int digit2 = (remainder < 2) ? 0 : 11 - remainder;

            return (currentState == State.Q2 && (Character.getNumericValue(input.charAt(9)) == digit1 && Character.getNumericValue(input.charAt(10)) == digit2));
        }

    }
