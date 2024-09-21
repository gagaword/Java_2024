package QiMo;

public class Rectangle {
    public int width;
    public int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int Z() {
        return (width + height) * 2;
    }
    public int M() {
        return width * height;
    }
}

