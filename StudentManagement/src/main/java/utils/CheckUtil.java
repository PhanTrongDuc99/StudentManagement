/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USER
 */
public class CheckUtil {

    public CheckUtil() {
    }

    public static boolean validateEmail(String email) {
        String regex = "^[a-zA-Z]+\\w*@{1}[a-zA-Z]+(.com|mail.com|mail.com.vn)$";
        Pattern patern = Pattern.compile(regex);
        Matcher matcher = patern.matcher(email);
        return matcher.find();
    }
     public static boolean validatePhone(String email) {
        String regex = "[0-9]+";
        Pattern patern = Pattern.compile(regex);
        Matcher matcher = patern.matcher(email);
        return matcher.find();
    }
}
