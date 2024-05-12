package project_one.ChatGPT;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManagementSystem {
    private Map<String, Student> students;

    public StudentManagementSystem() {
        this.students = new HashMap<>();
    }

    public void addStudent(String id, Student student) {
        students.put(id, student);
        System.out.println("学生信息添加成功！");
    }

    public void removeStudent(String id) {
        if (students.containsKey(id)) {
            students.remove(id);
            System.out.println("学生信息删除成功！");
        } else {
            System.out.println("未找到该学生信息！");
        }
    }

    public void editStudent(String id, String name, int age, String grade) {
        if (students.containsKey(id)) {
            Student student = students.get(id);
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            System.out.println("学生信息编辑成功！");
        } else {
            System.out.println("未找到该学生信息！");
        }
    }

    public Student findStudentById(String id) {
        return students.get(id);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("学生信息管理系统");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 编辑学生信息");
            System.out.println("4. 查询学生信息");
            System.out.println("5. 退出");

            System.out.print("请选择操作：");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("输入学生ID：");
                    String id = scanner.nextLine();
                    System.out.print("输入学生姓名：");
                    String name = scanner.nextLine();
                    System.out.print("输入学生年龄：");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("输入学生年级：");
                    String grade = scanner.nextLine();
                    system.addStudent(id, new Student(name, age, grade));
                    break;
                case 2:
                    System.out.print("输入要删除的学生ID：");
                    String removeId = scanner.nextLine();
                    system.removeStudent(removeId);
                    break;
                case 3:
                    System.out.print("输入要编辑的学生ID：");
                    String editId = scanner.nextLine();
                    System.out.print("输入新的学生姓名：");
                    String newName = scanner.nextLine();
                    System.out.print("输入新的学生年龄：");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("输入新的学生年级：");
                    String newGrade = scanner.nextLine();
                    system.editStudent(editId, newName, newAge, newGrade);
                    break;
                case 4:
                    System.out.print("输入要查询的学生ID：");
                    String findId = scanner.nextLine();
                    Student student = system.findStudentById(findId);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("未找到该学生信息！");
                    }
                    break;
                case 5:
                    System.out.println("感谢使用学生信息管理系统，再见！");
                    System.exit(0);
                default:
                    System.out.println("无效的操作，请重新输入！");
            }
        }
    }
}
