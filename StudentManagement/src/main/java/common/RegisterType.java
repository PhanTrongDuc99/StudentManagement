/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author USER
 */
public enum RegisterType {
    INTERNET, MARKETING, DIRECT;

    private static final RegisterType[] ENUMS = RegisterType.values();

    public static RegisterType of(int status) {
        if (status < 1 || status > 3) {
            throw new NumberFormatException("Invalid value for Status: " + status);
        }
        return ENUMS[status - 1];
    }

    public int getValue() {
        return ordinal() + 1;
    }
}
