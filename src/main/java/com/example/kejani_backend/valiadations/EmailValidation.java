package com.example.kejani_backend.valiadations;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class EmailValidation {
    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }



}
