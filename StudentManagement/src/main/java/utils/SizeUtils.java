/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;

/**
 *
 * @author LENOVO
 */
public class SizeUtils {
    public SizeUtils(){
        
    }
    public static int getPreWidth(Component component) {
        return (int) component.getPreferredSize().getWidth();
    }

    public static int getPreHeight(Component component) {
        return (int) component.getPreferredSize().getHeight();
    }

    public static int getWidth(Component component) {
        return (int) component.getSize().getWidth();
    }

    public static int getHeight(Component component) {
        return (int) component.getSize().getHeight();
    }
}
