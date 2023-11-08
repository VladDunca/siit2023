package org.example.taskclasses;

import java.util.ArrayList;
import java.util.List;

public class Hobby {
    private String name;
    private int frequency;
    private List<Address> addressList = new ArrayList<>();

    public Hobby() {
    }

    public Hobby(String name, int frequency, List<Address> addressList) {
        this.name = name;
        this.frequency = frequency;
        this.addressList = addressList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
    public void printCountries(){
        for (Address address:addressList){
            System.out.print(address.getCountry() + " ");
        }
    }
}
