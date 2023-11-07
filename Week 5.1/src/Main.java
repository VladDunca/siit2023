import task2.Hired;
import task2.Person;
import task2.Student;
import task2.Unemployed;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int sumDiagonal = 0;
//        int[][] myMatrix = new int[5][5];
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                myMatrix[i][j] = i + 1;
//            }
//        }
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(myMatrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        for (int i = 0; i < 5; i++) {
//            sumDiagonal += myMatrix[i][i];
//        }
//        System.out.println(sumDiagonal);

//        task1.Animal[] animals = {new task1.Animal("Caine"),new task1.Animal("Pisica"),new task1.Animal("Capybara")};
//        for (task1.Animal animal:animals){
//            System.out.print(animal.getName() + " ");
//        }

//        Person[] people = {new Unemployed("Andrei"),new Hired("Adrian",2000),new Student("Valentin",500)};
//        for (Person person:people){
//            System.out.println(person.getName());
//        }
//
//        List<Person> personList = new LinkedList<>(List.of(new Unemployed("Mihai"),new Hired("Cristian",2300),new Student("George",450)));
//        for (Person person:personList){
//            System.out.println(person.getName());
//        }

        Map<String,Person> personMap = new HashMap<>(Map.of("Mita",new Unemployed("Mihai"),"Cristi",new Hired("Cristian",2300),"Gigi",new Student("George",450)));
        for (Map.Entry<String,Person> entry : personMap.entrySet()){
            System.out.println(entry);
        }
    }
}