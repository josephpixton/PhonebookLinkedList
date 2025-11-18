public class TestClass {
    public static void main(String[] args) {
        PhonebookManager manager = new PhonebookManager();

        // Add entries
        manager.addAtBeginning(new ListNode("Alice", "Smith", "123 Main St", "Bellingham", "98225", "360-555-1234"));
        manager.addAtEnd(new ListNode("Bob", "Johnson", "456 Oak Ave", "Seattle", "98101", "206-555-5678"));
        manager.addAtIndex(new ListNode("Charlie", "Brown", "789 Pine Rd", "Tacoma", "98402", "253-555-9876"), 1);

        System.out.println("Initial Phonebook:");
        manager.printList();

        // Modify entry
        manager.modifyEntry(1, new ListNode("Charlie", "Brown", "789 Pine Rd", "Tacoma", "98402", "253-555-0000"));
        System.out.println("\nAfter Modification:");
        manager.printList();

        // Search by index
        System.out.println("\nSearch by Index (1): " + manager.searchByIndex(1));

        // Search by field
        System.out.println("Search by Last Name 'Johnson': " + manager.searchByField("lastname", "Johnson"));

        // Delete by index
        manager.deleteByIndex(0);
        System.out.println("\nAfter Deleting Index 0:");
        manager.printList();

        // Delete by field
        manager.deleteByField("lastname", "Johnson");
        System.out.println("\nAfter Deleting Last Name 'Johnson':");
        manager.printList();
    }
}
