import banking.*;
import org.example.Card;
import org.example.Student;
import org.example.printable;
import rpg.*;
import Shapes.*;

import java.lang.Character;
import java.util.ArrayList;
import java.util.List;


import static org.example.printable.printAll;

public class BattleSimulator {
    public static void Simulate(Character a, Character b) {
        System.out.println(" BATTLE BEGINS ");
        System.out.println(a.getName(a) + " vs " + b.getName(b));
       /* Character attacker,defender;
        if (a.getSpeed() >= b.getSpeed()){
            attacker =a;
            defender=b;
        }else{
            attacker=b;
            defender=a;
        }

        */
    }


    public static void printAll(List<printable> items) {
        for (printable item : items) {
            item.printSummary();
        }
    }
    public static void main(String[] args) {
        System.out.println("=== PART 1: SHAPE HIERARCHY ===");

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5));
        shapes.add(new Rectangle(4, 6));
        shapes.add(new Triangle(4, 5, 2));

        for (Shape shape : shapes) {
            System.out.println(shape.describe());
            System.out.println();
        }
        System.out.println("=== PART 2: BANK ACCOUNT HIERARCHY ===");
        System.out.println();

        List<BankAccount> accounts = new ArrayList<>();
        savingAccount savings = new savingAccount("SAV001", "Alice", 1000, 5.0);
        checkingAccount checking = new checkingAccount("CHK001", "Nice", 500, 25);

        accounts.add(savings);
        accounts.add(checking);

        for (BankAccount account : accounts) {
            System.out.println(account);
            account.deposit(5000);
            account.withdraw(2000);


        }

       System.out.println();
        System.out.println("=== PART 3: PRINTABLE INTERFACE ===");
        System.out.println();
        List<printable> printables = new ArrayList<>();
        printables.add(new Student());
       // printables.add(new Card("SPADES","ACE"));
        printAll(printables);



       System.out.println("=== PART 4: RPG CHARACTER SYSTEM ===\n");

        // Create characters
        Warrior warrior = new Warrior("Nice");
        Mage mage = new Mage("Mellisa");
        Rogue rogue = new Rogue("Peace");

        // Battle 1: Warrior vs Mage
        System.out.println("Match 1: Warrior vs Mage");
       // Simulate(Warrior, Mage);
        System.out.println();

        // Reset health for next battle
        System.out.println("Match 2: Rogue vs Warrior");
        rogue = new Rogue("Peace"); // Reset health
        //Simulate();
        System.out.println();

        // Battle 3: Rogue vs Mage
        System.out.println("Match 3: Rogue vs Mage");
        mage = new Mage("Mellisa"); // Reset health
        //Simulate(rogue, mage);
        System.out.println();


    }
}
