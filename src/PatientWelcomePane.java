import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;
import javafx.scene.layout.*;

/**
 *
 * @author Noah
 */

public class PatientWelcomePane extends HBox {
    
    private Button viewPharmInfoButton, viewHealthButton, sendMessageButton, requestChangeButton, logOutButton;
    private Label helloLabelPatient, welcomeLabel;
    private String patientName = "";
    private ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C", "D", "E");
    
   
    public PatientWelcomePane() throws FileNotFoundException {
        helloLabelPatient = new Label("Hello, " + patientName);
        helloLabelPatient.getStyleClass().add("blueLabel");
        helloLabelPatient.setLayoutX(0);
        helloLabelPatient.setLayoutY(0);

        welcomeLabel = new Label("Welcome to ConnectMD");
        welcomeLabel.getStyleClass().add("blueLabel");
        welcomeLabel.setLayoutX(0);
        welcomeLabel.setLayoutY(0);

        //PATIENT BUTTONS
        logOutButton = new Button("Log Out");
        logOutButton.getStyleClass().add("blueLogOutButton");
        logOutButton.setLayoutX(0);
        logOutButton.setLayoutY(0);

        viewPharmInfoButton = new Button("View My Pharmacy Information");
        viewPharmInfoButton.getStyleClass().add("bluePatientInfoButton");
        viewPharmInfoButton.setLayoutX(0);
        viewPharmInfoButton.setLayoutY(0);

        viewHealthButton = new Button("View Health");
        viewHealthButton.getStyleClass().add("blueViewHealthButton");
        viewHealthButton.setLayoutX(0);
        viewHealthButton.setLayoutY(0);

        sendMessageButton = new Button("Send Message");
        sendMessageButton.getStyleClass().add("blueSendMessageButton");
        sendMessageButton.setLayoutX(0);
        sendMessageButton.setLayoutY(0);
        
        requestChangeButton = new Button("Request Change");
        requestChangeButton.getStyleClass().add("blueRequestChangeButton");
        requestChangeButton.setLayoutX(0);
        requestChangeButton.setLayoutY(0);

        //Set the background and children
      
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.getChildren().addAll(viewPharmInfoButton, viewHealthButton, sendMessageButton, requestChangeButton, helloLabelPatient, logOutButton);

        //ACTIONS
      
        viewPharmInfoButton.setOnAction(event -> SceneController.changeSceneTest());
        viewHealthButton.setOnAction(event -> SceneController.changeSceneTest());
        sendMessageButton.setOnAction(event -> SceneController.changeSceneTest());
        requestChangeButton.setOnAction(event -> SceneController.changeSceneTest());
        logOutButton.setOnAction(event -> SceneController.changeSceneTest());
        
    }
    
}
