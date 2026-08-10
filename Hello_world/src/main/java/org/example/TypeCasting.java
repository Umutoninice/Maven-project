package org.example;

public class TypeCasting {
    public static void main(String[] args) {
        int number=30;
        double price=2000.35;
        int wholeNumber= (int) price;
        System.out.println("Original int value:" + number);
        System.out.println("After assigning int to double:" + (double) number);
        System.out.println(" ");
        System.out.println("Original double value:" +price);
        System.out.println("After casting double to int:" + wholeNumber);

    }
}
