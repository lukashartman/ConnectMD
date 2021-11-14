import java.io.FileNotFoundException;
import java.util.Date;

public class HealthCarePortalSystem extends Main
{
    AuthenticationSystem authenticationSystem = new AuthenticationSystem();

    //Note: this method is just for Luke to play around with and will be
    // removed in the final version.
    public static void changeSceneTest() {
        try {
            mainPane.getChildren().removeAll();
            mainPane.getChildren().add(new PatientWelcomePane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            System.out.println("You broke it");
            e.printStackTrace();
        }

    }

    public void registerPatient()
    {
        Patient newPatient;

        String firstName = "";
        String lastName = "";
        String username = "";
        String password = "";
        String homeAddress = "";
        String pharmacyName = "";
        String pharmacyAddress = "";
        String insuranceName = "";
        String insuranceAddress = "";
        integer phoneNumber = 0;
        birthDate = new Date(2000,1,1);

        // get info that was entered into pane fields

        newPatient = new Patient(userName, password, firstName, lastName, homeAddress, pharmacyName, pharmacyAddress,
                insuranceName, phoneNumber, birthDate); // create and initialize all attributes of new patient

       patientList.add(newPatient); // add new patient to array list of type patient

    }

    public void loginPatient()
    {
        Date dob;

        boolean status = false;
        String firstName = " ";
        String lastName = " ";
        dob = new Date(2021,1,1);

        status = authenticationSystem.loginPatient(firstName, lastName, dob); //patient login request; returns status (yes or no)
    }

    public void loginSpecialist()
    {
        boolean status = false;
        String userName = " ";
        String password = " ";

        status = authenticationSystem.loginSpecialist(userName, password); //specialist login request; returns status (yes or no)
    }

    public void sendMessage()
    {

        Message newMessage;
        String to = " ";
        String from = " ";
        String subject = " ";
        String message = " ";

        /*
         get message contents from GUI fields and set local variable
         to = " ";
         from = " ";
          subject = " ";
         message = " ";
        */

        newMessage = new Message(to, from, subject, body); // creates new message with previously initialized members

        messages.add(1, newMessage); // adds message to head of Array List

    }

    public void viewMessage()
    {

        // get name of current user
        // ??? how to display all messages of one single user ???



    }

    public void editPatientInfoSpecialist()
    {


    }

    public void editPatientInfoPatient()
    {


    }

    public void viewPatientInfoSpecialist()
    {


    }

    public void viewPatientInfoPatient()
    {


    }

    public void viewVisitSummary()
    {

    }

    public void prescribeMedication()
    {

    }

    public void calculateDaysBetweenDates()
    {


    }

}