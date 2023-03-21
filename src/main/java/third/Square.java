package third;

public class Square extends Figure implements Drawable {
    public Square(double length, double height) {
        super(length, height);
        calculateArea();
    }

    @Override
    public double calculateArea(){
        area = length * height;
        return area;
    }

    @Override
    public void draw(){
        System.out.printf("Квадрат: длина = %s см; высота = %s см, площадь = %s см^2\n", length, height, area);
    }
}
