public class HealthcareSpecialistNode
{  //This class makes and fills the HealthcareSpecialist Node so that we can use it for the HealthcareSpecialist class

    //DECLARING VARIABLES
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String titleName; //what they want to be called by (RN or Dr)

    //CONSTRUCTOR
    public HealthcareSpecialistNode()
    {
        firstName = new String("");
        lastName = new String("");
        username = new String("");
        password = new String("");
        titleName = new String("");
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