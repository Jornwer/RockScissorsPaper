package com.jornwer;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class KeyGenerator {
    public static String generateRandomKey() {
        byte[] bytes = new byte[32];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);

        byte[] key = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            key = md.digest(bytes);
            key = Arrays.copyOf(key, 16);
        } catch (NoSuchAlgorithmException ignored) {}

        return String.format("%x", new BigInteger(1, key));
    }
}
