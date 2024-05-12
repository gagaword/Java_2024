package project_one.there_edition;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentManager {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    /**
     * 添加学生信息提示信息
     */
    public  Student getStudentInfo() {
        System.out.println("请输入姓名:");
        String name = scanner.next();
        System.out.println("请输入年龄:");
        int age = scanner.nextInt();
        System.out.println("请输入性别:");
        String sex = scanner.next();
        System.out.println("请输入学号:");
        int studentNumber = scanner.nextInt();

        return new Student(name, age, sex, studentNumber);
    }

    /**
     * 添加学生信息
     * @param student 学生信息
     */
    public void addStudent(Student student){
        students.add(student);
        System.out.println("********学生信息添加成功********");
    }

    /**
     * 查看学生信息
     */
    public void viewStudent(){
        if (students.isEmpty()){
            System.out.println("没有学生");
            return;
        }
        System.out.println("---------------学生信息---------------");
        System.out.printf("%-10s%-8s%-10s%-7s%n", "姓名", "年龄", "性别", "学号");
        System.out.println("------------------------------------");
        for (Student student : students) {
            System.out.printf("%-10s%-10d%-10s%-8d%n", student.getName(), student.getAge(), student.getSex(), student.getStudentNumber());
        }
    }

    /**
     * 删除学生信息提示
     */
    public static String[] editStudentInfo(){
        System.out.println("请输入要修改的姓名:");
        String originalName = scanner.next();
        System.out.println("请输入修改后的姓名:");
        String newName = scanner.next();
        return new String[]{originalName, newName};
    }



    /**
     * 修改学生信息
     * @param originalName 原始姓名
     * @param newName 新姓名
     */
    public void editStudent(String originalName, String newName) {
        for (Student student : students) {
            if (student.getName().equals(originalName)) {
                student.setName(newName);
                System.out.println("********修改成功********");
                return;
            }
        }
        System.out.println("未找到学生信息");
    }

    /**
     * 删除学生信息
     * @param delName 要删除学生姓名
     */
    public void delStudent(String delName){
        for (Student student : students){
            if (student.getName().equals(delName)){
                students.remove(student);
                System.out.println("学生信息删除成功");
                return;
            }
        }
        System.out.println("未找到学生信息");
    }
}
