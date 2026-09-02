package org.example.projects.ContactManager;


import java.util.List;
import java.util.Scanner;

public class ContactManagerApp {
    private static void printMenu() {
        System.out.println();
        System.out.println("===== Contact Manager =====");
        System.out.println("1. Add Contact");
        System.out.println("2. View All Contacts");
        System.out.println("3. Search Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Sort Contact");
        System.out.println("6. Exit");
        System.out.println("===========================");
    }

    private static String readLine(Scanner sc) {
        if (!sc.hasNextLine()) {
            return null;
        }
        return sc.nextLine().trim();
    }


    private static void printContacts(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        for(Contact c : contacts) {
            System.out.println(c);
        }
    }

    private static String promptForName(Scanner sc)  {
        System.out.print("Enter name: ");
        String name = readLine(sc);

        if (name == null) {
            return null;
        }
        if (name.isBlank()) {
            System.out.println("Name cannot be blank.");
            return "";
        }
        return name;
    }

    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       ContactService service = new ContactService();
       boolean running = true;

       while (running) {
           printMenu();

           System.out.print("Choose an option: ");
           if (!sc.hasNextLine()) {
               System.out.println("\nInput closed. Exiting.");
               break;
           }

           String choice = sc.nextLine().trim();

           switch(choice) {
               case "1":
                   System.out.print("Enter Name: ");
                   String name = readLine(sc);

                   if (name == null) {
                       System.out.println("\nInput closed. Exiting.");
                       running = false;
                       break;
                   }

                   if(name.isBlank()) {
                       System.out.println("Name cannot be blank");
                       break;
                   }

                   System.out.print("Enter phone: ");
                   String phone = readLine(sc);

                   if (phone == null) {
                       System.out.println("\nInput closed. Exiting.");
                       running = false;
                       break;

                   }

                   System.out.print("Enter email: ");
                   String email = readLine(sc);

                   if(email == null) {
                       System.out.println("\nInput closed. Exiting.");
                       running = false;
                       break;
                   }

                   Contact contact = new Contact(name, phone, email);

                   if(service.addContact(contact)) {
                       System.out.println("Contact added successfully.");
                   } else {
                       System.out.println("Name already exists.");
                   }
                   break;

               case "2":
                   List<Contact> all = service.getAll();
                   printContacts(all);
                   break;

               case "3":
                   String searchName = promptForName(sc);

                   if (searchName == null) {
                       System.out.println("\nInput closed. Exiting");
                       running = false;
                       break;
                   }

                   if(searchName.isEmpty()) {
                       break;
                   }

                   Contact found = service.findByName((searchName));

                   if(found != null) {
                       System.out.println(found);
                   } else {
                       System.out.println("Contact not found.");
                   }
                   break;

               case "4":

                   String deleteName = promptForName(sc);

                   if (deleteName == null) {
                       System.out.println("\nInput closed. Exiting");
                       running = false;
                       break;
                   }

                   if(deleteName.isEmpty()){
                       break;
                   }

                   if (service.deleteContact(deleteName)) {
                       System.out.println("Deleted.");
                   } else {
                       System.out.println("Contact not found.");
                   }
                   break;

               case "5":
                   List<Contact> sorted = service.getAllSorted();
                   printContacts(sorted);
                   break;

               case "6":
                   System.out.println("Goodbye!");
                   running = false;
                   break;

               default:
                   System.out.println("Invalid option. Please choose 1-6.");
           }
       }
       sc.close();

    }
}
