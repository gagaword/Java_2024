package review.FeiBo;

import java.util.Scanner;

/**
 * 输入一个正整数,输出以它为截止的斐波那契数列.
 */
public class FeiBo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入正整数");
        int i = scanner.nextInt();
        for (int j = 0; j < i; j++) {
            System.out.print(FeiBoShu(j + 1) + "  ");
        }
        scanner.close();
    }

    private static int FeiBoShu(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        return FeiBoShu(number - 1) + FeiBoShu(number - 2);
    }
}


