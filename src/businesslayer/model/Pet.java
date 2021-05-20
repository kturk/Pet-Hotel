package businesslayer.model;

import java.util.ArrayList;
import java.util.List;

public class Pet {

    private String name;
    private int age;
    private List<OperationType> completedOperations;
    private List<OperationType> todoOperations;


    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
        this.completedOperations = new ArrayList<OperationType>();
        this.todoOperations = new ArrayList<OperationType>();
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

    public void cutNails(){
        this.completedOperations.add(OperationType.NAILS);
        System.out.println("cutted");
    }

    @Override
    public String toString() {
        return "Name = " + name + " -- " + "Age = " + age;
    }
}

