package project_one.secone_edition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class test {
    static ArrayList<Student> arrayList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("--------学生信息管理系统--------");
        int options = 999999;
        while (options != 0){
            printHello();
            try {
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
                        scanner.close();
                        break;
                    default:
                        System.err.println("输入无效");
                }
            }catch (InputMismatchException e){
                System.err.println("输入无效");
//                e.printStackTrace();
                scanner.nextLine();
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
        System.out.println("年龄");
        int age = scanner.nextInt();
        System.out.println("性别");
        String sex = scanner.next();
        System.out.println("学号");
        int studentNumber = scanner.nextInt();
        Student student = new Student(name, age, sex, studentNumber);
        arrayList.add(student);
        System.out.println("********学生信息添加成功********");
    }

    /**
     * 查看学生信息
     */
    public static void viewStudent(){
        if (arrayList.isEmpty()){
            System.out.println("没有学生");
        }
        System.out.println("----------------学生信息----------------");
        System.out.printf("%-10s%-9s%-10s%-8s%n", "姓名", "年龄", "性别", "学号");
        System.out.println("--------------------------------------");
        for (Student student : arrayList) {
            System.out.printf("%-10s%-10d%-10s%-8d%n", student.getName(), student.getAge(), student.getSex(), student.getStudentNumber());
        }
    }

    /**
     * 编辑学生信息
     */
    public static void editStudent(){
        System.out.println("要修改的姓名:");
        String originalName = scanner.next();
        for (Student student1 : arrayList){
            if (student1.getName().equals(originalName)){
                System.out.println("修改后的姓名\n年龄\n性别\n学号\n:");
                String name = scanner.next();
                int age = scanner.nextInt();
                String sex = scanner.next();
                int studentNumber = scanner.nextInt();
                student1.setName(name);
                student1.setSex(sex);
                student1.setAge(age);
                student1.setStudentNumber(studentNumber);
                System.out.println( originalName + "已修改为" + name);
            }else{
                System.err.println("学生信息不存在");
            }
        }
    }

    /**
     * 删除学生信息
     */
    public static void delStudent(){
        System.out.println("删除学生姓名");
        String name = scanner.next();
        for (Student student : arrayList){
            if (student.getName().equals(name)){
                student.setName("");
                student.setStudentNumber(0);
                student.setAge(0);
                student.setSex("");
            }
        }
    }
}
