
package org.example;

import java.util.Objects;


public class BankAccount {
    private final String accountId;
    public final String owner;
    public double balance;

    public BankAccount(String accountId, String owner, double balance) {
        if(owner== null || owner.trim().isEmpty()){
            throw new IllegalArgumentException("The owner can't be blank");
        }
        if (balance<=0){
            throw new IllegalArgumentException("Opening balance must be greater than or equal to 0");
        }
        this.accountId = accountId;
        this.owner= owner;
        this.balance= balance;
        System.out.println("Account is created successfully for: " + owner);
    }

    public void deposit(double amount) {

        if(amount<=0){
            throw new IllegalArgumentException("You can not deposit negative amount or zero amount");
        }
        balance += amount;
        System.out.println("Thank you for the depositing.");
        System.out.println("You deposited: " + amount);
        System.out.println("Balance: " + balance);
    }
    public void withdraw(double amount){
        if (amount < balance ){
            balance -= amount;
            System.out.println("Thank you for withdrawing....");
            System.out.println("Your new balance is: " + balance);

        }
        if(amount > balance ) {
            throw new IllegalArgumentException("You can not withdraw more than what you have in your account");
        }
        if(amount <= 0){
            throw new IllegalArgumentException("You can not withdraw 0 amount or negative amount");
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId='" + accountId + '\'' +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountId);
    }

    public double getBalance() {
        return balance;
    }
}
