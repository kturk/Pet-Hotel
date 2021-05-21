package businesslayer.model;

import java.util.ArrayList;
import java.util.List;

public class Owner extends User{

    private List<Pet> petList;
    private List<ChatMessage> chatMessages;

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
}
