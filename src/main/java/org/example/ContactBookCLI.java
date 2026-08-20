package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// ArrayList
public class ContactBookCLI{

    private ArrayList<Contact> contact = new ArrayList<>();
    private Scanner sc ;

    public ContactBookCLI() {
        contact = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void addContact() {

        System.out.println("==== ADD CONTACT======");
        System.out.println("Enter name: ");
        String name = sc.nextLine();

        if (name.isEmpty()){
            System.out.println("Name can't be empty");
            return;
        }


        System.out.println("Enter phone number: ");
        String phone = sc.nextLine().trim();
        System.out.println("Enter email: ");
        String email = sc.nextLine().trim();

        Contact contact1 = new Contact(name, phone, email);

        boolean duplicate = contact.stream()
                .anyMatch(c -> c.getName().equalsIgnoreCase(name));

        if (duplicate) {
            System.out.println("A contact with this name already exists.");
            return;
        }

        contact.add(contact1);

        System.out.println("Contact added");
        System.out.println(contact1);
    }
    public void searchByName() {
        System.out.println("Search by name");
        System.out.println("Enter name to search:");

        String searchName = sc.nextLine().trim();

        if (searchName.isEmpty()) {
            System.out.println("Please enter a name to search");
            return;
        }

        Contact found = contact.stream().filter(c -> c.getName().toLowerCase()
                        .contains(searchName.toLowerCase())).findFirst().orElse(null);

        if (found == null) {
            System.out.println("No contacts found matching: " + searchName);
        } else {
            System.out.println("Found contact:");
            System.out.println("-------------------");
            System.out.println(found);
        }
    }

    public void listAll() {
        System.out.println("List all contacts found in the list");

        if (contact.isEmpty()) {
            System.out.println("Contact list is empty");
            System.out.println("Add contacts using option 1.");
            return;
        }

        List<Contact> sortedContacts = contact.stream()
                .sorted(Comparator.comparing(Contact::getName))
                .collect(Collectors.toList());

        System.out.println("Total contacts: " + sortedContacts.size());

        for (int i = 0; i < sortedContacts.size(); i++) {
            System.out.println("Contact: " + (i + 1));
            sortedContacts.get(i).display();
        }
    }
    public void deleteByName() {
        System.out.println("Delete by name");
        System.out.println("Enter name to delete");
        String deleteName = sc.nextLine();
        if (deleteName.isEmpty()) {
            System.out.println("Please enter a name to delete.");
            return;
        }
        ArrayList<Integer> indicesToDelete = new ArrayList<>();
        for (int i = 0; i < contact.size(); i++) {
            if (contact.get(i).getName().toLowerCase().equals(deleteName.toLowerCase())) {
                indicesToDelete.add(i);
            }
        }
        if (indicesToDelete.isEmpty()) {
            System.out.println("No contact found with name: " + deleteName);
            return;
        }
        if (indicesToDelete.size() > 1) {
            System.out.println("Found " + indicesToDelete.size() + "contacts with this name: ");
            for (int i = 0; i < indicesToDelete.size(); i++) {
                int index = indicesToDelete.get(i);
                System.out.println(" " + (i + 1) + " ." + contact.get(index));
            }
            System.out.println("Enter a number to delete(1-" + indicesToDelete.size() + "):");
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice >= 1 && choice <= indicesToDelete.size()) {
                    int indexToRemove = indicesToDelete.get(choice - 1);
                    Contact removed = contact.remove(indexToRemove);
                    System.out.println("Deleted: " + removed);
                } else {
                    System.out.println("Invalid choice. Deletion cancelled.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Deletion cancelled.");
            }
        } else {
            int indexToRemove = indicesToDelete.get(0);
            Contact removed = contact.remove(indexToRemove);
            System.out.println("Deleted: " + removed);
        }
    }


    public  void displayMenu() {
        System.out.println(" Contact book menu");
        System.out.println("--------------------------");
        System.out.println("1. Add contact");
        System.out.println("2. Search by name");
        System.out.println("3. List all");
        System.out.println("4. Delete by name");
        System.out.println("5. Exit");
        System.out.println("Enter your choice(1-5):");
    }
    public void run(){
        System.out.println(" WELCOME TO CONTACT BOOK CLI");
        boolean running=true;
        while(running){
            displayMenu();
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addContact();
                    break;

                case 2:
                    searchByName();
                    break;
                case 3:
                    listAll();
                    break;
                case 4:
                    deleteByName();
                    break;
                case 5:
                    System.out.println("Exit");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        ContactBookCLI program= new ContactBookCLI();
        program.run();
    }
}
