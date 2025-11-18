public class ListNode {
    String firstName;
    String lastName;
    String streetAddress;
    String city;
    String zipCode;
    String phoneNumber;
    ListNode next;

    public ListNode(String firstName, String lastName, String streetAddress,
                    String city, String zipCode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + streetAddress + ", " +
               city + " " + zipCode + " | " + phoneNumber;
    }
}

