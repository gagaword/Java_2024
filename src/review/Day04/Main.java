package review.Day04;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> student = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int age = scanner.nextInt();
        student.put(name,age);

        System.out.println(name + ":" + student.get(name));
    }
}
