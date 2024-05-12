package CTF.JiKe.Ezandroid;
import java.util.Arrays;

public class Exp {
    public static int[] convertBytesToInts(byte[] byteArray) {
        int length = byteArray.length / 4;
        int[] iArr = new int[length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            iArr[i] = ((byteArray[index] & 0xFF) << 24) |
                    ((byteArray[index + 1] & 0xFF) << 16) |
                    ((byteArray[index + 2] & 0xFF) << 8) |
                    (byteArray[index + 3] & 0xFF);
            index += 4;
        }
        return iArr;
    }

    public static void main(String[] args) {
        byte[] byteArrayExtra = {-91, -8, -110, -55, -49, 75, 115, 13, -76,
                -113, 102, 80};
        int[] iArr;

        iArr = convertBytesToInts(byteArrayExtra);
        System.out.println(Arrays.toString(iArr));

        int[] v = new int[3];
        int[] key = {2023708229, -158607964, 0x81963FFA, 0x458FAC58};
        int sum = -1914802624;
        int delta = 1640531527;
        v[1] = iArr[2];
        v[2] = iArr[1];

//        第二个TEA
        for (int i = 0; i < 32; i++) {
            v[1] -= (((v[2] << 4) + key[2]) ^ (v[2] + sum)) ^ ((v[2] >> 5) + key[3]);
            v[2] -= (((v[1] << 4) + key[0]) ^ (v[1] + sum)) ^ ((v[1] >> 5) + key[1]);
            sum += delta;
        }
        v[0] = iArr[0];
//        第一个TEA
        for (int i = 0; i < 32; i++) {
            v[1] -= (((v[0] << 4) + key[2]) ^ (v[0] + sum)) ^ ((v[0] >> 5) + key[3]);
            v[0] -= (((v[1] << 4) + key[0]) ^ (v[1] + sum)) ^ ((v[1] >> 5) + key[1]);
            sum += delta;
        }

//        替换位置
        byte[] bArr = new byte[3 << 2];
        int i20 = 0;
        for (int i21 = 0; i21 < 3; i21++) {
            bArr[i20 + 3] = (byte) (v[i21] & 255);
            bArr[i20 + 2] = (byte) ((v[i21] >> 8) & 255);
            bArr[i20 + 1] = (byte) ((v[i21] >> 16) & 255);
            bArr[i20] = (byte) ((v[i21] >> 24) & 255);
            i20 += 4;
        }

        for (int i22 = 0; i22 < 12; i22++) {
            int num = (int) bArr[i22];
            if (num < 0) {
                num += 256;
            }
//            System.out.println(num);
            System.out.print((char) num);
        }
        System.out.println();
        int[] iArr1 = {-107, -106, -95, -115, -119, 127, 26, 121, -62, -20, 86, 9};
        int[] enc1 = {-91, -8, -110, -55, -49, 75, 115, 13, -76, -113, 102, 80};

        for (int i = 0; i < 12; i++) {
            iArr1[i] ^= enc1[i];
            System.out.print((char) iArr1[i]);
        }
        System.out.println();

//      奇偶性归位
        String ouShu = "T0Vt33Tn0itr";
        String jiShu = "0n3DF4itvc0Y";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ouShu.length(); i++) {
            sb.append(ouShu.charAt(i));
            sb.append(jiShu.charAt(i));
        }
        System.out.println("result = " + sb);
    }
}
