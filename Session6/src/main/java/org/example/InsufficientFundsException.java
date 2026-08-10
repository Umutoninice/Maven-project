package org.example;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message){
        super(message);
    }
    public InsufficientFundsException(double requested,double balance){
        super(String.format("Insufficient funds! Requested: %.2f , Available: %.2f, Short by: $%.2f", requested,balance,(requested-balance)));

    }
    public InsufficientFundsException(String message, Throwable cause){
        super (message, cause);
    }

}
