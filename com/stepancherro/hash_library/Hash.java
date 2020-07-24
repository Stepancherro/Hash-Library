package com.stepancherro.hash_library;

import java.security.MessageDigest;

public class Hash {
    // allowed "SHA-256", "SHA-1", "SHA-384", "SHA-512", "MD5", "MD2" 

    public static String hash(String type, String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance(type);
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        }
        catch (Exception e){
            return "Error: " + e;

        }

    }
}
