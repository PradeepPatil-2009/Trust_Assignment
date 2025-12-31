package com.example.clientapp1.utility;

import java.security.SecureRandom;
import org.springframework.stereotype.Component;

@Component
public class GenerateRandomNumber {

    private static final SecureRandom RANDOM = new SecureRandom();

    public String generate(int digits) {
        int min = (int) Math.pow(10, digits - 1);
        int max = (int) Math.pow(10, digits) - 1;
        return String.valueOf(RANDOM.nextInt(max - min + 1) + min);
    }
}
