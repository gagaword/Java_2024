package CTF.ISCC.Puzzle_Game;

public class MoJi {
    public static void main(String[] args) {
        for (int i = 4999999; i < 999999999; i++) {
            if (b(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean b(int str) {
        try {
            if (get1(str) && d(str)) {
                int i = str + 11;
                if (!get1(i)) {
                    return !d(i);
                }
            }

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean d(int i) {
        int i2 = 2;
        while (i2 < i && i % i2 != 0) {
            i2++;
        }
        return i == i2;
    }

    public static boolean get1(int i) {
        String num = Integer.toString(i);
        for (int i2 = 0; i2 < num.length() - 1; i2++) {
            i /= 10;
        }
        return i == 4;
    }

}


