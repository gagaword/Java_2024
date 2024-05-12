package review.day01.QICheLei.P1;

public class CheZhu {
    public static void main(String[] args) {
        QIChe qiChe = new QIChe();
        qiChe.setPinPai("奥迪");
        qiChe.setXingHao("A8");
        System.out.println("qiChe.PinPai = " + qiChe.PinPai);
        System.out.println("qiChe.getXingHao() = " + qiChe.getXingHao());

        DianDongQiChe dianDongQiChe = new DianDongQiChe();
        dianDongQiChe.setPinPai("特斯拉");
        dianDongQiChe.setXingHao("Model");
        dianDongQiChe.setColor("白色");
        System.out.println("dianDongQiChe.getPinPai() = " + dianDongQiChe.getPinPai());
        System.out.println("dianDongQiChe.getXingHao() = " + dianDongQiChe.getXingHao());
        System.out.println("dianDongQiChe.getColor() = " + dianDongQiChe.getColor());
    }
}

