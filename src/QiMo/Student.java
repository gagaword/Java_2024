package QiMo;

public class Student {
    public String name;
    public int age;

    public  Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {

    }

    public void show() {
        System.out.printf(name + age);
    }
}