package businesslayer.controller.ownercontrollers;

import businesslayer.Mediator;
import businesslayer.model.*;
import presentationlayer.ownerscreens.OwnerMessagesScreen;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnerMessagesController {

    private final Owner ownerModel;
    private final OwnerMessagesScreen ownerMessagesView;
    private final Mediator mediator;

    public OwnerMessagesController(
            Owner ownerModel, OwnerMessagesScreen ownerMessagesView, Mediator mediator)
    {
        this.ownerModel = ownerModel;
        this.ownerMessagesView = ownerMessagesView;
        this.mediator = mediator;

        this.ownerMessagesView.setChatScreenDocument(getChatMessagesAsDocument());

        ownerMessagesView.addSendButtonListener(new SendButtonListener());
        ownerMessagesView.addBackButtonListener(new BackButtonListener());
    }

    public StyledDocument getChatMessagesAsDocument() {
        StyledDocument doc = new DefaultStyledDocument();

        SimpleAttributeSet left = getAttributeSet("left");
        SimpleAttributeSet right = getAttributeSet("right");

        for (ChatMessage message : ownerModel.getChatMessages())
            try
            {
                if (isSenderHotelAdmin(message)) {
                    doc.insertString(doc.getLength(), message.getMessage(), left);
                    doc.setParagraphAttributes(doc.getLength(), 1, left, false);
                }
                else{
                    doc.insertString(doc.getLength(), message.getMessage(), right);
                    doc.setParagraphAttributes(doc.getLength(), 1, right, false);
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
        ownerMessagesView.showScreen();
    }

    public void closeView() {
        ownerMessagesView.closeScreen();
    }


    class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String newMessage = "\n" + ownerMessagesView.getNewMessageField().getText();
            if(newMessage.length() > 1){
                ownerModel.addNewMessage(new ChatMessage("Owner", newMessage));
                ownerMessagesView.setChatScreenDocument(getChatMessagesAsDocument());
                ownerMessagesView.setNewMessageField("");
                mediator.writeXML();
            }
            else
                ownerMessagesView.showError("Please enter a message!");

        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            closeView();
            mediator.navigateToOwnerMainScreen();
        }
    }
}
