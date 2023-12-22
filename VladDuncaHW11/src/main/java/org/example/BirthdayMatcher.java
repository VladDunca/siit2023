package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayMatcher {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java BirthdayMatcher <input filename> <target month> <output filename>");
            return;
        }

        String inputFilename = args[0];
        int targetMonth = Integer.parseInt(args[1]);
        String outputFilename = args[2];

        List<Person> people = loadFromFile(inputFilename);

        List<Person> matches = filterByMonth(people, targetMonth);

        writeToOutputFile(matches, outputFilename);
    }

    protected static List<Person> loadFromFile(String filename) {
        List<Person> people = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String firstName = parts[0].trim();
                String lastName = parts[1].trim();
                LocalDate dateOfBirth = LocalDate.parse(parts[2].trim()); // Assuming the date format is yyyy-MM-dd
                people.add(new Person(firstName, lastName, dateOfBirth));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }

    protected static List<Person> filterByMonth(List<Person> people, int targetMonth) {
        return people.stream()
                .filter(person -> person.getDateOfBirth().getMonthValue() == targetMonth)
                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    protected static void writeToOutputFile(List<Person> people, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Person person : people) {
                writer.write(person.getFirstName() + ", " + person.getLastName());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
