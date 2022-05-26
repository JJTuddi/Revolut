package com.app.banking;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestCreationFactory {

    public static String randomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 12;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static LocalDateTime randomDate() {
        LocalDateTime now = LocalDateTime.now();
        int year = 60 * 60 * 24 * 365;
        return now.plusSeconds((long) new Random().nextInt(-2 * year, 2 * year));// +- 2 years;
    }

    public static Float randomFloat(){
        return new Random().nextFloat();
    }

    public static Integer randomInteger(){
        return new Random().nextInt();
    }
}
