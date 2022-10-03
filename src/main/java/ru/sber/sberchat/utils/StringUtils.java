package ru.sber.sberchat.utils;

import java.util.Random;

public class StringUtils {
    public static String generateString(RandomTypesEnum type, int length) {

        String characters;
        if (type == RandomTypesEnum.DIGITS) {
            characters = "0123456789";
        } else {
            characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }

        Random rng = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    //ToDo: Реализовать метод генерации строк случайной длинны
//    public static String generateStringWithRandomLen() {
//        return null;
//    }
}
