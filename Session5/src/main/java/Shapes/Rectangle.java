package Shapes;

public class Rectangle extends Shape{
    double height;
    double weight;

    public Rectangle(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double area() {
        return height * weight;
    }

    @Override
    public double perimeter() {
        return 2* height + 2* weight;
    }
}
