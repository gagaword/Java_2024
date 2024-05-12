package CTF.BugkuCTF.gctf_mobile1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Exp {
    public static void main(String[] args) {
       boolean isflag  = checkSN("Tenshine","");
    }
    public static boolean checkSN(String userName, String sn) {
        if (userName != null) {
            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                digest.reset();
                digest.update(userName.getBytes());
                byte[] bytes = digest.digest();
                String hexstr = toHexString(bytes, "");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < hexstr.length(); i += 2) {
                    sb.append(hexstr.charAt(i));
                }
                String userSN = sb.toString();

                System.out.println("flag{" + userSN + "}");

                return ("flag{" + userSN + "}").equalsIgnoreCase(sn);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private static String toHexString(byte[] bytes, String separator) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 255);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex).append(separator);
        }
        return hexString.toString();
    }

    // flag{bc72f242a6af3857}
}
