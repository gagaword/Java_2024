package CTF.NSSCTF.Reverse;

public class Exp {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int[] key = {
                180, 136, 137, 147, 191, 137, 147, 191, 148, 136,
                133, 191, 134, 140, 129, 135, 191, 65
        };
        for (int i = 0; i < key.length; i++) {
            int result = key[i] - 64 ^ 0x20;
            sb.append((char) result);
        }

        String resultString = sb.toString();
        System.out.println(resultString);
    }
}

