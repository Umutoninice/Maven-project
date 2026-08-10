package Shapes;

public class Circle extends Shape{
    double radius;

    public Circle(double radius) {
        this.radius=radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return Math.PI *radius *2;
    }

    public double getRadius() {
        return radius;
    }
}
