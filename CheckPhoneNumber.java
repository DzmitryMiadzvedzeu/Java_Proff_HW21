package com.telran.org.homeworktwentyone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPhoneNumber {
    public static void main(String[] args) {

        // chec phone number 7 digit , 7777777 or 777-7777, 777 7777 : range (0-9)

        //case 1.
        // seven digits 2222222
        //  regex is : \d\d\d\d\d\d\d

        //case 2.
        // three digits + "-" + four digits 222-2222
        // regex is : \d\d\d.\d\d\d\d

        // case 3.
        // three digits + " " + four digits
        // regex is : \d\d\d\s\d\d\d\d

        // full regex
        // \d\d\d\d\d\d\d | \d\d\d\D\d\d\d\d | \d\d\d\s\d\d\d\d

        String regex = ("\\d\\d\\d\\d\\d\\d\\d|\\d\\d\\d\\D\\d\\d\\d\\d|\\d\\d\\d\\s\\d\\d\\d\\d");

        String number1 = "1234567";
        System.out.println("Is number " + number1 + " valid " + isValidPhoneNumber(regex, number1));

        String number2 = "123456-7";
        System.out.println("Is number " + number2 + " valid " + isValidPhoneNumber(regex, number2));

        String number3 = "123-4567";
        System.out.println("Is number " + number3 + " valid " + isValidPhoneNumber(regex, number3));

        String number4 = "12--34567";
        System.out.println("Is number " + number4 + " valid " + isValidPhoneNumber(regex, number4));

        String number5 = "12345678";
        System.out.println("Is number " + number5 + " valid " + isValidPhoneNumber(regex, number5));

        String number6 = "123 4567";
        System.out.println("Is number " + number6 + " valid " + isValidPhoneNumber(regex, number6));

        String number7 = "1222234567";
        System.out.println("Is number " + number7 + " valid " + isValidPhoneNumber(regex, number7));

        String number8 = "1234 567";
        System.out.println("Is number " + number8 + " valid " + isValidPhoneNumber(regex, number8));
    }

    private static boolean isValidPhoneNumber(String regex, String number) {
        if (number == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
