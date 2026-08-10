package Shapes;

public abstract class Shape {
    public abstract double area();
    public abstract double perimeter();
    public String describe(){
        return  String.format("Shape: %s, Area:%.2f, Perimeter: %.2f ", getClass().getSimpleName(), area(), perimeter() );
    }
}
