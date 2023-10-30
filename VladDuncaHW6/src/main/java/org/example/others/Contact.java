package org.example.others;

public class Contact {
    private String contactId;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String firstMessage;
    private String secondMessage;

    public Contact(String contactId, String phoneNumber, String firstName, String lastName) {
        this.contactId = contactId;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Contact={contactId: " + contactId + ", phoneNumber: " + phoneNumber + ", firstName: " + firstName + ", lastName: " + lastName + "}";
    }

    public String getContactId() {
        return contactId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstMessage() {
        return firstMessage;
    }

    public void setFirstMessage(String firstMessage) {
        this.firstMessage = firstMessage;
    }

    public String getSecondMessage() {
        return secondMessage;
    }

    public void setSecondMessage(String secondMessage) {
        this.secondMessage = secondMessage;
    }
}
