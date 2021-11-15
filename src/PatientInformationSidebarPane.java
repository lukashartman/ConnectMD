import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.io.FileInputStream;

//This pane will be a VBox in nurseViewPatientVitalsPane

public class PatientInformationSidebarPane extends Pane {
    private Image patientPFP;
    private ImageView patientPFPView;
    private Label nameLabel, birthdayLabel, idLabel, pharmLabel, phonelabel, addressLabel, insuranceLabel;

    public PatientInformationSidebarPane() throws FileNotFoundException {

        //Set size of the sidebar across all calls to view it
        this.setPrefWidth(427);
        this.setPrefHeight(720);

        //LABELS
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

        pharmLabel = new Label("Pharmacy: " + Main.currentPatient.getPharmacyName() + " \n " +
                Main.currentPatient.getPharmacyAddress());
        pharmLabel.getStyleClass().add("sidebarSmallLabel");
        pharmLabel.setLayoutX(45);
        pharmLabel.setLayoutY(360);

        phonelabel = new Label("Phone: " + String.valueOf(Main.currentPatient.getPhoneNumber()));
        phonelabel.getStyleClass().add("sidebarSmallLabel");
        phonelabel.setLayoutX(45);
        phonelabel.setLayoutY(425);


        String[] dividedAddress = Main.currentPatient.getHomeAddress().split(",");
        addressLabel = new Label("Address: " + dividedAddress[0] + ", \n" + dividedAddress[1] + ", " + dividedAddress[2] + ", " + dividedAddress[3]);
        addressLabel.getStyleClass().add("sidebarSmallLabel");
        addressLabel.setLayoutX(45);
        addressLabel.setLayoutY(466);

        insuranceLabel = new Label("Insurance: " + Main.currentPatient.getInsuranceName() + " \n" +
                "ID: " + Main.currentPatient.getInsuranceID());
        insuranceLabel.getStyleClass().add("sidebarSmallLabel");
        insuranceLabel.setLayoutX(45);
        insuranceLabel.setLayoutY(531);

        this.setBackground(new Background(new BackgroundFill(Color.web("#659BFF"), null, null)));
        this.getChildren().addAll(nameLabel, birthdayLabel, idLabel, pharmLabel, phonelabel, addressLabel, insuranceLabel);
    }

}
