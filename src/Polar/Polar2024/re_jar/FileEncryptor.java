package Polar.Polar2024.re_jar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class FileEncryptor {
    private static final String ALGORITHM = "AES";

    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public static void encryptFile(String inputFile, String outputFile, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(1, secretKeySpec);
        byte[] ivBytes = cipher.getIV();
        try(InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher)) {
            outputStream.write(ivBytes);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) >= 0)
                cipherOutputStream.write(buffer, 0, bytesRead);
        }
    }

    public static void decryptFile(String encryptedFile, String outputFile, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), ALGORITHM);

        try (InputStream inputStream = new FileInputStream(encryptedFile);
             OutputStream outputStream = new FileOutputStream(outputFile)) {

            // Read the IV (first 16 bytes from the file)
            byte[] ivBytes = new byte[16]; // AES block size is 16 bytes
            inputStream.read(ivBytes);

            IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

            // Initialize cipher for decryption
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivSpec);

            // Decrypt the file contents
            try (CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = cipherInputStream.read(buffer)) >= 0)
                    outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
