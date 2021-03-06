package businesslayer.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
public class Owner extends User{

    @XmlElementWrapper(name = "Pets")
    @XmlElement(name = "Pet")
//    @XmlIDREF
    private List<Pet> petList;

    @XmlElementWrapper(name="Chats")
    @XmlElement(name = "Chat")
//    @XmlIDREF
//    @XmlTransient
    private List<ChatMessage> chatMessages;

    public Owner() {
        super();
        this.petList = new ArrayList<Pet>();
        this.chatMessages = new ArrayList<ChatMessage>();
    }

    public Owner(String userName, String password) {
        super(userName, password);
        this.petList = new ArrayList<Pet>();
        this.chatMessages = new ArrayList<ChatMessage>();
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public void addNewPet(Pet pet){
        this.petList.add(pet);
    }

    public void removePet(Pet pet){
        this.petList.remove(pet);
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    public void addNewMessage(ChatMessage message) {
        chatMessages.add(message);
    }

    public Double getTotalDailyRentingPrice() {
        Double totalDailyRentingPrice = 0.0;
        for(Pet pet : petList){
            totalDailyRentingPrice += pet.getTotalRentCost();
        }
        return totalDailyRentingPrice;
    }

    public Double getTotalOperationsPrice() {
        Double totalOperationsPrice = 0.0;
        for(Pet pet : petList){
            totalOperationsPrice += pet.getCompletedOperationCost();
        }
        return totalOperationsPrice;
    }

    public Double getTotalOperationsExpense() {
        Double totalOperationsExpense = 0.0;
        for(Pet pet : petList){
            totalOperationsExpense += pet.getCompletedOperationExpense();
        }
        return totalOperationsExpense;
    }

    public Double getTotalDailyRentingExpense() {
        Double totalDailyRentingExpense = 0.0;
        for(Pet pet : petList){
            totalDailyRentingExpense += pet.getTotalRentExpense();
        }
        return totalDailyRentingExpense;
    }
}
