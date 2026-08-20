package org.example.Generics;

public class Main {
    public static void main(String[] args) {
        // creating a box to hold a String
        Box<String> stringBox= new Box<>();
        stringBox.set("Hello");
        System.out.println("Value: " + stringBox.get());

        // creating a box to hold an Integer
        Box<Integer> intBox=new Box<>();
        intBox.set(30);
        System.out.println("Value: " + intBox.get());
    }
}
