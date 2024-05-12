package project_two;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 简易日历应用程序： 创建一个简单的控制台或图形界面的日历应用程序，用户可以查看指定月份的日历，或者查询某一天是星期几。
 */
public class Main {
    static final int MAX = 32;

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("星期一");
        stringArrayList.add("星期二");
        stringArrayList.add("星期三");
        stringArrayList.add("星期四");
        stringArrayList.add("星期五");
        stringArrayList.add("星期六");
        stringArrayList.add("星期日");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入查询内容\n1:是查询某个月份的日历\n2:是某个月某天是星期几");
        int options = scanner.nextInt();
        switch (options) {
            case 1:
                System.out.println("请输入月份:");
                int month = scanner.nextInt();
                switch (month) {
                    case 1:
                        int count = 0;
                        for (int i = 0; i < MAX; i++) {
                            arrayList.add(i);
                        }
                        for (int i = 0; i < MAX / 7; i++) {
                            for (String day : stringArrayList) {
                                System.out.print(day + "  ");
                                count += 1;
                                if (count == 7){
                                    System.out.println();
                                    count = 0;
                                }
                            }
                        }
                        count = 0;
                        for (int i = 1; i <= 31; i++) {
                            System.out.printf("%10d", arrayList.get(i));
                            count += 1;
                            if (count == 8) {
                                System.out.println();
                                count = 0;
                            }
                        }
                }
        }
    }
}
