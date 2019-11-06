package com.pearls.apititudinaltest.common;

public class Utils {

    public static String capitalize(String str) {
        if (str != null && !str.isEmpty()) {
            String firstLetter = str.substring(0, 1).toUpperCase();
            str = firstLetter + (str.length() > 1 ? str.substring(1) : "");
        }
        return str;
    }

}
