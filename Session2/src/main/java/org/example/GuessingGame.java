package org.example;

import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
Scanner scanner= new Scanner(System.in);
String playAgain="Y";
while(playAgain.equalsIgnoreCase("Y")){
    int secretNumber= (int) (Math.random()*100) +1;
    int attempts=0;
    boolean guessedCorrectly= false;

    System.out.println();
    System.out.println("WELCOME TO THE NUMBER GUESSING GAME");
    System.out.println("===================================");
    System.out.println(" I have chosen a number between 1 and 100.");
    System.out.println("You have 10 attempts to guess it");
    System.out.println("Wish you good luck!!!");

    while (attempts <10 && !guessedCorrectly){
        System.out.println("\n Enter your guess: ");
        int guess=scanner.nextInt();
        attempts++;
        if(guess < secretNumber){
            System.out.println("Too low!");
        }else if (guess> secretNumber){
            System.out.println("Too high!");
        }else{
            guessedCorrectly =true;
            System.out.println("\nCorrect!");
            System.out.println("You guessed number in " + attempts + " attempt(s)");

            //performance summary
            if(attempts <=3){
                System.out.println("Excellent! You are a master");
            }else if (attempts<=5){
                System.out.println("Solved in "+ attempts+ " attempts. Good");
            }else if (attempts<=8){
                System.out.println("Solved in "+attempts+ " attempts. Nice job!");
            }else{
                System.out.println("Solved in " +attempts+ " attempts. Tried!");
            }

        }
    }
    //If user failed all 10 attempts
    if(!guessedCorrectly){
        System.out.println("\nYou have used all 10 attempts. ");
        System.out.println("The correct number was: " +secretNumber);
    }
    System.out.println("Would you like to play again? (Y/N): ");
    playAgain =scanner.next();
}
        System.out.println("Thank you for playing this game!");
        System.out.println("Hope to see you again!");

        scanner.close();

    }
}
