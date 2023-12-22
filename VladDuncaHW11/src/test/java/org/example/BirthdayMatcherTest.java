package org.example;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BirthdayMatcherTest {

    @Test
    public void testLoadFromFile() {
        List<Person> people = BirthdayMatcher.loadFromFile("input.txt");
        assertNotNull(people);
        assertEquals(3, people.size());
    }

    @Test
    public void testFilterByMonth() {
        List<Person> testData = List.of(
                new Person("Adrian", "Scarlatescu", LocalDate.of(1990, 5, 15)),
                new Person("Dorian", "Popa", LocalDate.of(1995, 7, 20))
        );

        List<Person> filteredPeople = BirthdayMatcher.filterByMonth(testData, 7);
        assertEquals(1, filteredPeople.size());
    }

    @Test
    public void testWriteToOutputFile() {
        List<Person> people = List.of(
                new Person("Ryan", "Gosling", LocalDate.of(1992, 3, 20)),
                new Person("Serban", "Pavlu", LocalDate.of(1987, 8, 13)
                ));

        BirthdayMatcher.writeToOutputFile(people, "test_output.txt");
        assertOutputFileContent("test_output.txt", people);
    }
    private void assertOutputFileContent(String outputFilename, List<Person> expectedPeople) {
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFilename))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < expectedPeople.size()) {
                String[] parts = line.split(", ");
                assertEquals(expectedPeople.get(index).getFirstName(), parts[0].trim());
                assertEquals(expectedPeople.get(index).getLastName(), parts[1].trim());
                index++;
            }
            assertEquals(expectedPeople.size(), index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
