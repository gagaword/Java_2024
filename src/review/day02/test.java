package review.day02;

public class test {
    public static void main(String[] args) {
        int beg = ((int) (System.currentTimeMillis() / 1000)) + 200000;
        System.out.println("beg = " + beg);

        long f18t = System.currentTimeMillis();
        System.out.println("f18t = " + f18t);

        int now = (int) (f18t / 1000);
        System.out.println("now = " + now);

        f18t = 1500 - (f18t % 1000);
        System.out.println("f18t = " + f18t);

        long T = (f18t + 200000 - 200000) * 1000;
        System.out.println("T = " + T);
    }
}
