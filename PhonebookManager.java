public class PhonebookManager {
    private ListNode head;

    // Add at beginning
    public void addAtBeginning(ListNode newNode) {
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(ListNode newNode) {
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Add at specific index
    public void addAtIndex(ListNode newNode, int index) {
        if (index == 0) {
            addAtBeginning(newNode);
            return;
        }
        ListNode current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Index out of bounds.");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete by index
    public void deleteByIndex(int index) {
        if (head == null) return;
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Index out of bounds.");
            return;
        }
        current.next = current.next.next;
    }

    // Delete by field (e.g., lastName)
    public void deleteByField(String field, String value) {
        if (head == null) return;

        // Special case: head matches
        if (matchesField(head, field, value)) {
            head = head.next;
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            if (matchesField(current.next, field, value)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Modify entry at index
    public void modifyEntry(int index, ListNode updatedNode) {
        ListNode current = head;
        for (int i = 0; current != null && i < index; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Index out of bounds.");
            return;
        }
        current.firstName = updatedNode.firstName;
        current.lastName = updatedNode.lastName;
        current.streetAddress = updatedNode.streetAddress;
        current.city = updatedNode.city;
        current.zipCode = updatedNode.zipCode;
        current.phoneNumber = updatedNode.phoneNumber;
    }

    // Search by index
    public ListNode searchByIndex(int index) {
        ListNode current = head;
        for (int i = 0; current != null && i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // Search by field
    public ListNode searchByField(String field, String value) {
        ListNode current = head;
        while (current != null) {
            if (matchesField(current, field, value)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Helper: check if node matches field
    private boolean matchesField(ListNode node, String field, String value) {
        switch (field.toLowerCase()) {
            case "firstname": return node.firstName.equalsIgnoreCase(value);
            case "lastname": return node.lastName.equalsIgnoreCase(value);
            case "city": return node.city.equalsIgnoreCase(value);
            case "zipcode": return node.zipCode.equalsIgnoreCase(value);
            case "phone": return node.phoneNumber.equalsIgnoreCase(value);
            default: return false;
        }
    }

    // Print list
  public void printList() {
    System.out.printf("%-5s %-15s %-15s %-20s %-15s %-10s %-15s%n",
                      "Index", "First Name", "Last Name", "Street", "City", "Zip", "Phone");
    System.out.println("-------------------------------------------------------------------------------------------");
    ListNode current = head;
    int index = 0;
    while (current != null) {
        System.out.printf("%-5d %-15s %-15s %-20s %-15s %-10s %-15s%n",
                          index, current.firstName, current.lastName,
                          current.streetAddress, current.city,
                          current.zipCode, current.phoneNumber);
        current = current.next;
        index++;
    }
}

}

