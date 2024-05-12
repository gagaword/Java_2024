package CTF.WuAi;

import java.awt.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Apk {

    public static void main(String[] args) {
        String userName = "GaGa";
        String sn = "02282468331cdb89";
        boolean is = checkSN(userName, sn);
        if (is){
            System.out.println("OK");
        }else {
            System.out.println("Error");
        }
    }

    public static boolean checkSN(String userName, String sn) {
        try {
            if (userName.length() != 0 && (sn != null && sn.length() == 16)) {
                MessageDigest messageDigest0 = MessageDigest.getInstance("MD5");
                messageDigest0.reset();
                messageDigest0.update(userName.getBytes());
                String s2 = toHexString(messageDigest0.digest());
                System.out.println("s2 = " + s2);
                System.out.println("s2.length() = " + s2.length());
                StringBuilder sb = new StringBuilder();
//                    16
                for (int i = 0; true; i += 2) {
                    if (i >= s2.length()) {
                        return sb.toString().equalsIgnoreCase(sn);
                    }
                    sb.append(s2.charAt(i));
//                    System.out.println("Updated sb: " + sb.toString());
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
        MD5加密
     */
    private static String toHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 255);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
