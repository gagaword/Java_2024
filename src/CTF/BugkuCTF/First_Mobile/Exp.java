public class Exp {
    private static final byte[] f22b = {23, 22, 26, 26, 25, 25, 25, 26, 27, 28, 30, 30, 29, 30, 32, 32};

    public static void main(String[] args) {
        for (int i = 32; i <= 126; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < f22b.length; j++) {
                byte temp = (byte) (f22b[j] * 2 - j - i);
                // Ensure the decrypted character is within visible ASCII range
                if (temp < 32 || temp > 126) {
                    break;
                }
                sb.append((char) temp);
            }
            String candidateString = sb.toString();
            if (check(candidateString)) {
                System.out.println("Match found: " + candidateString);
                break;
            }
        }
    }

    public static boolean check(String str) {
        byte[] arr_b = str.getBytes();
        byte[] temp = new byte[16];

        for(int i = 0; i < 16; ++i) {
            temp[i] = (byte)((arr_b[i] + f22b[i]) % 61);
        }

        for(int i = 0; i < 16; ++i) {
            temp[i] = (byte)(temp[i] * 2 - i);
        }

        return new String(temp).equals(str);
    }
}
