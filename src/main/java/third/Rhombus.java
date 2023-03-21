package third;

public class Rhombus extends Figure{
    double base;

    public Rhombus(double length, double height, double base) {
        super(length, height);
        this.base = base; //длина основания ромба
    }

    @Override
    public double calculateArea(){
        area = base * height;
        return area;
    }
}
