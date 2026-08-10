package org.example;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println("FizzBuzz");
        System.out.println("---------");

    for(int i=1; i<=100; i++) {
        if(i%3==0 && i%5==0){
            System.out.println("FizzBuzz");
        }
        else if(i%3==0){
            System.out.println("Fizz");
        }
        else if(i%5==0){
            System.out.println("Buzz");
        }else{
            System.out.println(i);
        }
    }
        System.out.println();
        System.out.println("Right-angled triangle");
        System.out.println("---------------------");
        printTriangle();

        System.out.println();
        System.out.println("Hollow Diamond");
        System.out.println("---------------");
        printDiamond(5);
            }

         public static void printTriangle(){
            for (int row = 1; row <= 8; row++) {

        for (int column = 1; column <= row; column++) {
            System.out.print("*");
        }
        System.out.println();
        }

    }
    public static void printDiamond(int size){
        for (int i = 1; i <= size; i++) {

            for (int j = i; j < size; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {

                if (j == 1 || j == (2 * i - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }

            System.out.println();

        }


        for (int i = size - 1; i >= 1; i--) {


            for (int j = size; j > i; j--) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {

                if (j == 1 || j == (2 * i - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }

            System.out.println();

        }
    }
}
