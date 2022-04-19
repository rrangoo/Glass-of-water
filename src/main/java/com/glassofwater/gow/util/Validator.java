package com.glassofwater.gow.util;

public class Validator {
    public static boolean validateEmail(String email){
        return email.contains("@");
    }
}
