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


public class SpecialistWelcomePane {
    private Button viewPatientInfoButton, beginPatientVisitButton, viewAllMessagesButton, logOutButton;
    private Label helloLabelDr, helloLabelNurse, welcomeLabel;
    private ComboBox selectPatient;
    private String specialistName = "";
    private ObservableList<String> list = FXCollections.observableArrayList("A","B","C");

    public SpecialistWelcomePane() throws FileNotFoundException {
        //LABELS
        helloLabelDr = new Label("Hello, Dr. " + specialistName);
        helloLabelDr.getStyleClass().add("blueLabel");
        helloLabelDr.setLayoutX(0);
        helloLabelDr.setLayoutY(0);

        helloLabelNurse = new Label("Hello, " + specialistName + "R.N.");
        helloLabelNurse.getStyleClass().add("blueLabel");
        helloLabelNurse.setLayoutX(0);
        helloLabelNurse.setLayoutY(0);

        welcomeLabel = new Label("Welcome to ConnectMD");
        welcomeLabel.getStyleClass().add("blueLabel");
        welcomeLabel.setLayoutX(0);
        welcomeLabel.setLayoutY(0);

        //BUTTONS
        logOutButton = new Button("Log Out");
        logOutButton.getStyleClass().add("blueLogOutButton");
        logOutButton.setLayoutX(0);
        logOutButton.setLayoutY(0);

        viewPatientInfoButton = new Button("View Patient Information");
        viewPatientInfoButton.getStyleClass().add("bluePatientInfoButton");
        viewPatientInfoButton.setLayoutX(0);
        viewPatientInfoButton.setLayoutY(0);

        beginPatientVisitButton = new Button("Begin Patient Visit");
        beginPatientVisitButton.getStyleClass().add("blueBeginVisitButton");
        beginPatientVisitButton.setLayoutX(0);
        beginPatientVisitButton.setLayoutY(0);

        viewAllMessagesButton = new Button("View All Messages");
        viewAllMessagesButton.getStyleClass().add("blueViewMessageButton");
        viewAllMessagesButton.setLayoutX(0);
        viewAllMessagesButton.setLayoutY(0);

        //COMBO BOX
        selectPatient = new ComboBox(list);
        selectPatient.setValue("Select Patient");
        selectPatient.setLayoutX(0);
        selectPatient.setLayoutY(0);

        //Set the background and children
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.getChildren().addAll(viewAllMessagesButton,viewPatientInfoButton,beginPatientVisitButton,logOutButton,helloLabelDr,helloLabelNurse,selectPatient);

        //Action Events
        viewAllMessagesButton.setOnAction(event -> SceneController.changeSceneTest());
        viewPatientInfoButton.setOnAction(event -> SceneController.changeSceneTest());
        beginPatientVisitButton.setOnAction(event -> SceneController.changeSceneTest());
        logOutButton.setOnAction(event -> SceneController.changeSceneTest());
    }
}

