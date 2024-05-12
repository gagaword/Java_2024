package review.day02;

/*
多线程：
创建两个线程，一个打印奇数，另一个打印偶数，确保线程同步。
 */
public class thread {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread oddThread = new Thread(new OddPrinter(printer));
        Thread evenThread = new Thread(new EvenPrinter(printer));

        oddThread.start();
        evenThread.start();
    }
}

class Printer {
    private boolean isOddTurn = true;

    // 打印奇数
    public synchronized void printOdd(int number) {
        while (!isOddTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Odd: " + number);
        isOddTurn = false;
        notify();
    }

    // 打印偶数
    public synchronized void printEven(int number) {
        while (isOddTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Even: " + number);
        isOddTurn = true;
        notify();
    }
}

class OddPrinter implements Runnable {
    private final Printer printer;

    public OddPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            printer.printOdd(i);
        }
    }
}

class EvenPrinter implements Runnable {
    private final Printer printer;

    public EvenPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            printer.printEven(i);
        }
    }
}

/*
    public class thread {
    public static void main(String[] args) {
        Thread thread1 = new ThreadDemo1();
        Thread thread2 = new ThreadDemo2();
        thread1.start();
        thread2.start();
    }
}

class ThreadDemo1 extends Thread {
    @Override
    public void run() {
        synchronized (System.out) {
            System.out.println("我在打印偶数");
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}

class ThreadDemo2 extends Thread {
    @Override
    public void run() {
        synchronized (System.out) {
            System.out.println("我再打印奇数");

            for (int i = 0; i < 100; i++) {
                if (i % 2 != 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
 */

