package CTF.NSSCTF.findit;

public class enc {
    public static void main(String[] args) {
        final char[] a = {'T', 'h', 'i', 's', 'I', 's', 'T', 'h', 'e', 'F', 'l', 'a', 'g', 'H', 'o', 'm', 'e'};
        final char[] b = {'p', 'v', 'k', 'q', '{', 'm', '1', '6', '4', '6', '7', '5', '2', '6', '2', '0', '3', '3', 'l', '4', 'm', '4', '9', 'l', 'n', 'p', '7', 'p', '9', 'm', 'n', 'k', '2', '8', 'k', '7', '5', '}'};
        char[] x = new char[17];
        char[] y = new char[38];
        for (int i = 0; i < 17; i++) {
            if (a[i] < 'I' || a[i] < 'i' && a[i] >= 'a') {
                x[i] = (char) (a[i] + 18);
            } else if (a[i] <= 'Z' || a[i] >= 'a') {
                x[i] = (char) (a[i] - '\b');
            } else {
                x[i] = a[i];
            }
        }
        String m = String.valueOf(x);
        System.out.println(b.length);
        for (int i = 0; i < 38; i++) {
            if ((b[i] >= 'A' && b[i] <= 'Z') || (b[i] >= 'a' && b[i] <= 'z')) {
                y[i] = (char) (b[i] + 16);
                if ((y[i] > 'Z' && y[i] < 'a') || y[i] >= 'z') {
                    y[i] = (char) (y[i] - 26);
                }
            } else {
                y[i] = b[i];
            }
        }
        String n = String.valueOf(y);
        System.out.println("n = " + n);
    }
}
