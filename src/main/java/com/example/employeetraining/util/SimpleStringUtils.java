package com.example.employeetraining.util;

import java.util.Random;

public class SimpleStringUtils {

    public static String randomString(int size) {
        return randomString(size, false);
    }

    public static String randomString(int size, boolean numberOnly) {
        String saltChars = "1234567890";
        if (!numberOnly) {
            saltChars += "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        }

        StringBuilder salt = new StringBuilder();
        Random rand = new Random();
        while (salt.length() < size) {
            int index = (int) (rand.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }

        return salt.toString();
    }
}
