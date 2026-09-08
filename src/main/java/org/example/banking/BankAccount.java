package org.example.banking;

import org.example.InsufficientFundsException;

import java.util.Objects;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        if(accountNumber== null || accountNumber.trim().isEmpty()){
            throw new IllegalArgumentException("Account number can not be empty");
        }
        if(accountHolder == null || accountHolder.trim().isEmpty()){
            throw new IllegalArgumentException(" Account holder can not be empty");
        }
        if(initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance can not be negative");
        }
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    public void deposit(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance +=amount;
    }
    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount<=0){
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if(amount> balance){
            throw new InsufficientFundsException("Insufficient funds. balance: " + balance + ", requested: " + amount);
        }
        this.balance -= amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                " accountNumber= " + accountNumber +
                ", accountHolder= " + accountHolder  +
                ", balance= " + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Double.compare(balance, that.balance) == 0 &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(accountHolder, that.accountHolder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountHolder, balance);
    }
}
