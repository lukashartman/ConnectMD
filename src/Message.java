import javafx.scene.control.*;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Random;

public class Message
{

    // to from will be string of specialist or patient id
    private String to = "";
    private String from = "";
    private String subject = "";
    private String body = "";
    private String messageID = "";

    //CONSTRUCTOR
    public Message(String toID, String fromID, String subject, String body) {
        this.to = toID;
        this.from = fromID;
        this.subject = subject;
        this.body = body;

        Random rnd = new Random();
        int n = 1000000 + rnd.nextInt(9999999);

        messageID = "M" + n;
    }

    public String getMessageSubject() {
        return subject;
    }

    public String getMessageBody() {
        return body;
    }

    public String getRecipientID(){
        return to;
    }

    public String getSenderID() {
        return from;
    }

    public String getMessageID(){
        return messageID;
    }

    public void setMessageSubject(String newSubject) {
        subject = newSubject;
    }

    public void setMessageBody(String newBody) {
        body = newBody;
    }

    public void setRecipientName(String newTo) {
        to = newTo;
    }

    public void setSenderName(String newFrom) {
        from = newFrom;
    }

}
