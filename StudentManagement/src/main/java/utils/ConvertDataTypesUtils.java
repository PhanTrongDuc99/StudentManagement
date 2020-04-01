/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author PC
 */
public class ConvertDataTypesUtils {

    public static String valueOf(boolean gender) {
        if (gender == true) {
            return "Woman";
        }
        return "Man";
    }
}
