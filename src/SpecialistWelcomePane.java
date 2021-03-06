import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import java.io.FileNotFoundException;

public class SpecialistWelcomePane extends Pane{
    private Button viewPatientInfoButton, beginPatientVisitButton, viewAllMessagesButton, logOutButton;
    private Label helloLabel, welcomeLabel;
    private ComboBox selectPatient;
    private ObservableList<String> list = FXCollections.observableArrayList();

    public SpecialistWelcomePane() throws FileNotFoundException {


        //LABELS
        helloLabel = new Label("Hello, " + Main.currentHealthcareSpecialist.getTitleName());
        helloLabel.getStyleClass().add("helloLabel");
        helloLabel.setLayoutX(14);
        helloLabel.setLayoutY(12);

        welcomeLabel = new Label("Welcome to ConnectMD");
        welcomeLabel.getStyleClass().add("welcomeLabel");
        welcomeLabel.setLayoutX(14);
        welcomeLabel.setLayoutY(36);

        //BUTTONS
        logOutButton = new Button("Log Out");
        logOutButton.getStyleClass().add("logOutButton");
        logOutButton.setLayoutX(1130);
        logOutButton.setLayoutY(20);

        viewPatientInfoButton = new Button("View Patient Information");
        viewPatientInfoButton.getStyleClass().add("wideBlueButton");
        viewPatientInfoButton.setLayoutX(470);
        viewPatientInfoButton.setLayoutY(315);

        beginPatientVisitButton = new Button("Begin Patient Visit");
        beginPatientVisitButton.getStyleClass().add("wideBlueButton");
        beginPatientVisitButton.setLayoutX(470);
        beginPatientVisitButton.setLayoutY(376);

        viewAllMessagesButton = new Button("View All Messages");
        viewAllMessagesButton.getStyleClass().add("wideBlueButton");
        viewAllMessagesButton.setLayoutX(470);
        viewAllMessagesButton.setLayoutY(651);

        //COMBO BOX
        for (int i = 0; i < Main.patientList.size(); i++) {
            if (Main.currentHealthcareSpecialist.getPatientIDs().contains(Main.patientList.get(i))) {
                list.add(Main.patientList.get(i).getFirstName() + " " + Main.patientList.get(i).getLastName());
            }
        }

        selectPatient = new ComboBox(list);
        selectPatient.setValue("Select Patient");
        selectPatient.getStyleClass().add("selectPatientDropdown");
        selectPatient.setEditable(false);
        selectPatient.setLayoutX(364);
        selectPatient.setLayoutY(185);

        //Set the background and children
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.getChildren().addAll(viewAllMessagesButton,viewPatientInfoButton,beginPatientVisitButton,logOutButton,helloLabel, welcomeLabel,selectPatient);

        //Action Events

        if(Main.currentHealthcareSpecialist.getType().equals("Nurse")){
            beginPatientVisitButton.setOnAction(event -> HealthCarePortalSystem.showVitalsPane(selectPatient.getValue().toString()));
        } else {
            beginPatientVisitButton.setOnAction(event -> HealthCarePortalSystem.showPatientHealthHistoryPane(selectPatient.getValue().toString()));
        }

        viewAllMessagesButton.setOnAction(event -> HealthCarePortalSystem.showSpecialistMessagesPane());
        logOutButton.setOnAction(event -> HealthCarePortalSystem.logOutUser());
        viewPatientInfoButton.setOnAction(event -> HealthCarePortalSystem.showPatientHealthHistoryPane(selectPatient.getValue().toString()));

    }
}

