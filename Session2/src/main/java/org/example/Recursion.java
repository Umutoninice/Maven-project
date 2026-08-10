package org.example;
// Iterative factorial
public class Recursion {
    public static long factorialIterative(int n){
        long result=1;
        for (int i=1; i<= n;i++){
           result *=i;
        }
        return result;
    }

    // Recursive factorial
    public static long factorialRecursive(int n){
        if (n == 0 || n==1){
            return 1;
        }
        return n * factorialRecursive(n-1);
    }
    //Iterative fibonacci
    public static long fibonacciIterative(int n){
        if (n ==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        long first=0;
        long second=1;

        for (int i=2;i <= n; i++){
            long next= first +second;
            first=second;
            second=next;
        }
        return second;
    }
    // Recursive fibonacci
    public static long fibonacciRecursive(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return fibonacciRecursive(n-1)+ fibonacciRecursive(n-2);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("FACTORIAL: ITERATIVE vs RECURSIVE");
        System.out.println("---------------------------------");
        for (int n=0; n<= 15; n++){
            long iterative = factorialIterative(n);
            long recursive = factorialRecursive(n);

            //Use assert to verify if both methods produce the same results
            assert iterative == recursive;
        System.out.println("n= " + n + " / Iterative = " + iterative +" / Recursive = " + recursive);
    }

        System.out.println("FIBONACCI: ITERATIVE VS RECURSIVE");
        System.out.println("---------------------------------");

        for (int n=0; n<=15; n++){
            long iterative = fibonacciIterative(n);
            long recursive = fibonacciRecursive(n);

            // Use assert and verify if both methods produce the same results
            assert iterative==recursive;

            System.out.println("n= " +n + " / Iterative = " + iterative + " / Recursive = " + recursive);
        }
    }
/*
 If the recursion goes too deep, the stack eventually fills up. When there is no more room
 for another method call, Java throws a StackOverflowError.
 For the fibonacci around n = 40 to 50, the program becomes very slow because it performs millions of repeated
 calculations. A StackOverflowError would typically require much deeper recursion and depends
  on the JVM's available stack size.
 */
}
