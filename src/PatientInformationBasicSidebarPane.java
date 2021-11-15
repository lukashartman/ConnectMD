import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//This pane will be a VBox in nurseViewPatientVitalsPane

public class PatientInformationBasicSidebarPane extends Pane {
    private Image patientPFP;
    private ImageView patientPFPView;
    private Label nameLabel, birthdayLabel, idLabel;

    public PatientInformationBasicSidebarPane() throws FileNotFoundException {

        //Set size of the sidebar across all calls to view it
        this.setPrefWidth(427);
        this.setPrefHeight(720);

        //LABELS
        //TODO: center the nameLabel somehow?
        nameLabel = new Label(Main.currentPatient.getFirstName() + " " + Main.currentPatient.getLastName());
        nameLabel.getStyleClass().add("whiteLabel");
        nameLabel.setLayoutX(70);
        nameLabel.setLayoutY(187);

        birthdayLabel = new Label("DOB: " + Main.currentPatient.getBirthDate());
        birthdayLabel.getStyleClass().add("sidebarDOBID");
        birthdayLabel.setLayoutX(100);
        birthdayLabel.setLayoutY(235);

        idLabel = new Label("ID: " + Main.currentPatient.getPatientID());
        idLabel.getStyleClass().add("sidebarDOBID");
        idLabel.setLayoutX(114);
        idLabel.setLayoutY(277);

        FileInputStream inputstream = new FileInputStream("src/patImages/" + Main.currentPatient.getPatientID() + ".jpeg");
        patientPFP = new Image(inputstream);
        patientPFPView = new ImageView(patientPFP);
        patientPFPView.setFitWidth(158);
        patientPFPView.setFitHeight(158);
        patientPFPView.setLayoutX(134);
        patientPFPView.setLayoutY(12);

        this.setBackground(new Background(new BackgroundFill(Color.web("#659BFF"), null, null)));
        this.getChildren().addAll(patientPFPView, nameLabel, birthdayLabel, idLabel);
    }

}
