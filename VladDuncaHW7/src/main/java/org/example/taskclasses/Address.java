package org.example.taskclasses;

import java.util.Objects;

public class Address {
    private String country;
    private String city;
    private String streetName;
    private int addressNumber;

    public Address() {
    }

    public Address(String country,String city, String streetName, int addressNumber) {
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.addressNumber = addressNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressNumber == address.addressNumber && Objects.equals(country, address.country) && Objects.equals(city, address.city) && Objects.equals(streetName, address.streetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, streetName, addressNumber);
    }
}
