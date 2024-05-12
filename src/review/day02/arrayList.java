package review.day02;

import java.util.ArrayList;
import java.util.Scanner;
/*
集合框架：
使用ArrayList实现一个简单的待办事项列表，允许添加、删除和列举任务。
基础知识:
      ArrayList<String> sites = new ArrayList<>();
        sites.add("AAA");
        sites.add("BBB");
        sites.add("CCC");
//        获取列表数据
        System.out.println("sites[0] = " + sites.get(0));
//        修改列表数据
        sites.set(2,"LLL");
        System.out.println("sites[2] = " + sites.get(2));
//        删除数据
        sites.remove(1);
//        迭代数据
        for (String site : sites) {
            System.out.println(site);
        }
 */

public class arrayList {
    //    为打印字体设置颜色
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    //    遍历集合
    private static void puts(ArrayList<String> a) {
        for (int j = 0; j < a.size(); j++) {
            System.out.println(ANSI_RED + (j + 1) + "." + a.get(j) + ANSI_RESET);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> agency = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1:添加数据");
            System.out.println("2:修改数据");
            System.out.println("3:删除数据");
            System.out.println("4:列举待办事项");
            System.out.println("5:退出");

            if (scanner.hasNextInt()) {
                int a = scanner.nextInt();
                scanner.nextLine();
                switch (a) {
                    case 1:
                        System.out.println("输入要添加的数据:");
                        String Add = scanner.nextLine();
                        agency.add(Add);
                        System.out.println("已添加");
                        break;
                    case 2:
//                    for (int i = 0; i < agency.size(); i++) {
//                        System.out.println((i + 1) + "." + agency.get(i));
//                    }
                        puts(agency);
                        System.out.println("输入要修改数据的序号与修改值:");
                        int setIndex = scanner.nextInt();
                        scanner.nextLine();
                        String result = scanner.nextLine();
                        System.out.print(agency.get(setIndex - 1));
                        agency.set(setIndex - 1, result);
                        System.out.println("已修改为:" + result);
                        break;
                    case 3:
//                    for (int i = 0; i < agency.size(); i++) {
//                        System.out.println((i + 1) + "." + agency.get(i));
//                    }
                        puts(agency);
                        System.out.println("输入删除序号:");
                        int del_index = scanner.nextInt();
                        scanner.nextLine();
                        if (del_index - 1 >= 0 && del_index - 1 < agency.size()) {
                            String removeTask = agency.remove(del_index - 1);
                            System.out.println("已删除:" + removeTask);
                        } else {
                            System.out.println("超出索引值");
                        }
                        break;
                    case 4:
                        System.out.println("代办事项:");
//                    for (int j = 0; j < agency.size(); j++) {
//                        System.out.println(ANSI_RED + (j + 1) + "." + agency.get(j) + ANSI_RESET);
//                    }
                        puts(agency);
                        break;
                    case 5:
                        System.out.println("程序已退出");
//                    System.exit(0);
                        isRunning = false;
                        break;
                    default:
                        System.out.println("输入有效数字");
                }
            } else {
                System.out.println("输入有效数字");
                scanner.nextLine(); // 清除输入缓冲区
            }
        }

    }
}

        /*
        //        添加
        System.out.println("输入要添加的数据:");
        String Add = scanner.nextLine();
        agency.add(Add);
        for (String c:agency){
            System.out.println("已添加:" + c);
        }

//         修改
        System.out.println("输入要修改数据的下标与修改值:");
        String Set = scanner.nextLine();
        int setIndex = Integer.parseInt(Set);
        String result = scanner.nextLine();
        agency.set(setIndex,result);
        for (String c:agency){
            System.out.println("已修改:" + c);
        }

//        删除
        System.out.println("输入要删除值得下标:");
        String del = scanner.nextLine(); //这里的del是String类型，无法作为remove的下标值
//        System.out.println("del = " + del + 1); //01
        int i = Integer.parseInt(del); // Integer.parseInt,把字符串正数转为实际的整数值。可以作为remove的下标
        agency.remove(i);
        for (String c:agency){
            System.out.println(c);
        }

         */

