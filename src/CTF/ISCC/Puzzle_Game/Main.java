package CTF.ISCC.Puzzle_Game;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        int range = 99999999 / numberOfThreads;

        for (int t = 0; t < numberOfThreads; t++) {
            final int start = t * range;
            final int end = (t + 1) * range;
            executor.execute(() -> {
                for (int i = start; i < end; i++) {
                    if (b(i)) {
                        System.out.println(i);
                    }
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean b(int parseInt) {
        if (get1(parseInt) && d(parseInt)) {
            int i = parseInt + 11;
            if (!get1(i) && !d(i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean get1(int i) {
        while (i >= 10) {
            i /= 10;
        }
        return i == 4;
    }

    public static boolean d(int i) {
        if (i <= 1) return false;
        if (i == 2) return true;
        if (i % 2 == 0) return false;
        for (int j = 3; j <= Math.sqrt(i); j += 2) {
            if (i % j == 0) return false;
        }
        return true;
    }
}
