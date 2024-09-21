package Polar.Polar2024.re_jar;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class KeyGenerator {
    public String getAesKeyB64String() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String password = "PolarD&N CTF";
        byte[] salt = { 1, 35, 69, 103, -119, -85, -51, -17 };
        int iterationCount = 10000;
        int keyLength = 128;
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterationCount, keyLength);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        SecretKey secretKey = secretKeyFactory.generateSecret(spec);
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
}
