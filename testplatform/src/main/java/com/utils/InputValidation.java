package com.utils;

public class InputValidation {

    public static boolean isValidInput(String s) {
        boolean isValidInput = true;
        if (s == null) {
            isValidInput=false;
            return isValidInput;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
                if (!Character.isWhitespace(c)) {
                    isValidInput = false;
                    return isValidInput;
                }
            }
        }
        return isValidInput;
    }

    public static String removeLastChar(String str) {
        return str.substring(0,str.length()-1);
    }


}
