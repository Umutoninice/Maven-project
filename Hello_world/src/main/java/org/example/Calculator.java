package org.example;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number: ");
         double num1= scanner.nextDouble();
        System.out.println("Enter an operator(+,-,*,/):");
        char operator =scanner.next().charAt(0);
        System.out.println("Enter the second number: ");
        double num2=scanner.nextDouble();
        //calculations
        if(operator == '+'){
            System.out.println("Result: " + (num1 + num2));
        }else if(operator== '-'){
            System.out.println("Result: " + (num1 - num2));
        }else if(operator == '*'){
            System.out.println("Result: " + (num1 * num2));
        }else if (operator=='/'){
            if (num2 ==0){
                System.out.println("Error: Division by zero is impossible");
            }else{
                System.out.println("Result: " + (num1/num2));
            }
        }else{
            System.out.println("Error: Invalid operator. Please use +,-,*,or / .");
        }
        scanner.close();
    }
}
