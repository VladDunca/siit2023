package org.example.persons;

public class Hired extends Person{
    public Hired() {
        this.salary = 2000;
    }

    public Hired(String name, int age, int cnp, int salary) {
        super(name, age, cnp, salary);
    }
}
