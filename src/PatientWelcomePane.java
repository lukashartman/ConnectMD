import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;
import javafx.scene.layout.*;

/**
 *
 * @author Noah
 */

public class PatientWelcomePane extends Pane {
    
    private Button viewPatientInfoButton, viewHealthButton, sendMessageButton, requestChangeButton, logOutButton,
            viewMessagesButton;
    private Label helloLabelPatient, welcomeLabel;
    private String patientName = "";
    private ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C", "D", "E");
    
   
    public PatientWelcomePane() throws FileNotFoundException {
        patientName = Main.currentPatient.getFirstName() + " " + Main.currentPatient.getLastName();


        helloLabelPatient = new Label("Hello, " + patientName);
        helloLabelPatient.getStyleClass().add("helloLabel");
        helloLabelPatient.setLayoutX(14);
        helloLabelPatient.setLayoutY(12);

        welcomeLabel = new Label("Welcome to ConnectMD");
        welcomeLabel.getStyleClass().add("welcomeLabel");
        welcomeLabel.setLayoutX(14);
        welcomeLabel.setLayoutY(36);

        //PATIENT BUTTONS
        logOutButton = new Button("Log Out");
        logOutButton.getStyleClass().add("logOutButton");
        logOutButton.setLayoutX(1130);
        logOutButton.setLayoutY(20);

        viewPatientInfoButton = new Button("View Patient Information");
        viewPatientInfoButton.getStyleClass().add("wideBlueButton");
        viewPatientInfoButton.setLayoutX(470);
        viewPatientInfoButton.setLayoutY(290);

        viewHealthButton = new Button("View Health History");
        viewHealthButton.getStyleClass().add("wideBlueButton");
        viewHealthButton.setLayoutX(470);
        viewHealthButton.setLayoutY(351);

        sendMessageButton = new Button("Send Provider Message");
        sendMessageButton.getStyleClass().add("wideBlueButton");
        sendMessageButton.setLayoutX(470);
        sendMessageButton.setLayoutY(413);

        viewMessagesButton = new Button("View Message");
        viewMessagesButton.getStyleClass().add("wideBlueButton");
        viewMessagesButton.setLayoutX(470);
        viewMessagesButton.setLayoutY(475);
        
        requestChangeButton = new Button("Request Change");
        requestChangeButton.getStyleClass().add("wideBlueButton");
        requestChangeButton.setLayoutX(470);
        requestChangeButton.setLayoutY(537);

        //Set the background and children
      
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.getChildren().addAll(viewPatientInfoButton, viewHealthButton, sendMessageButton, requestChangeButton,
                helloLabelPatient, welcomeLabel, logOutButton, viewMessagesButton);

        //ACTIONS
      
        viewPatientInfoButton.setOnAction(event -> HealthCarePortalSystem.showPatientInfoPane());
        logOutButton.setOnAction(event -> HealthCarePortalSystem.logOutUser());
        requestChangeButton.setOnAction(event -> HealthCarePortalSystem.showPatientProviderChangePane());
        sendMessageButton.setOnAction(event -> HealthCarePortalSystem.showPatientSendMessagesPane());
        viewMessagesButton.setOnAction(event -> HealthCarePortalSystem.showPatientViewMessagesPane());


        //TODO: the rest of these need to be mapped
        viewHealthButton.setOnAction(event -> HealthCarePortalSystem.changeSceneTest());

    }
    
}
