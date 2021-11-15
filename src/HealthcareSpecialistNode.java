import java.util.ArrayList;

public class HealthcareSpecialistNode {  //This class makes and fills the HealthcareSpecialist Node so that we can use it for the HealthcareSpecialist class

    //DECLARING VARIABLES
    private String providerID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String titleName; //what they want to be called by (RN or Dr) with name (ex. Dr. Smith)
    private String type;
    private ArrayList<PatientNode> patientIDs; //list of patient IDs that they are assigned to
    private ArrayList<String> nurseIDs;

    //CONSTRUCTOR
    public HealthcareSpecialistNode(String newProviderID, String newFirstName, String newLastName, String newUsername, String newPassword, String newTitleName, String newType) {
        providerID = newProviderID;
        firstName = newFirstName;
        lastName = newLastName;
        username = newUsername;
        password = newPassword;
        titleName = newTitleName;
        type = newType;
        patientIDs = new ArrayList<PatientNode>();
        nurseIDs = new ArrayList<String>();
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
    public ArrayList<PatientNode> getPatientIDs(){return patientIDs;}
    public ArrayList<String> getNurseIDS(){ return nurseIDs;}
    public String getType(){return type;}


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
    public void addNurseID(String IDtoAdd){nurseIDs.add(IDtoAdd);}
    public void addPatient(PatientNode patient){patientIDs.add(patient);}
}