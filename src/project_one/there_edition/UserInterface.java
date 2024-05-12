package project_one.there_edition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private static  final Scanner scanner = new Scanner(System.in);
    private final StudentManager studentManager;

    public UserInterface(StudentManager studentManager){
        this.studentManager = studentManager;
    }

    public int getUserInput(){
        System.out.println("1:添加学生信息\n2:查看学生\n3:编辑学生信息\n4:删除学生信息\n0:退出");
        int result ;
        try {
            result = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("输入无效");
            result = -1;
        }
        return result;
    }

    public void addStudent() {
        // 添加学生
        Student student = studentManager.getStudentInfo();
        studentManager.addStudent(student);
    }

    public  void viewStudent() {
        // 查看学生信息
        studentManager.viewStudent();
    }

    public  void editStudent()   {
        // 编辑学生信息
        String[] names = StudentManager.editStudentInfo();
        studentManager.editStudent(names[0],names[1]);
    }

    public  void delStudent() {
        // 删除学生信息
        System.out.println("要删除学生姓名");
        viewStudent();
        String delName = scanner.next();
        studentManager.delStudent(delName);
    }

    public void closeScanner() {
        scanner.close();
    }
}
