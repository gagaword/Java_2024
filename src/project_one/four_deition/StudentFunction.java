package project_one.four_deition;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class StudentFunction {
    HashMap<Integer, String> student = new HashMap<>();
    Map<Integer, String> stringMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void addStudent(){
        try {
            System.out.print("姓名:");
            String name = scanner.next();
            System.out.print("学号:");
            int id = scanner.nextInt();
            student.put(id,name);

            System.out.print("年龄:");
            int age = scanner.nextInt();
            System.out.print("性别:");
            String sex = scanner.next();
            stringMap.put(age, sex);
        }catch (InputMismatchException e){
            System.err.println("年龄与学号只能是数字");
        }
    }

    public void editStudent(int idc){
        for (int id : student.keySet()){
            if (id == idc){
                System.out.print("输入新的姓名:");
                String newName = scanner.next();
                student.put(idc, newName);
                System.out.println("修改成功！");
            }
        }

    }

    public void delStudent(int idc, int age){
        for (int id : student.keySet()){
            if (id == idc){
                student.remove(id);
            }
        }
        for (Map.Entry<Integer, String> entry : stringMap.entrySet()){
            int idccc = entry.getKey();
            if (age == idccc){
                stringMap.remove(age);
            }
        }
    }
    public void viewStudent(int options, int idc){
        boolean isNULL = student.isEmpty();
        if (!isNULL){
            if (options == 1){

                for (int id : student.keySet()){
                    System.out.print("学号:" + id + "--" + "姓名:" + student.get(id) + "--");
                }

                for (Map.Entry<Integer,String> entry: stringMap.entrySet()){
                    int age = entry.getKey();
                    String sex = entry.getValue();
                    System.out.print("年龄:" + age + "--" + "性别:" + sex + "\n");
                }

            }else if (options == 2) {
                for (int id : student.keySet()) {
                    if (id == idc) {
                        System.out.print("学号:" + id + "--" + "姓名:" + student.get(id) + "--");
                        for (Map.Entry<Integer, String> entry : stringMap.entrySet()) {
                            int age = entry.getKey();
                            String sex = entry.getValue();
                            System.out.print("年龄:" + age + "--" + "性别:" + sex + "\n");
                            break;
                        }
                    }else{
                        System.err.println("没有此学生");
                    }
                }
            }
        }else {
            System.out.println("无数据");
        }
    }
}
