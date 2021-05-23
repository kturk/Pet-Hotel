package businesslayer.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlSeeAlso({Cat.class, Dog.class})
public abstract class Pet {

    private static Integer count = 1;
    @XmlID
    private String id;
    private String name;
    private int age;
    private int numOfDays;

    @XmlElementWrapper(name = "CompletedOperations")
    @XmlElement(name = "CompletedOperation")
//    @XmlTransient
    private List<OperationType> completedOperations;

    @XmlElementWrapper(name = "ToDoOperations")
    @XmlElement(name = "ToDoOperation")
//    @XmlTransient
    private List<OperationType> todoOperations;

    public Pet() {
        this.id = count.toString();
        count++;
        this.name = "";
        this.age = -1;
        this.completedOperations = new ArrayList<OperationType>();
        this.todoOperations = new ArrayList<OperationType>();
        this.numOfDays = -1;
    }

    public Pet(String name, int age, int numOfDays) {
        this.id = count.toString();
        count++;
        this.name = name;
        this.age = age;
        this.completedOperations = new ArrayList<OperationType>();
        this.todoOperations = new ArrayList<OperationType>();
        this.numOfDays = numOfDays;
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

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public void addTodoOperation(OperationType operationType) {
        todoOperations.add(operationType);
    }

    public void removeTodoOperation(OperationType operationType) {
        todoOperations.remove(operationType);
    }

    public List<OperationType> getCompletedOperations() {
        return completedOperations;
    }

    public List<OperationType> getTodoOperations() {
        return todoOperations;
    }

    public void cutNails(){
        todoOperations.remove(OperationType.NAILS);
        completedOperations.add(OperationType.NAILS);
    }

    public void bath(){
        todoOperations.remove(OperationType.BATH);
        completedOperations.add(OperationType.BATH);
    }

    public void shave(){
        todoOperations.remove(OperationType.SHAVE);
        completedOperations.add(OperationType.SHAVE);
    }

    public void dentalCare(){
        todoOperations.remove(OperationType.DENTAL_CARE);
        completedOperations.add(OperationType.DENTAL_CARE);
    }

    public void vaccination(){
        todoOperations.remove(OperationType.VACCINATION);
        completedOperations.add(OperationType.VACCINATION);
    }

    public void undoCutNails(){
        completedOperations.remove(OperationType.NAILS);
        todoOperations.add(OperationType.NAILS);
    }

    public void undoBath(){
        completedOperations.remove(OperationType.BATH);
        todoOperations.add(OperationType.BATH);
    }

    public void undoShave(){
        completedOperations.remove(OperationType.SHAVE);
        todoOperations.add(OperationType.SHAVE);
    }

    public void undoDentalCare(){
        completedOperations.remove(OperationType.DENTAL_CARE);
        todoOperations.add(OperationType.DENTAL_CARE);
    }

    public void undoVaccination(){
        completedOperations.remove(OperationType.VACCINATION);
        todoOperations.add(OperationType.VACCINATION);
    }

    public abstract double getCompletedOperationCost();

    public abstract double getEstimatedOperationCost();

    public abstract double getCompletedOperationExpense();

    public abstract double getTotalRentCost();

    public abstract double getTotalRentExpense();

    @Override
    public String toString() {
        return "Name = " + name + "    " + "Age = " + age + "    " + "Days = " + numOfDays+ "    " + "Remaining Operations = " + todoOperations.size();
    }
}

