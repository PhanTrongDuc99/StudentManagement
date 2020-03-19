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
    IdStudent(0),
    Name(1),
    PhoneNumber(2),
    Email(3),
    DayOfBirth(4),
    Hometown(5),
    Gender(6),
    CurrentAddress(7),
    DiscountStatus(8),
    Cost(9),
    RegisterStatus(10),
    RegisterType(11);

    private final int index;

    private NameColumn(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
