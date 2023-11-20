package task1;

public class Animal {
    private String name;
    public Animal(){

    }
    public Animal(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "task1.Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
