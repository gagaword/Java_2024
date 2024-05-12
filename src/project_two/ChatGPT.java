package project_two;

import java.util.Scanner;


/**
 * 简易日历应用程序： 创建一个简单的控制台或图形界面的日历应用程序，用户可以查看指定月份的日历，或者查询某一天是星期几。
 */
public class ChatGPT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入查询内容\n1:查询某个月份的日历\n2:某个月某天是星期几");
        int options = scanner.nextInt();
        switch (options) {
            case 1:
                int[] ko = printHello(1);
                /*
                for (int i : ko){
                    System.out.println("i = " + i);
                }
                 */
                printMonthDays(ko[0], ko[1]);
                break;
            case 2:
                int[] ok = printHello(2);
                String dayWeek = printDayOfWeek(ok[0], ok[1], ok[2]);
                System.out.println("dayWeek = " + dayWeek);
                break;
            default:
                System.out.println("无效选项");
        }
    }


    public  static  int[] printHello(int isNum){
        switch (isNum){
            case 1:
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入年份:");
                int year = scanner.nextInt();
                System.out.println("请输入月份:");
                int month = scanner.nextInt();
                return new int[]{year, month};
            case 2:
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入年份:");
                int y = sc.nextInt();
                System.out.println("请输入月份:");
                int m = sc.nextInt();
                System.out.println("请输入日期:");
                int day = sc.nextInt();
                return new int[]{y,m,day};
        }
        return new int[]{1};
    }

    public static void printMonthDays(int year, int month) {
        // 计算每个月份的天数
        int daysInMonth = getMonthDays(year,month);
        // 计算该月份第一天是星期几
//        int firstDayOfWeek = getFirstDayOfWeek(month);
        int firstDayOfWeek = getDayInWeek(year, month, 1);
//        System.out.println("firstDayOfWeek = " + firstDayOfWeek);
        // 输出日历
        System.out.println("六\t日\t一\t二\t三\t四\t五");
        for (int i = 0; i < firstDayOfWeek; i++) {
            System.out.print("\t");
        }
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.print(day + "\t");
            if ((firstDayOfWeek + day) % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static String printDayOfWeek(int year, int month, int day) {
        int dayOfWeek = getDayInWeek(year, month, day);
//        System.out.println("dayOfWeek = " + dayOfWeek);
        switch (dayOfWeek) {
            case 0: return "星期六";
            case 1: return "周日";
            case 2: return "星期一";
            case 3: return "星期二";
            case 4: return "星期三";
            case 5: return "星期四";
            case 6: return "星期五";
            default: return "无效日";
        }
    }

    public static int getDayInWeek(int year, int month, int day) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        int dayOfWeek = (day + ((13 * (month + 1)) / 5) + k + (k / 4) + (j / 4) - 2 * j) % 7;
        if (dayOfWeek < 0) {
            dayOfWeek += 7;
        }
        return dayOfWeek;
    }

    public static int getMonthDays(int year, int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0 )|| (year % 400 == 0)){
                        return 29;
                }else{
                    return 30;
                }
            default:
                throw new IllegalArgumentException("无效月份");
        }
    }
}
