package review.day02;

import java.util.Scanner;

/*
异常处理：
编写一个程序，接受用户输入的两个整数并进行除法运算，使用异常处理机制捕获除以零的情况。
 */
public class YiChangChuLi {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            double result = division(num1, num2);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        } catch (Exception e) {
            System.out.println("输入有效正数");
        }
    }

    private static double division(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("除数异常");
        } else {
            return (double) num1 / num2;
        }
    }
}
/*
    public class YiChangChuLi {
    public static void main(String[] args) {
        int result = division(2,-0);
        System.out.println(result);

    }
    public static int division(int num1,int num2){
        if (num2 == 0){
            throw new ArithmeticException("除数不能为0");
        }else {
            return num1 / num2;
        }
    }
}

 */

