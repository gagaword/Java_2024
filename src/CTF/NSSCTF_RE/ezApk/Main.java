package CTF.NSSCTF_RE.ezApk;

import java.util.Arrays;

import static CTF.NSSCTF_RE.ezApk.Main.XTEA.decrypt;
import static CTF.NSSCTF_RE.ezApk.Main.XTEA.encrypt;

public class Main {
    public static void main(String[] args) {

        String enc = "3c36eb4981acb0c0fac269aeca5bf9ec";
        for (int i = 0; i < enc.length(); i += 8) {
            int endIndex = Math.min(i + 8, enc.length());
            String chunk = enc.substring(i, endIndex);
            System.out.println("0x" + chunk);
        }

      /*  String nameStr = "ABCEFGHIJKLMNOP";
        int[] nameInter = toIntArray(nameStr);
        System.out.println(Arrays.toString(nameInter));
        String a = toHexString(nameInter);
        System.out.println(a);*/

        int[] cipher = {0x3c36eb49, 0x81acb0c0, 0xfac269ae, 0xca5bf9ec};
        int[] key = {0x12345678, 0x5678ABCD, 0x89ABCDEF, 0xCDEF1234};
        encrypt(cipher, key);
        for (int i = 0; i < 4; i++) {
            System.out.println("0x" + Integer.toHexString(cipher[i]));
        }


        System.out.println();

        int[] v = {0xecd77ea4, 0x42a06b52, 0xfac269ae, 0xca5bf9ec};
        int[] k = {0x12345678, 0x5678ABCD, 0x89ABCDEF, 0xCDEF1234};
        decrypt(v,k);
        for (int i = 0; i < 4; i++) {
            System.out.println(Integer.toHexString(v[i]));
        }
    }

    private static String toHexString(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            sb.append(String.format("%08X", i));
        }
        return sb.toString();
    }

    private static int[] toIntArray(String str) {
        byte[] bytes = str.getBytes();
        int[] iArr = new int[(bytes.length + 3) / 4];
        for (int i = 0; i < bytes.length; i++) {
            int i2 = i / 4;
            iArr[i2] = iArr[i2] | ((bytes[i] & 0xFF) << ((i % 4) * 8));
        }
        return iArr;
    }


    public static class XTEA {
        private static final int DELTA = -1640531527;
        private static final int NUM_ROUNDS = 32;

        public static int[] encrypt(int[] iArr, int[] iArr2) {
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = 0;
            for (int i4 = 0; i4 < 32; i4++) {
                i += ((((i2 << 4) ^ (i2 >>> 5)) + i2) ^ 918) ^ (iArr2[i3 & 3] + i3);
                i3 -= 0x9E3779B9;
                i2 += ((((i << 4) ^ (i >>> 5)) + i) ^ 918) ^ (iArr2[(i3 >>> 11) & 3] + i3);
            }
            iArr[0] = i;
            iArr[1] = i2;
            return iArr;
        }

        public static int[] decrypt(int[] iArr, int[] iArr2) {
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = -1640531527 * 32;
            for (int i4 = 0; i4 < 32; i4++) {
                i2 -= ((((i << 4) ^ (i >>> 5)) + i) ^ 918) ^ (iArr2[(i3 >>> 11) & 3] + i3);
                i -= ((((i2 << 4) ^ (i2 >>> 5)) + i2) ^ 918) ^ (iArr2[i3 & 3] + i3);
                i3 += 1640531527;
            }
            iArr[0] = i;
            iArr[1] = i2;
            return iArr;
        }
    }

}
