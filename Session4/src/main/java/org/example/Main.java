package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Bank account");
        System.out.println();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter account Id: ");
        String accountId= sc.nextLine();
        System.out.println("Enter owners' name: ");
        String owner= sc.nextLine();
        System.out.println(" Enter balance: ");
        double balance= sc.nextDouble();

        BankAccount account = new BankAccount(accountId,owner, balance);

        account.toString();
        System.out.println("Making a deposit...");
        System.out.println("Enter amount to deposit: ");
        double depositAmount= sc.nextDouble();
        account.deposit(depositAmount);
        System.out.println("Withdrawing... ");
        System.out.println("Enter amount to withdraw: ");
        double withdrawAmount=sc.nextDouble();
        account.withdraw(withdrawAmount);

        System.out.println("Updated info");
        account.toString();

        System.out.println("===================================================");
        System.out.println("Exercise No2");
        System.out.println(" STUDENT ");

        System.out.println();

        Student Nice=new Student("26458","Nice Umutoni",2.0);
        Nice.addGrade(2.0);
        Nice.addGrade(1.8);
        double gpa= Nice.computeGPA();
        System.out.println(Nice);
        System.out.println("GPA "+ Nice.computeGPA());

        Student Alice=new Student("202020","Alice Uwera",3.8);
        Alice.addGrade(1.9);
        Alice.addGrade(3.9);
        System.out.println(Alice);
        System.out.println("Gpa: " + Alice.computeGPA());

        Student Keza= new Student("198765","Keza Alia",2.1);
        System.out.println(Keza);
        System.out.println("GPA: " + Keza.computeGPA());

        System.out.println();
        System.out.println("==============================================");
        System.out.println("EXERCISE No3");

        System.out.println(" Creating a new deck ");
        Deck deck = new Deck();
        System.out.println("Deck size: " + deck.getSize()); // Should be 52

        System.out.println("\n First 5 cards before shuffling ");
        for (int i = 0; i < 5; i++) {
            System.out.println("  " + deck.getCards().get(i));
        }

        System.out.println("\n Shuffling the deck ");
        deck.shuffle();
        System.out.println("Deck shuffled!");

        System.out.println("\nFirst 5 cards after shuffling ");
        for (int i = 0; i < 5; i++) {
            System.out.println("  " + deck.getCards().get(i));
        }

        System.out.println("\n Dealing cards ");
        for (int i = 1; i <= 5; i++) {
            Card dealt = deck.dealCard();
            System.out.println("Dealt card #" + i + ": " + dealt);
            System.out.println("  Cards remaining: " + deck.getSize());
        }

        System.out.println("\n Dealing all remaining cards ");
        while (!deck.isEmpty()) {
            Card card = deck.dealCard();
            System.out.println("Dealt: " + card + " (Remaining: " + deck.getSize() + ")");
        }

        System.out.println("\n Testing empty deck exception ");
        try {
            deck.dealCard(); // This should throw an exception
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage());
            System.out.println(" Exception worked correctly!");
        }

        System.out.println("\nTesting Card equality ");
        Card card1 = new Card(Suit.HEARTS, Rank.ACE);
        Card card2 = new Card(Suit.HEARTS, Rank.ACE);
        Card card3 = new Card(Suit.SPADES, Rank.ACE);

        System.out.println("card1: " + card1);
        System.out.println("card2: " + card2);
        System.out.println("card3: " + card3);
        System.out.println("card1.equals(card2): " + card1.equals(card2)); // true
        System.out.println("card1.equals(card3): " + card1.equals(card3)); // false

        System.out.println("\n All tests passed!");
    }
}