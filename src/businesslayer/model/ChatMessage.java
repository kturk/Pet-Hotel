package businesslayer.model;

import javax.xml.bind.annotation.*;

public class ChatMessage {

    private static Integer count = 1;
    @XmlID
    private String id;
    @XmlElement
    private String sender;
    @XmlElement
    private String message;

    public ChatMessage() {
        this.id = count.toString();
        count++;
        this.sender = "a";
        this.message = "b";
    }

    public ChatMessage(String sender, String message) {
        this.id = count.toString();
        count++;
        this.sender = sender;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

}
