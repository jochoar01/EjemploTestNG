package com.academy.tae.util;

import java.util.Random;

/**
 * Helper class, was created with the aim of helping various aspects of the flows being tested.
 * It displays a singleton pattern to only allow one point of access in the jvm created.
 * @author juanpablo.vasquez
 */
public class Helper {
    /**
     * Helper private static instance
     */
    private static Helper instance;

    /**
     * Singleton pattern application
     * @return an instance of Helper class
     */
    public static Helper getInstance() {
        if(instance == null) {
            instance = new Helper();
        }
        return instance;
    };

    /**
     * The method getRandom(), allow us to generate different strings based on tye @TYPE value that its sent
     * <p>
     * The strings may vary in size and composition, the allowed options are:
     * <ul>
     *     <li>TYPE.FIRST_NAME: Will generate an string only with letters (upper or lower) of 10 characters</li>
     *     <li>TYPE.LAST_NAME: Will generate an string only with letters (upper or lower) of 10 characters</li>
     *     <li>TYPE.EMAIL: Will generate a valid GMAIL address, with the body being alphanumeric of 10 characters</li>
     *     <li>TYPE.PASSWORD: Will generate an string with alphanumeric and special characters of 15 characters</li>
     * </ul>
     * @param TYPE of random to generate
     * @return an string based on @TYPE sent
     */
    public String getRandom(Type TYPE) {
        String randomValue;
        switch (TYPE) {
            case FIRST_NAME:
            case LAST_NAME:
                randomValue = generator("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", 10);
                break;
            case EMAIL:
                randomValue = generator("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890", 10) + "@gmail.com";
                break;
            case PASSWORD:
                randomValue = generator("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890*_-%&$#\"'!", 15);
                break;
            default:
                randomValue = "";
                break;
        }
        return randomValue;
    }

    /**
     * Generator method, to generate a string given the base CHARS and its length
     * @param CHARS as base to generate the string from
     * @param length as maximum length of the string to generate
     * @return a random string based on @CHARS and @length
     */
    private String generator(String CHARS, int length) {
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while(salt.length() < length) {
            int index = (int) (rnd.nextFloat() * CHARS.length());
            salt.append(CHARS.charAt(index));
        }
        return salt.toString();
    }
}
