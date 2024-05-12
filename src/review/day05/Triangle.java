package review.day05;
class isTriangle{
    private boolean is = false;
    public String shape;
    public void isTri(int a, int b, int c){
        if (a + b > c){
            System.out.println("可");
            is = true;
            String s = tri(a, b, c);
            System.out.println(s);
        }else{
            System.out.println("不可");
            is = false;
        }
    }
    public String tri(int a, int b, int c){
        if (is){
            if ((a * a + b * b < c * c) || (b * b + c * c < a * a) || (c * c + a * a < b * b)){
                shape = "钝角";
            } else if ((a * a + b * b == c * c) || (b * b + c * c == a * a) || (c * c + a * a == b * b)) {
                shape = "直角";
            }else if ((a * a + b * b > c * c) && (a * a + c * c > b * b) && (b * b + c * c > a * a)) {
                shape= "锐角";
            }
        }
        return shape;
    }
}
public class Triangle {
    public static void main(String[] args) {
        isTriangle isTriangle = new isTriangle();
        isTriangle.isTri(3,4,5);
    }
}
