package CTF.ISCC.Puzzle_Game;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class Puzzle_Game_exp {
    private static final int SALT_LENGTH = 16;

    public static void main(String[] args) {

        // 模拟
        String stringExtra =  "04999999";
        String stringExtra2 = "gwC9nOCNUhsHqZm";

        // 模拟
        String encryptedString = encrypt2(encrypt(stringExtra, stringExtra2));
        System.out.println(encryptedString.substring(0, 32));
    }

    public static String encrypt(String str, String str2) {
        byte[] generateSalt = generateSalt(SALT_LENGTH);
        byte[] customEncrypt = customEncrypt(combineStrings(str, str2).getBytes(StandardCharsets.UTF_8), generateSalt);
        byte[] bArr = new byte[generateSalt.length + customEncrypt.length];
        System.arraycopy(generateSalt, 0, bArr, 0, generateSalt.length);
        System.arraycopy(customEncrypt, 0, bArr, generateSalt.length, customEncrypt.length);
        return Base64.getEncoder().encodeToString(bArr);
    }

    private static byte[] generateSalt(int i) {
        byte[] bArr = new byte[i];
        new Random(7906L).nextBytes(bArr);
        return bArr;
    }

    private static String combineStrings(String str, String str2) {
        return str + str2;
    }

    private static byte[] customEncrypt(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }

    public static String encrypt2(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) ((bytes[i] + Byte.MAX_VALUE) % 256);
        }
        byte[] bArr = new byte[bytes.length];
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[i2] = (byte) (i2 % 2 == 0 ? bytes[i2] ^ 123 : bytes[i2] ^ 234);
        }
        return Base64.getEncoder().encodeToString(bArr);
    }
}
