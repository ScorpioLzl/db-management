package com.database.demo.utils;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Encryption {
    public String MD5Encrypt(byte[] password){
        byte[] result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            result = md.digest(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new String(result, StandardCharsets.UTF_8);
    }
}
