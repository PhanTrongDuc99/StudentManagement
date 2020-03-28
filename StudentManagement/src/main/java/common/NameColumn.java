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
public enum NameColumn {
    IdStudent,
    Name,
    PhoneNumber,
    Email,
    DayOfBirth,
    Hometown,
    Gender,
    CurrentAddress,
    DiscountStatus,
    Cost,
    RegisterStatus,
    RegisterType
    ;
  private static final NameColumn[] ENUMS = NameColumn.values();

    public static NameColumn of(int number) {
        if (number < 1 || number > 3) {
            throw new NumberFormatException("Invalid value for name: " + number);
        }
        return ENUMS[number - 1];
    }

    public int getValue() {
        return ordinal() + 1;
    }
}
