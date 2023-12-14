package com.telran.org.homeworktwentyone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChekPassword {
    public static void main(String[] args) {

        //check password

        //pattern must include
        //- Contained at least one uppercase and one lowercase letter.
        //- Included at least one number and one special character @#$%^&+=.
        //- Did not contain spaces.
        //- Was at least 8 characters long.

        // regex case
        // (?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=])(?!.*\\s).{8,}

        String regex = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,}";

        String password1 = "sss2sss!";
        System.out.println("Is this password " + password1 + " is valid : "
                + isValidPassword(regex,password1)); //false

        String password2 = "sssSsss!";
        System.out.println("Is this password " + password2 + " is valid : "
                + isValidPassword(regex,password2)); //false

        String password3 = "DomKRad1234!";
        System.out.println("Is this password " + password3 + " is valid : "
                + isValidPassword(regex,password3)); //true
    }

    private static boolean isValidPassword(String regex, String password) {
        if (password == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
