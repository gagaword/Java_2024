package CTF.XYCTF.Trustme;


import java.util.Arrays;

/**
 * 送送送送
 * @author li
 * @version 0.12
 */
public class Main {
    public static  void main(String[] args) {
        String key = "XYCTF";
        String input = "5a3c46e0228b444decc7651c8a7ca93ba4cb35a46f7eb589bef4";
        byte[] cipher =  RC4(input.getBytes(), key.getBytes());
        System.out.println(Arrays.toString(cipher));

        String pass = "The Real username is admin";
        if(bytesToHex(RC4(pass.getBytes(),"XYCTF".getBytes())).equals("5a3c46e0228b444decc7651c8a7ca93ba4cb35a46f7eb589bef4")) {
            System.out.println("OK");
        }
    }
    private static byte[] decrypt(byte[] arr_b) {
        for(int v = 0; v < arr_b.length; ++v) {
            arr_b[v] = (byte)(arr_b[v] ^ 0xFF);
        }
        return arr_b;
    }
    public static byte[] RC4(byte[] arr_b, byte[] arr_b1) {
        int[] arr_v = new int[0x100];
        byte[] arr_b2 = new byte[0x100];
        byte[] arr_b3 = new byte[arr_b.length];
        for (int v1 = 0; v1 < 0x100; ++v1) {
            arr_v[v1] = v1;
            arr_b2[v1] = arr_b1[v1 % arr_b1.length];
        }

        int v2 = 0;
        for (int v3 = 0; v3 < 0x100; ++v3) {
            int v4 = arr_v[v3];
            v2 = v2 + v4 + arr_b2[v3] & 0xFF;
            arr_v[v3] = arr_v[v2];
            arr_v[v2] = v4;
        }

        int v5 = 0;
        for (int v = 0; v < arr_b.length; ++v) {
            v5 = v5 + 1 & 0xFF;
            int v6 = arr_v[v5];
            v2 = v2 + v6 & 0xFF;
            arr_v[v5] = arr_v[v2];
            arr_v[v2] = v6;
            arr_b3[v] = (byte) (arr_v[arr_v[v5] + v6 & 0xFF] ^ arr_b[v]);
        }

        return arr_b3;
    }

    public static String bytesToHex(byte[] arr_b) {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < arr_b.length; ++v) {
            String s = Integer.toHexString(arr_b[v] & 0xFF);
            if(s.length() == 1) {
                stringBuilder0.append('0');
            }

            stringBuilder0.append(s);
        }

        return stringBuilder0.toString();
    }
}
