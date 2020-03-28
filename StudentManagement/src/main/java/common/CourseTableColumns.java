/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author Mr.Chien
 */
public enum CourseTableColumns {
    ID("Id Course"),
    NAME("Name course"),
    CLASSQUANTITY("Class quantity"),
    STARTDAY("Start day"),
    ENDDAY("End day"),
    COST("Cost");
    
    private final String value;

    CourseTableColumns(String value) {
        this.value = value;
    }
    
    public String getText() {
        return this.value;
    }
    
}
