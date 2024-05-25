package CTF.ISCC.Puzzle_Game;

public class MoJi {
    public static void main(String[] args) {
        int i;
        for (i = 4999998; i <= 99999999; i++) {
            if (b(String.valueOf(i))) {
                System.out.println(i);
//                break;
            }
        }
    }

    public static boolean b(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (get1(parseInt) && d(parseInt)) {
                int i = parseInt + 11;
                if (!get1(i)) {
                    if (!d(i)) {
                        return true;
                    }
                }
            }

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean get1(int i) {
        String num = Integer.toString(i);
        for (int i2 = 0; i2 < num.length() - 1; i2++) {
            i /= 10;
        }
        return i == 4;
    }

    public static boolean d(int i) {
        int i2 = 2;
        while (i2 < i && i % i2 != 0) {
            i2++;
        }
        return i == i2;
    }

}


