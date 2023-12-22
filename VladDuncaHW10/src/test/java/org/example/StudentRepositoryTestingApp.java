package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentRepositoryTestingApp {

    public static void main(String[] args) {
        testStudentRepository();
    }

    private static void testStudentRepository() {
        StudentRepository repository = new StudentRepository();

        // Scenario 1: Adding valid students
        try {
            repository.addStudent("Vlad", "Dunca", LocalDate.of(2002, 12, 21), "Male", "12345");
            repository.addStudent("Andreea", "Pop", LocalDate.of(2000, 10, 20), "Female", "67890");
            repository.addStudent("Ana", "Ionescu", LocalDate.of(1998, 9, 18), "Female", "24680");
            repository.addStudent("Mihai", "Popescu", LocalDate.of(1996, 6, 30), "Male", "97531");
            repository.addStudent("Elena", "Dumitrescu", LocalDate.of(1997, 12, 5), "Female", "86420");
            System.out.println("Scenario 1: Added students successfully");
        } catch (IllegalArgumentException e) {
            System.err.println("Exception occurred while adding students: " + e.getMessage());
        }

        // Scenario 2: Deleting a student by ID
        try {
            repository.deleteStudentById("12345");
            System.out.println("Scenario 2: Deleted student with ID '12345'");
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.err.println("Exception occurred while deleting student: " + e.getMessage());
        }

        // Scenario 3: Retrieving students with a specific age
        try {
            List<Student> studentsAge25 = repository.retrieveStudentsWithAge(25);
            System.out.println("Scenario 3: Students with age 25:");
            for (Student student : studentsAge25) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Exception occurred while retrieving students by age: " + e.getMessage());
        }

        // Scenario 4: Listing students sorted by last name
        try {
            List<Student> studentsSortedByName = repository.listStudentsSortedBy("Last Name");
            System.out.println("Scenario 4: Students sorted by last name:");
            for (Student student : studentsSortedByName) {
                System.out.println(student.getLastName() + ", " + student.getFirstName());
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Exception occurred while listing students: " + e.getMessage());
        }
    }
}
