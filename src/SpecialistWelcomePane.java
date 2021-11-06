import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;
import javafx.scene.layout.*;


public class SpecialistWelcomePane {
    private Button viewPatientInfoButton, beginPatientVisitButton, viewAllMessagesButton, logOutButton;
    private Label helloLabelDr, helloLabelNurse, welcomeLabel;
    private ComboBox selectPatient;
    private Pane background;
    private String specialistName = "";
    //private Array<PatientNames> namesList; //array of patient names for combo box

    public SpecialistWelcomePane() throws FileNotFoundException {
        //LABELS
        helloLabelDr = new Label("Hello, Dr. " + specialistName);
        helloLabelDr.getStyleClass().add("blueLabel");
        // helloLabelDr.setLayoutX();
        // helloLabelDr.setLayoutY();

        helloLabelNurse = new Label("Hello, " + specialistName + "R.N.");
        helloLabelNurse.getStyleClass().add("blueLabel");
        // helloLabelNurse.setLayoutX();
        // helloLabelNurse.setLayoutY();

        welcomeLabel = new Label("Welcome to ConnectMD");
        welcomeLabel.getStyleClass().add("blueLabel");
        //welcomeLabel.setLayoutX();
        //welcomeLabel.setLayoutY();

        //BUTTONS
        logOutButton = new Button("Log Out");
        logOutButton.getStyleClass().add("blueLogOutButton");
        //logOutButton.setLayoutX();
        //logOutButton.setLayoutY();

        viewPatientInfoButton = new Button("View Patient Information");
        viewPatientInfoButton.getStyleClass().add("bluePatientInfoButton");
        //viewPatientInfoButton.setLayoutX();
        //viewPatientInfoButton.setLayoutY();

        beginPatientVisitButton = new Button("Begin Patient Visit");
        beginPatientVisitButton.getStyleClass().add("blueBeginVisitButton");
        //beginPatientVisitButton.setLayoutX();
        //beginPatientVisitButton.setLayoutY();

        viewAllMessagesButton = new Button("View All Messages");
        viewAllMessagesButton.getStyleClass().add("blueViewMessageButton");
        //viewAllMessagesButton.setLayoutX();
        //viewAllMessagesButton.setLayoutY();

        //COMBO BOX
       // namesList = new Array<PatientNames>();
       // selectPatient = new ComboBox(namesList);
        selectPatient.setValue("Select Patient");
        //selectPatient.setLayoutX();
        //selectPatient.setLayoutY();

        //Set the background and children
        //this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        //this.getChildren().addAll(viewAllMessagesButton,viewPatientInfoButton,beginPatientVisitButton,logOutButton,helloLabelDr,helloLabelNurse,selectPatient);

        //Action Events
        viewAllMessagesButton.setOnAction(event -> SceneController.changeSceneTest());
        viewPatientInfoButton.setOnAction(event -> SceneController.changeSceneTest());
        beginPatientVisitButton.setOnAction(event -> SceneController.changeSceneTest());
        logOutButton.setOnAction(event -> SceneController.changeSceneTest());
    }
}

