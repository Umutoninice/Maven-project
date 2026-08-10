package org.example;

import banking.BankAccount;

import java.util.ArrayList;
import java.util.List;

public interface printable {
    public void printSummary();

    public static void printHeader(){
        System.out.println("===SUMMARY===");
    }
    public static void printAll(List<printable> items) {

        for (printable item : items) {
            item.printSummary();
        }


        items.add(new Student());
items.add(new BankAccount());
        items.add(new Card());
printHeader();
        printAll(items);
    }
}
