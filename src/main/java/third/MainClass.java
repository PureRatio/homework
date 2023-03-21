package third;

public class MainClass {
    public static void main(String[] args){
        Drawable triangle = new Triangle(4, 5);
        Drawable square = new Square(5, 5);
        triangle.draw();
        square.draw();
    }
}
