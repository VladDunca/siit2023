package task2;

public class Student extends Person{
    public Student(){
        this.name = "defaultName";
        this.salary = 500;
    }
    public Student(String name,double salary){
        this.name = name;
        this.salary = salary;
    }
}
