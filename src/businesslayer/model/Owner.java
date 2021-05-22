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
}
