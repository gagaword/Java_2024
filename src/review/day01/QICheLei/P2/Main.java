package review.day01.QICheLei.P2;

class Car{
//    属性
    String Brand;
    String Model;

//    构造方法
    public Car(String brand,String model){
        this.Brand = brand;
        this.Model = model;
    }
//    方法
    public void start(){
        System.out.println(Brand + "启动");
    }
    public void end(){
        System.out.println(Brand + "成为了耐摔王" );
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }
}
class ElectricCar extends Car{
    int DianChiRongLiang;
    public ElectricCar(String brand, String model, int dianChiRongLiang){
//       调用父类的构造方法
        super(brand,model);
        this.DianChiRongLiang = dianChiRongLiang;
    }
//    新方法
    public void charge(){
        System.out.println("充电中...");
    }

    public int getDianChiRongLiang() {
        return DianChiRongLiang;
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("牢大","特种汽车改装直升机");

//      调用汽车方法
        car.start();
        car.end();

//      输出汽车信息
        System.out.println("品跑:" + car.getBrand());
        System.out.println("型号:" + car.getModel());

        System.out.println();

//      创建电动汽车对象
        ElectricCar electricCar = new ElectricCar("特斯拉","Model 3",1000);

//       调用电动汽车
        electricCar.start();
        electricCar.end();
        electricCar.charge();

//        输出汽车信息
        System.out.println("品牌:" + electricCar.getBrand());
        System.out.println("型号:" + electricCar.getModel());
        System.out.println("电池容量:" + electricCar.getDianChiRongLiang());
    }
}
