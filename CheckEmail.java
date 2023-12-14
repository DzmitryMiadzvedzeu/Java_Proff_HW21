package com.telran.org.homeworktwentyone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEmail {
    public static void main(String[] args) {

        //2. Chek email

        // regex case
        // left side + "@" + right side

        // left side
        // can consist 0-9, a-z, A-Z, "." , "-"
        // after "." and "-" might be symbols 0-9, a-z, A-Z

        //right side
        // start after "@"
        // can consist 0-9, a-z, A-Z, "." , "-"
        // after "." and "-" might be symbols 0-9, a-z, A-Z
        // but in the end might be : "." + symbols a-z (max value = 4 and min value = 2)

        // final regex with conditions close to reality
        // (\w{1,20}[\-.]?\w{1,20})*@(\w{1,20}[\-.]?\w{1,20})+[\.]{1}\a-z{2,4}
        String regex = "\\w{1,20}([\\-.]?\\w{1,20})*@\\w{1,20}([\\-.]?\\w{1,20})*\\.\\a-z{2,4}";

        String email1 = "Ggg1-ggg2.Ddd2-ddd3@Sss4-sss5.Fff6-fff7.dru";
        System.out.println("Is that normal email :  " + isValidEmail(regex, email1));

        String email2 = "Ggg1-ggg2.Ddd2@Sss4-Fff7.dru";
        System.out.println("Is that normal email :  " + isValidEmail(regex, email2));

        String email3 = "Ggg1-g.Ddd2@Sss4-f.dru";
        System.out.println("Is that normal email :  " + isValidEmail(regex, email3));

        String email4 = "user1234@example-mail.com";
        System.out.println("Is that normal email :  " + isValidEmail(regex, email4));
    }

    private static boolean isValidEmail(String regex, String email) {
        if (email == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}


// работает не корректно, не могу подобрать имэйл который будет подходить шаблону,
// хотя даже гтп сказал что всё должно подходить.....