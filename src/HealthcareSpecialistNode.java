import java.util.ArrayList;

public class HealthcareSpecialistNode {  //This class makes and fills the HealthcareSpecialist Node so that we can use it for the HealthcareSpecialist class

    //DECLARING VARIABLES
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String type;
    private String providerID;
    private String titleName; //what they want to be called by (RN or Dr) with name (ex. Dr. Smith)
    private ArrayList<String> patientIDs; //list of patient IDs that they are assigned to
    private ArrayList<String> nurseIDs;


    //TODO: type (as in doctor or nurse) and if they're a doctor add all their nurse's ID

    //CONSTRUCTOR
    public HealthcareSpecialistNode(String newFirstName, String newLastName, String newUsername, String newPassword, String titleName, String newType) {
        firstName = new String("");
        lastName = new String("");
        username = new String("");
        password = new String("");
        titleName = new String("");
        patientIDs = new ArrayList<String>();
        //TODO: if doctor, initialize nurseIDs
        // if nurse, leave array empty
    }

    //GETTERS AND SETTERS
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public String getTitleName(){return titleName;}
    public String getProviderID(){return providerID;}

    public String setFirstName()
    {
        return firstName;
    }
    public String setLastName()
    {
        return lastName;
    }
    public String setUsername()
    {
        return username;
    }
    public String setPassword()
    {
        return password;
    }
}