package com.amdocs.test.solution;

public class StringRotation {

    /*public static void main(String[] args) {
        String str1 = "dog";
        String str2 = "god";
        System.out.println("Rotation needed to match with String 2 - " + findRotation(str1, str2));
    }*/

    public int findRotation(String str1, String str2) {
        if ((str1 == null && str2 == null) //return -1 if both are null
                || (str1 != null && str1.isEmpty() && str2.isEmpty()) //returning -1 if both are empty strings
                || ((str1 == null || str2 == null) || (str1.length() != str2.length()))) {
            return -1;
        } else {
            return calculateRotation(str1, str2);
        }
    }

    private static int calculateRotation(String str1, String str2) {
        int count = 0;
        for (int i = str1.length(); i >= 0; i--) {
            String tempString = str1.substring(i) + str1.substring(0, i);
            if (tempString.equals(str2)) {
                return count;
            }
            count++;
        }
        return -1;
    }
}
