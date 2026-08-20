package org.example.Generics;

public class GenericMethods {
    //generic method
    public static <T> void printArray(T[] array){
        for ( T item: array){
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        // array of strings
        String [] names= {"Nice", "Umutoni"};
        //array of integers
        Integer[] numbers = {1,2,3};
        // call generic methods with both arrays
        printArray(numbers);
        printArray(names);

    }
}
