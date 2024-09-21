package DEX;
import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.zip.Adler32;

public class DexFixer {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("src/DEX/classes4.dex");
        byte[] dexBytes = Files.readAllBytes(path);

        // Fix checksum
        Adler32 adler = new Adler32();
        adler.update(dexBytes, 12, dexBytes.length - 12); // Exclude magic and checksum
        int checksum = (int) adler.getValue();
        dexBytes[8] = (byte) (checksum & 0xff);
        dexBytes[9] = (byte) ((checksum >> 8) & 0xff);
        dexBytes[10] = (byte) ((checksum >> 16) & 0xff);
        dexBytes[11] = (byte) ((checksum >> 24) & 0xff);

        // Fix signature
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(dexBytes, 32, dexBytes.length - 32); // Exclude magic, checksum, and signature
        byte[] sha1 = md.digest();
        System.arraycopy(sha1, 0, dexBytes, 12, 20); // Write back SHA-1 to dex header

        Files.write(path, dexBytes); // Save the fixed dex file
        System.out.println("DEX file fixed successfully.");
    }
}
