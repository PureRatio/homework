package third;

public class Triangle extends Figure implements Drawable {
    public Triangle(double length, double height) {
        super(length, height);
        calculateArea();
    }

    @Override
    public double calculateArea(){
        area = 0.5 * length * height;
        return area;
    }

    @Override
    public void draw(){
        System.out.printf("Треугольник: длина = %s см; высота = %s см, площадь = %s см^2\n", length, height, area);
    }
}
