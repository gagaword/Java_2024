package project_one.secone_edition;

public class Student {
    private String name;
    private int age;
    private String sex;
    private int studentNumber;

//  构造函数
    public Student(String name, int age, String sex, int studentNumber) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
}