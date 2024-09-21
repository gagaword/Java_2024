package QiMo;

import java.util.Arrays;
import java.util.Scanner;

public class short_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] score = new int[10];
        for (int i = 0; i < 10; i++) {
            score[i] = sc.nextInt();
        }
        Arrays.sort(score);
        for (int i = 0; i < 10; i++) {
            System.out.print(score[i] + " ");
        }
    }
}
