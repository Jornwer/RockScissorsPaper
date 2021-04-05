package com.jornwer;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class HmacGenerator {
    private final String key;
    private final String value;

    public HmacGenerator(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String generateHmacSha() {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(value.getBytes(StandardCharsets.UTF_8));
            return String.format("%x", new BigInteger(1, rawHmac));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
