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

        // get message contents from GUI fields

        newMessage = new Message(to, from, subject, body);

        messages.add(newMessage);

    }

    public void viewMessage()
    {


    }

    public void viewPatientInfo()
    {

    }

    public void prescribeMedication()
    {

    }


    public void calculateDaysBetweenDates()
    {


    }

}