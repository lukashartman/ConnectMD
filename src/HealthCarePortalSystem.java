import java.io.FileNotFoundException;

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

    public void loginPatient()
    {
        boolean status = false;
        String firstName = "Null";
        String lastName = "Null";
        String dob = "Null";

        status = authenticationSystem.loginPatient(firstName, lastName, dob); //patient login request; returns status (yes or no)
    }

    public void loginSpecialist()
    {
        boolean status = false;
        String userName = "Null";
        String password = "Null";

        status = authenticationSystem.loginSpecialist(userName, password); //specialist login request; returns status (yes or no)
    }

    public void sendMessage()
    {



    }

    public void viewMessage()
    {



    }

    public void calculateDaysBetweenDates()
    {


    }

}