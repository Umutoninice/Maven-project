package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("BANK ACCOUNT - EXCEPTION HANDLING");
        System.out.println("=================================");
        System.out.println();

        BankAccount account= new BankAccount("ACC123","Nice Umutoni",100000);
        account.toString();
        System.out.println();
        // successful withdraw
        System.out.println("Successful withdrawal");
        try{
            account.withdraw(2000);

        }catch(InsufficientFundsException e){
            System.out.println("Caught: " +e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println();
        System.out.println("Insufficient funds");
        try{
            account.withdraw(300000);
        }catch(InsufficientFundsException e){
            System.out.println("Caught: " + e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println();
        System.out.println("RunTime exceptions");
        try{
            account.withdraw(200000);
        }catch(RuntimeException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
            System.out.println("This catches all RunTime exceptions together");
        }
            System.out.println();

            System.out.println("Negative amount");
            try{
                account.withdraw(-2);
            }catch(InsufficientFundsException e){
                System.out.println("Caught: " + e.getMessage());
        }
    }
}