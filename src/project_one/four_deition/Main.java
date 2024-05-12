package project_one.four_deition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentFunction studentFunction = new StudentFunction();
        UserInterface userInterface = new UserInterface(studentFunction);

        try {
            int result = Integer.MAX_VALUE;
            while (result != 0){
                userInterface.printHello();
                int options = scanner.nextInt();
                switch (options){
                    case 1:
                        userInterface.addStudent();
                        break;
                    case 2:
                        System.out.println("请输入学号:");
                        int idc= scanner.nextInt();
                        userInterface.editStudent(idc);
                        break;
                    case 3:
                        System.out.print("请输入学号:");
                        int idcc = scanner.nextInt();
                        System.out.print("请输入年龄:");
                        int age = scanner.nextInt();
                        userInterface.delStudent(idcc,age);
                        break;
                    case 4:
                        System.out.println("1:查看所有学生");
                        System.out.println("2:根据学号查找学生");
                        int temp = scanner.nextInt();
                        if (temp == 1){
                            userInterface.viewStudent(1,0);
                        } else if (temp == 2) {
                            System.out.print("输入学号:");
                            int id = scanner.nextInt();
                            userInterface.viewStudent(2, id);
                        }
                        break;
                    case 0:
                        result = 0;
                }
            }
        }catch (InputMismatchException e){
            e.printStackTrace();
        }
    }
}
