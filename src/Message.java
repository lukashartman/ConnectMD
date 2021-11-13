import javafx.scene.control.*;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class Message {

    private ArrayList<String> patientIDs;
    private ArrayList<String> specialistIDs;
    // to from will be string of specialist or patient id
    private String to = "";
    private String from = "";
    private String subject = "";
    private String body = "";

    //CONSTRUCTOR
    public Message ()
    {
        to = new String();
        from = new String();
        subject = new String("");
        body = new String("");

    }



    public String getMessageSubject()
    {
        return subject;
    }
    public String getMessageBody()
    {
        return body;
    }
    public String getRecipientName(){return to;}
    public String getSenderName()
    {
        return from;
    }

    public void setMessageSubject(String newSubject)
    {
        subject = newSubject;
    }
    public void setMessageBody(String newBody)
    {
        body = newBody;
    }
    public void setRecipientName(String newTo)
    {
        to = newTo;
    }
    public void setSenderName(String newFrom)
    {
        from = newFrom;
    }



}
