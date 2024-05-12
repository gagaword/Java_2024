package review.day01.twoBianry;
import java.util.Scanner;

/*
    十进制转二进制
 */

public class TwoBinary {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
//        System.out.println(number);
//        使用对数方式计算二进制数的位数
        int numBits = (int)(Math.log(number) / Math.log(2) + 1);
        System.out.println("numBits:" + numBits);
        int[] twoBinary = new int[numBits];
        for (int i = 0; i < numBits; i++) {
            int temp = number % 2;
            number /= 2;
            twoBinary[i] = temp;
        }
        System.out.print("二进制数:");
        for (int i = numBits -1; i >= 0; i--) {
            System.out.print(twoBinary[i]);
        }

    }
}
