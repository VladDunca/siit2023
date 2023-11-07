package org.example.persons;

public class Student extends Person{
    public Student() {
        this.salary = 500;
    }

    public Student(String name, int age, int cnp) {
        super(name, age, cnp, 500);
    }
}
