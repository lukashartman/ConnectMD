import javafx.scene.control.Alert;

public class HealthCarePortalSystem extends Main
{
    AuthenticationSystem authenticationSystem = new AuthenticationSystem();


    public static void changeSceneTest()
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("This is where we change the scene");
        //alert.setContentText("Careful with the next step!");

        alert.showAndWait();
    }

    public void loginPatient()
    {
        boolean status;
        String firstName;
        String lastName;
        String dob;

        status = authenticationSystem.loginPatient(firstName, lastName, dob); //patient login request; returns status (yes or no)
    }

    public void loginSpecialist()
    {
        boolean status;
        String userName;
        String password;

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
