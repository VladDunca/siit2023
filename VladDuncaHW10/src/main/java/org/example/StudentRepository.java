package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

class StudentRepository {
    private List<Student> students = new ArrayList<>();
    private Logger logger = Logger.getLogger(StudentRepository.class.getName());

    public void addStudent(String firstName, String lastName, LocalDate dateOfBirth, String gender, String id) {
        try {
            Student student = new Student(firstName, lastName, dateOfBirth, gender, id);
            students.add(student);
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Exception while adding student: " + e.getMessage());
            throw e;
        }
    }

    public void deleteStudentById(String id) {
        if (id.isEmpty()) {
            throw new IllegalArgumentException("ID is empty.");
        }
        boolean removed = students.removeIf(student -> student.getId().equals(id));
        if (!removed) {
            throw new NoSuchElementException("Student with ID " + id + " does not exist.");
        }
    }

    public List<Student> retrieveStudentsWithAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        List<Student> studentsWithAgeX = new ArrayList<>();
        for (Student student : students) {
            int studentAge = student.getAge();
            if (studentAge == age) {
                studentsWithAgeX.add(student);
            }
        }
        return studentsWithAgeX;
    }

    public List<Student> listStudentsSortedBy(String sortBy) {
        if (sortBy.isEmpty()) {
            throw new IllegalArgumentException("Sorting parameter is empty.");
        }
        Comparator<Student> comparator;
        if (sortBy.equalsIgnoreCase("Last Name")) {
            comparator = Comparator.comparing(Student::getLastName);
        } else if (sortBy.equalsIgnoreCase("Birth Date")) {
            comparator = Comparator.comparing(Student::getDateOfBirth);
        } else {
            throw new IllegalArgumentException("Invalid sorting parameter.");
        }
        List<Student> sortedStudents = new ArrayList<>(students);
        sortedStudents.sort(comparator);
        return sortedStudents;
    }
}
