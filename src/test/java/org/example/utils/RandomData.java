package org.example.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {
    // Генерация случайных строк из букв (для общего использования)
    public static String randomString() {
        return "test_" + RandomStringUtils.randomAlphabetic(8);
    }

    // Генерация случайных строк, содержащих только цифры
    public static String randomNumericString(int length) {
        return RandomStringUtils.randomNumeric(length);
    }
}
