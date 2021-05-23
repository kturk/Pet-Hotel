package businesslayer.controller.hoteladmincontrollers;

import businesslayer.Mediator;
import businesslayer.model.ChatMessage;
import businesslayer.model.Owner;
import presentationlayer.hoteladminscreens.ChatWithOwnerScreen;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWithOwnerController {

    private final Owner ownerModel;
    private final ChatWithOwnerScreen chatWithOwnerView;
    private final Mediator mediator;

    public ChatWithOwnerController(
            Owner ownerModel, ChatWithOwnerScreen chatWithOwnerView, Mediator mediator)
    {
        this.ownerModel = ownerModel;
        this.chatWithOwnerView = chatWithOwnerView;
        this.mediator = mediator;

        this.chatWithOwnerView.setChatScreenDocument(getChatMessagesAsDocument());

        chatWithOwnerView.setOwnerName(ownerModel.getUserName().toUpperCase());
        chatWithOwnerView.addSendButtonListener(new SendButtonListener());
        chatWithOwnerView.addBackButtonListener(new BackButtonListener());
    }

    public StyledDocument getChatMessagesAsDocument() {
        StyledDocument doc = new DefaultStyledDocument();

        SimpleAttributeSet left = getAttributeSet("left");
        SimpleAttributeSet right = getAttributeSet("right");

        for (ChatMessage message : ownerModel.getChatMessages())
            try
            {
                if (isSenderHotelAdmin(message)) {
                    doc.insertString(doc.getLength(), message.getMessage(), right);
                    doc.setParagraphAttributes(doc.getLength(), 1, right, false);
                }
                else{
                    doc.insertString(doc.getLength(), message.getMessage(), left);
                    doc.setParagraphAttributes(doc.getLength(), 1, left, false);
                }
            }
            catch(Exception e) { System.out.println(e); }
        return doc;
    }

    private SimpleAttributeSet getAttributeSet(String alignment) {
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        if (alignment.equals("left")) {
            StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_LEFT);
            StyleConstants.setForeground(attributeSet, Color.RED);
        }
        else {
            StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_RIGHT);
            StyleConstants.setForeground(attributeSet, Color.BLUE);
        }
        return attributeSet;
    }

    private boolean isSenderHotelAdmin(ChatMessage message) {
        return message.getSender().equals("HotelAdmin");
    }

    public void showView() {
        chatWithOwnerView.showScreen();
    }

    public void closeView() {
        chatWithOwnerView.closeScreen();
    }


    class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String newMessage = "\n" + chatWithOwnerView.getNewMessageField().getText();
            if(newMessage.length() > 1){
                ownerModel.addNewMessage(new ChatMessage("HotelAdmin", newMessage));
                chatWithOwnerView.setChatScreenDocument(getChatMessagesAsDocument());
                chatWithOwnerView.clearNewMessageField();
                mediator.writeXML();
            }
            else
                chatWithOwnerView.showError("Please enter a message!");
        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToAdminMessagesScreen();
        }
    }
}
