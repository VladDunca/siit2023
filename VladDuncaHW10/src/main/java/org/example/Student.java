package org.example;
import java.time.LocalDate;
import java.time.Period;

class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String id;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String id) {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("First name and last name should not be empty.");
        }
        if (!isValidDateOfBirth(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date of birth.");
        }
        if (!isValidGender(gender)) {
            throw new IllegalArgumentException("Invalid gender.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender.toUpperCase();
        this.id = id;
    }

    private boolean isValidDateOfBirth(LocalDate dob) {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        return dob.isAfter(LocalDate.of(currentYear - 118, 1, 1)) && dob.isBefore(currentDate);
    }

    private boolean isValidGender(String gender) {
        String genderUpper = gender.toUpperCase();
        return genderUpper.equals("MALE") || genderUpper.equals("FEMALE") || genderUpper.equals("M") || genderUpper.equals("F");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }
}
