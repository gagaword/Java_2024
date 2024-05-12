package CTF.ISCC.Puzzle_Game;

public class MyJin{
    private static final char[] aAbcdefghijklmn = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    public  static void main(String[] args){
        StringBuilder result = new StringBuilder();
        int v3, v5, v6, v7, v8;
        char v4;
        int v2 = 0;
        long v1 = 0;
        do {
            v3 = v2 + 5 * (int)v1 - 62 * (((v2 + 5 * (int)v1 + (int)((-2078209981L * (v2 + 5 * (int)v1 + 7)) >> 32) + 7) >> 31) + ((v2 + 5 * (int)v1 + (int)((-2078209981L * (v2 + 5 * (int)v1 + 7)) >> 32) + 7) >> 5)) + 7;
            v4 = aAbcdefghijklmn[v3];
            v5 = v2 + 10;
            v6 = 100;
            do {
                v3 = (v5 + v3) % 62;
                v4 = aAbcdefghijklmn[(v3 + v2 + v4) % 62];
                --v6;
            } while (v6 > 0);
            v7 = 100;
            do {
                v3 = (v5 + v3) % 62;
                v4 = aAbcdefghijklmn[(v3 + v2 + v4) % 62];
                --v7;
            } while (v7 > 0);
            v8 = 100;
            do {
                v3 = (v5 + v3) % 62;
                v4 = aAbcdefghijklmn[(v3 + v2 + v4) % 62];
                --v8;
            } while (v8 > 0);
            result.append(v4);
            if (v2-- == 0) {
                v2 = 15;
            }
            ++v1;
        } while (v1 != 15);
        System.out.println(result);
    }
}

