package Shapes;

public class Triangle extends Shape{

    double a,b,c;

    public Triangle(double a, double b,  double c) {

        this.a = a;
        this.b=b;
        this.c = c;
    }

    public double getB() {
        return b;
    }


    public double getA() {
        return a;
    }

    public double getC() {
        return c;
    }

    @Override
    public double area() {
        return (a * b)/ 2;
    }

    @Override
    public double perimeter() {

        return a+b+c;
    }
}
