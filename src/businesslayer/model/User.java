package businesslayer.model;

import java.util.ArrayList;
import java.util.List;

public abstract class User{

    private static int count = 1;
    private int id;
    private String userName;
    private String password;
    private List<ChatMessage> chatMessages;
    // aunthentication with roles (hoteladmin, owner) cast later


    public User(String userName, String password) {
        this.id = count;
        count++;
        this.userName = userName;
        this.password = password;
        this.chatMessages = new ArrayList<ChatMessage>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "ID: " + id +
                " -- " + userName.toUpperCase();
    }
}
