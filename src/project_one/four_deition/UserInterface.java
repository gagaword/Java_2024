package project_one.four_deition;

public class UserInterface {
    private final StudentFunction studentFunction;

    public UserInterface(StudentFunction studentFunction) {
        this.studentFunction = studentFunction;
    }

    public void printHello() {
        System.out.println("*********学生管理系统*********");
        System.out.println("1:添加学生");
        System.out.println("2:编辑学生");
        System.out.println("3:删除学生");
        System.out.println("4:查找学生");
    }

    public void addStudent() {
        studentFunction.addStudent();
        System.out.println("********学生添加成功********");
    }


    public void editStudent(int id){
        studentFunction.editStudent(id);
    }

    public void delStudent(int id, int age){
        studentFunction.delStudent(id, age);
    }
    public void viewStudent(int options, int id) {
        if (options == 1) {
            studentFunction.viewStudent(1, 0);
        } else if (options == 2) {
            studentFunction.viewStudent(2, id);
        }
    }
}
