package org.example.persons;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private int cnp;
    protected int salary;

    public Person(){
    }
    public Person(String name, int age,int cnp,int salary) {
        this.name = name;
        this.age = age;
        this.cnp = cnp;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCnp() {
        return cnp;
    }

    public int getSalary() {
        return salary;
    }
    public void printNameAndAge(){
        System.out.println(this.name + " " + this.age);
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        return cnp == person.cnp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cnp=" + cnp +
                ", salary=" + salary +
                '}';
    }
}
