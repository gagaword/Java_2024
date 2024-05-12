package project_one.first_edition;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    static ArrayList<String> arrayList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("--------学生信息管理系统--------");
        int options = 999999;
        while (options != 0){
            printHello();
            options = scanner.nextInt();
            switch(options){
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    delStudent();
                    break;
                case 0:
                    System.out.println("Good Bye");
                    break;
                default:
                    System.err.println("输入无效");
            }
        }

    }

    /**
     * 打印欢迎信息
     */
    public static void printHello(){
        System.out.println("1:添加学生信息\n2:查看学生\n3:编辑学生信息\n4:删除学生信息\n0:退出");
    }
    /**
     * 添加学生信息
     */
    public static void addStudent(){
        System.out.println("姓名");
        String name = scanner.next();
        arrayList.add(name);
        scanner.close();
    }

    /**
     * 查看学生信息
     */
    public static void viewStudent(){
        System.out.println(arrayList);
    }

    /**
     * 编辑学生信息
     */
    public static void editStudent(){
        System.out.println("要修改姓名");
        String originalName = scanner.next();
        int index = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(originalName)){
                index = i;
            }
        }
        System.out.println("修改值");
        String name = scanner.next();
        arrayList.set(index,name);
        scanner.close();
    }

    /**
     * 删除学生信息
     */
    public static void delStudent(){
        System.out.println("删除学生姓名");
        String name = scanner.next();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(name)){
                arrayList.remove(i);
                System.out.println(name + "已删除");
            }else {
                System.err.println(name + "不存在");
            }
        }
        scanner.close();
    }
}
