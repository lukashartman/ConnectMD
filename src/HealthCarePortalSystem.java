import com.sun.org.apache.xml.internal.security.utils.JavaUtils;
import javafx.scene.control.Alert;
import java.util.Date;

public class HealthCarePortalSystem extends Main
{
    AuthenticationSystem authenticationSystem;



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
        Date dob;
        // retrieve login credential strings from text fields in pane
        // initialize full name and date of birth

        boolean status = false;
        String firstName = " ";
        String lastName = " ";
        dob = new Date(1, 1, 1);

        status = authenticationSystem.loginPatient(firstName, lastName, dob); // patient login request; returns status (yes or no)
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
