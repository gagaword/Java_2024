package QiMo;

public class Undergraduate extends Student {
    public String degree;

    public Undergraduate(String name, int age, String degree) {
        super();
        this.degree = degree;
    }

    public void show(String name, int age, String degree) {
            System.out.println(name+age+degree);
    }
}
