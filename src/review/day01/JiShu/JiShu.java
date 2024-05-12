package review.day01.JiShu;

/*
   打印1-10的奇数
 */
public class JiShu {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0){
                System.out.println(i);
            }
        }
    }
}
