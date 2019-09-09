package com.amdocs.test.solution;

import java.util.regex.Pattern;

public class HeaderMarkdown {

    private static final String HEADER_REGEX = "#{1,6}";

    /*public static void main(String[] args) {
        String inputString = "####### Header ";
        System.out.println(parseString(inputString));
    }*/

    public String parseString(String inputString) {
        if (inputString != null && !inputString.isEmpty()) {
            String[] headerArr = inputString.split(" ");
            String headerLevel = headerArr[0];
            if (!headerLevel.isEmpty() && headerLevel.length() <= 6 && Pattern.matches(HEADER_REGEX, headerLevel)) {
                String outputString = "";
                outputString += populateStartHeaderTag(headerLevel);
                outputString += inputString.substring(headerLevel.length()).trim();
                outputString += populateEndHeaderTag(headerLevel);
                return outputString;
            }
        }
        return inputString;
    }

    private static String populateStartHeaderTag(String headerLevel) {
        return "<h" + headerLevel.length() + ">";
    }

    private static String populateEndHeaderTag(String headerLevel) {
        return "</h" + headerLevel.length() + ">";
    }
}
