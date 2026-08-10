package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// HashMap
public class ContactBook {
    HashMap<String,Contact> contactBook;
Scanner scanner=new Scanner(System.in);
    public ContactBook() {
        contactBook = new HashMap<>();
    }
    public void addContact(){
        System.out.println("Enter name: ");
        String name= scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone=scanner.nextLine();
        System.out.println("Enter email: ");
        String email=scanner.nextLine();

        if(!contactBook.containsKey(name)){
            contactBook.put(name,new Contact(name,phone,email));
            ContactBook newContact= new ContactBook();
            System.out.println("Contact added successfully!");
        }
        contactBook.get(name);
        System.out.println("The contact: " + contactBook.get(name) );
    }
    public void searchContact(){
        System.out.println("Enter name to search: ");
        String searchName= scanner.nextLine();
        for(Map.Entry<String, Contact> entry: contactBook.entrySet()){
            System.out.println("Name: " + entry.getKey() + "contacts: " + entry.getValue());
        }
    if(searchName.isEmpty()){
        System.out.println("please enter name to search");
    }else if(contactBook.containsKey(searchName.toLowerCase())) {

        System.out.println(" The contact is found with names: " + searchName.toLowerCase());
    }else{
        System.out.println("You don't have that name '" + searchName.toLowerCase() + " ' on the list");
    }
    }
    public void listAllContacts() {
        System.out.println("List all contacts");
        for (Map.Entry<String, Contact> entry : contactBook.entrySet()) {
            System.out.println("Name: " + entry.getKey() + "Contacts" + entry.getValue());
        }
    }
        public void deleteContact() {

            System.out.println("Delete contact");
            System.out.println("Enter name to delete contact");
            String deleteName = scanner.nextLine().trim();
            String deleteKey = String.valueOf(contactBook.get(deleteName.toLowerCase()));

            if (deleteKey != null && contactBook.containsKey(deleteKey)) {
                Contact removed = contactBook.remove(deleteKey);
                contactBook.remove(deleteName.toLowerCase());
                System.out.println("Contact '" + removed.getName() +
                        "' deleted successfully");
            } else {
                System.out.println("That name '" + deleteName +
                        "' doesn't belong to your list");
            }


}
    public static void assertNull(String contact1) {
       contact1 = null;
        Assert.assertNull(null);
    }
    public void report(){
        System.out.println("Contact book report");
        System.out.println("-------------------");

        for (Map.Entry<String, Contact> entry : contactBook.entrySet()) {
            System.out.println("Name: " + entry.getKey() +"Contacts" + entry.getValue());
        }
    }

    public void run() {
        System.out.println(" ===CONTACTS=== ");
        System.out.println("Contacts menu");
        boolean running = true;
        while (running) {
            System.out.println("1. Add contact ");
            System.out.println("2. Search by name ");
            System.out.println("3. List all contacts ");
            System.out.println("4. Delete by name ");
            System.out.println("5. Exit ");
            System.out.println(" Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addContact();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    listAllContacts();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("GoodBye !!!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again...");
            }
        }
    }
    public static void main(String[] args) {
        ContactBook program= new ContactBook();
        program.run();
     program.report();
     assertNull("nice");
    }
}

