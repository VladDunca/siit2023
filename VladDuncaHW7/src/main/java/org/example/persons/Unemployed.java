package org.example.persons;

public class Unemployed extends Person{
    public Unemployed() {
        this.salary = 0;
    }

    public Unemployed(String name, int age, int cnp) {
        super(name, age, cnp, 0);
    }
}
