package com.amdocs.test.solution;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharacter {

    /*public static void main(String[] args) {
        String testString = "abcd/-@!12 3 4";

        if(testString!=null && !testString.isEmpty()) {
            System.out.println(checkUniqueChar(testString));
        } else {
            System.out.println("String is either null or empty");
        }
    }*/

    public boolean checkUniqueChar(String testString) {
        if(testString!=null && !testString.isEmpty()) {
            char[] charArray = testString.toCharArray();
            Map<Character, Character> charMap = new HashMap<>();

            for(char charcter : charArray){
                if(charMap.containsKey(charcter)){
                    return false;
                } else {
                    charMap.put(charcter, charcter);
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
