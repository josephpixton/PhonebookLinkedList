import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        PhonebookManager manager = new PhonebookManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Phonebook Menu ---");
            System.out.println("1. Add Entry at Beginning");
            System.out.println("2. Add Entry at End");
            System.out.println("3. Add Entry at Index");
            System.out.println("4. Modify Entry");
            System.out.println("5. Delete by Index");
            System.out.println("6. Delete by Field");
            System.out.println("7. Search by Index");
            System.out.println("8. Search by Field");
            System.out.println("9. Print Phonebook");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    manager.addAtBeginning(createEntry(scanner));
                    break;
                case 2:
                    manager.addAtEnd(createEntry(scanner));
                    break;
                case 3:
                    System.out.print("Enter index: ");
                    int idx = scanner.nextInt();
                    scanner.nextLine();
                    manager.addAtIndex(createEntry(scanner), idx);
                    break;
                case 4:
                    System.out.print("Enter index to modify: ");
                    int modIdx = scanner.nextInt();
                    scanner.nextLine();
                    manager.modifyEntry(modIdx, createEntry(scanner));
                    break;
                case 5:
                    System.out.print("Enter index to delete: ");
                    int delIdx = scanner.nextInt();
                    scanner.nextLine();
                    manager.deleteByIndex(delIdx);
                    break;
                case 6:
                    System.out.print("Enter field (firstname, lastname, city, zipcode, phone): ");
                    String field = scanner.nextLine();
                    System.out.print("Enter value: ");
                    String value = scanner.nextLine();
                    manager.deleteByField(field, value);
                    break;
                case 7:
                    System.out.print("Enter index to search: ");
                    int searchIdx = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(manager.searchByIndex(searchIdx));
                    break;
                case 8:
                    System.out.print("Enter field (firstname, lastname, city, zipcode, phone): ");
                    String sField = scanner.nextLine();
                    System.out.print("Enter value: ");
                    String sValue = scanner.nextLine();
                    System.out.println(manager.searchByField(sField, sValue));
                    break;
                case 9:
                    manager.printList();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // Helper method to create a new entry from user input
    private static ListNode createEntry(Scanner scanner) {
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Street Address: ");
        String street = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("Zip Code: ");
        String zip = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();

        return new ListNode(firstName, lastName, street, city, zip, phone);
    }
}

