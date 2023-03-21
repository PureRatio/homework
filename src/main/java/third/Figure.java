package third;

public abstract class Figure {
    protected double length;
    protected double height;
    protected double area;

    public Figure(double length, double height){
        this.height = height;
        this.length = length;
    }

    public abstract double calculateArea();

}
