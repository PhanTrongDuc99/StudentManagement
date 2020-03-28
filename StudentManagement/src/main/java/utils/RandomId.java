/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.List;
import java.util.Random;

/**
 *
 * @author USER
 */
public class RandomId {

    public RandomId() {
    }

    public static String randomId(List<String> strings) {
        Random random = new Random();
        while (true) {
            int rand = 100000000 + random.nextInt(100000000);
            if (!strings.contains(String.valueOf(rand))) {
                return String.valueOf(rand);
            }
        }
    }

}
