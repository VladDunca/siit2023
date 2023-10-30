package org.example;

import org.example.others.Contact;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Phone {
    protected String color;
    protected String material;
    protected int batteryLife; // in hours
    protected String imei;
    protected Contact firstContact;
    protected Contact lastContact;
    protected List<String> callHistory = new ArrayList<>();
    protected boolean isOn;

    public Phone() {

    }

    public Phone(String color, String material, int batteryLife, String imei) {
        this.color = color;
        this.material = material;
        this.batteryLife = batteryLife;
        this.imei = imei;
        isOn = true;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void getFirstContact() {
        System.out.println(firstContact);
    }

    public void getLastContact() {
        System.out.println(lastContact);
    }

    public void addContact(String contactId, String phoneNumber, String firstName, String lastName) {
        if (!isOn){
            System.out.println("This phone has no more battery left. Charge before using.");
            return;
        }
        if (firstContact == null) {
            firstContact = new Contact(contactId, phoneNumber, firstName, lastName);
        } else if (lastContact == null) {
            lastContact = new Contact(contactId, phoneNumber, firstName, lastName);
        } else System.out.println("This phone already has 2 contacts saved. Cannot save another contact");
    }

    public void sendMessage(String phoneNumber, String messageContent) {
        if (!isOn){
            System.out.println("This phone has no more battery left. Charge before using.");
            return;
        }
        if (messageContent.length() > 100) messageContent = messageContent.substring(0, 100);
        if (phoneNumber.equals(firstContact.getPhoneNumber())) {
            if (firstContact.getFirstMessage() == null) {
                firstContact.setFirstMessage(messageContent);
                batteryLife -= 1;
                if (batteryLife == 0) isOn = false;
            } else if (firstContact.getFirstMessage() != null && firstContact.getSecondMessage() == null) {
                firstContact.setSecondMessage(messageContent);
                batteryLife -= 1;
                if (batteryLife == 0) isOn = false;
            } else System.out.println("You have already sent 2 messages to this number");
        } else if (phoneNumber.equals(lastContact.getPhoneNumber())) {
            if (lastContact.getFirstMessage() == null) {
                lastContact.setFirstMessage(messageContent);
                batteryLife -= 1;
                if (batteryLife == 0) isOn = false;
            } else if (lastContact.getFirstMessage() != null && lastContact.getSecondMessage() == null) {
                lastContact.setSecondMessage(messageContent);
                batteryLife -= 1;
                if (batteryLife == 0) isOn = false;
            } else System.out.println("You have already sent 2 messages to this number");
        } else System.out.println("The phone number you have introduced doesn't belong to any contact on this phone");
    }

    public void getFirstMessage(String phoneNumber) {
        if (firstContact.getPhoneNumber().equals(phoneNumber)) {
            if (null == firstContact.getFirstMessage()){
                System.out.println("No message to show");
                return;
            }
            System.out.println(firstContact.getFirstMessage());
        } else if (lastContact.getPhoneNumber().equals(phoneNumber)) {
            if (null == lastContact.getFirstMessage()){
                System.out.println("No message to show");
                return;
            }
            System.out.println(lastContact.getFirstMessage());
        } else {
            System.out.println("This number doesn't belong to any contact");
        }
    }

    public void getSecondMessage(String phoneNumber) {
        if (firstContact.getPhoneNumber().equals(phoneNumber)) {
            if (null == firstContact.getSecondMessage()){
                System.out.println("No message to show");
                return;
            }
            System.out.println(firstContact.getSecondMessage());
        } else if (lastContact.getPhoneNumber().equals(phoneNumber)) {
            if (null == lastContact.getSecondMessage()){
                System.out.println("No message to show");
                return;
            }
            System.out.println(lastContact.getSecondMessage());
        } else {
            System.out.println("This number doesn't belong to any contact");
        }
    }

    public void call(String phoneNumber) {
        Date dt = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("kk:mm:ss");
        if (firstContact.getPhoneNumber().equals(phoneNumber)) {
            callHistory.add("You have called " + firstContact.getFirstName() + " " + firstContact.getLastName() + " at " + dateFormat.format(dt));
            batteryLife -= 2;
            if (batteryLife == 0) isOn = false;
        } else if (lastContact.getPhoneNumber().equals(phoneNumber)) {
            callHistory.add("You have called " + lastContact.getFirstName() + " " + lastContact.getLastName() + " at " + dateFormat.format(dt));
            batteryLife -= 2;
            if (batteryLife == 0) isOn = false;
        } else {
            callHistory.add("You have called " + phoneNumber + " at " + dateFormat.format(dt));
            batteryLife -= 2;
            if (batteryLife == 0) isOn = false;
        }
    }

    public void viewHistory() {
        if (!isOn){
            System.out.println("This phone has no more battery left. Charge before using.");
            return;
        }
        for (String call : callHistory) {
            System.out.println(call);
        }
    }
    public abstract void charge();

}
