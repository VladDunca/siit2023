package org.example;

import org.example.comparators.AgeComparator;
import org.example.comparators.NameComparator;
import org.example.persons.Hired;
import org.example.persons.Person;
import org.example.persons.Student;
import org.example.persons.Unemployed;
import org.example.taskclasses.Address;
import org.example.taskclasses.Hobby;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        Instances initialization beginning --------------------------------------------------------------------------------------

        NameComparator nameComparator = new NameComparator();
        AgeComparator ageComparator = new AgeComparator();

        Set<Person> personSet = new TreeSet<>(nameComparator.thenComparing(ageComparator));

        Person person1 = new Hired("Andrei", 36, 674328, 3000);
        Person person2 = new Unemployed("Cristian", 19, 983785);
        Person person3 = new Student("Dorian", 21, 353123);

        Address address1 = new Address("USA", "New York", "Broadway St", 123);
        Address address2 = new Address("Canada", "Toronto", "Main St", 456);
        Address address3 = new Address("UK", "London", "Oxford St", 789);
        Address address4 = new Address("France", "Paris", "Champs-Élysées", 101);
        Address address5 = new Address("Germany", "Berlin", "Brandenburg Gate", 222);
        Address address6 = new Address("Spain", "Barcelona", "Rambla St", 333);
        Address address7 = new Address("Italy", "Rome", "Colosseum St", 444);
        Address address8 = new Address("Australia", "Sydney", "Opera House St", 555);
        Address address9 = new Address("Japan", "Tokyo", "Shibuya Crossing", 666);
        Address address10 = new Address("India", "Mumbai", "Gateway of India St", 777);
        Address address11 = new Address("Brazil", "Rio de Janeiro", "Copacabana Beach", 888);
        Address address12 = new Address("China", "Beijing", "Great Wall St", 999);
        Address address13 = new Address("Russia", "Moscow", "Red Square St", 111);
        Address address14 = new Address("South Africa", "Cape Town", "Table Mountain St", 222);
        Address address15 = new Address("Argentina", "Buenos Aires", "Tango St", 333);
        Address address16 = new Address("Mexico", "Mexico City", "Zocalo St", 444);
        Address address17 = new Address("Netherlands", "Amsterdam", "Canal St", 555);
        Address address18 = new Address("Switzerland", "Zurich", "Bahnhofstrasse", 666);
        Address address19 = new Address("Sweden", "Stockholm", "Gamla Stan", 777);
        Address address20 = new Address("Norway", "Oslo", "Karl Johans Gate", 888);

        List<Address> addressList1 = new ArrayList<>(List.of(address1, address2, address3, address4));
        List<Address> addressList2 = new ArrayList<>(List.of(address5, address6, address7, address8));
        List<Address> addressList3 = new ArrayList<>(List.of(address9, address10, address11, address12));
        List<Address> addressList4 = new ArrayList<>(List.of(address13, address14, address15, address16));
        List<Address> addressList5 = new ArrayList<>(List.of(address17, address18, address19, address20));

        Hobby hobby1 = new Hobby("Reading", 3, addressList1);
        Hobby hobby2 = new Hobby("Cooking", 2, addressList2);
        Hobby hobby3 = new Hobby("Painting", 4, addressList3);
        Hobby hobby4 = new Hobby("Gardening", 1, addressList4);
        Hobby hobby5 = new Hobby("Photography", 5, addressList5);

        List<Hobby> person1hobbyList = new ArrayList<>(List.of(hobby1, hobby2));
        List<Hobby> person2hobbyList = new ArrayList<>(List.of(hobby5));
        List<Hobby> person3hobbyList = new ArrayList<>(List.of(hobby3, hobby4));

//        Instances initialization ending --------------------------------------------------------------------------------------

        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);

        Iterator<Person> personIterator = personSet.iterator();

        while (personIterator.hasNext()) {
            personIterator.next().printNameAndAge();
        }

        Map<Person, List<Hobby>> personHobbyMap = new HashMap<>(Map.of(person1, person1hobbyList, person2, person2hobbyList, person3, person3hobbyList));
        for (Hobby hobby:person3hobbyList){
            System.out.print(hobby.getName() + " Countries: ");
            hobby.printCountries();
            System.out.println();
        }
    }
}