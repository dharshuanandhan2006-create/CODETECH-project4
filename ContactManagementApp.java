import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class ContactManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        while (true) {

            System.out.println("\n===== CONTACT MANAGEMENT APP =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    contacts.add(new Contact(name, phone));

                    System.out.println("Contact Added Successfully!");
                    break;

                case 2:

                    if (contacts.isEmpty()) {
                        System.out.println("No Contacts Found!");
                    } else {
                        System.out.println("\n--- Contact List ---");

                        for (Contact c : contacts) {
                            System.out.println("Name : " + c.name);
                            System.out.println("Phone: " + c.phone);
                            System.out.println("---------------------");
                        }
                    }
                    break;

                case 3:

                    System.out.print("Enter Name to Search: ");
                    String searchName = sc.nextLine();

                    boolean found = false;

                    for (Contact c : contacts) {

                        if (c.name.equalsIgnoreCase(searchName)) {

                            System.out.println("\nContact Found");
                            System.out.println("Name : " + c.name);
                            System.out.println("Phone: " + c.phone);

                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Contact Not Found!");
                    }

                    break;

                case 4:

                    System.out.print("Enter Name to Delete: ");
                    String deleteName = sc.nextLine();

                    boolean deleted =
                            contacts.removeIf(c ->
                            c.name.equalsIgnoreCase(deleteName));

                    if (deleted) {
                        System.out.println("Contact Deleted Successfully!");
                    } else {
                        System.out.println("Contact Not Found!");
                    }

                    break;

                case 5:

                    System.out.println("Application Closed!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}