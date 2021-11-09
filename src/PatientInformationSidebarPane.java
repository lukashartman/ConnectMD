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

    public PatientInformationSidebarPane(String patientID) throws FileNotFoundException {

        //Set size of the sidebar across all calls to view it
        this.setPrefWidth(427);
        this.setPrefHeight(720);

        //LABELS
        //TODO: for all these elements, grab the correct patient information using the patientID passed into here
        nameLabel = new Label("Amanda Weiler");
        nameLabel.getStyleClass().add("whiteLabel");
        nameLabel.setLayoutX(70);
        nameLabel.setLayoutY(187);

        birthdayLabel = new Label("DOB: " + "10/20/2000");
        birthdayLabel.getStyleClass().add("sidebarDOBID");
        birthdayLabel.setLayoutX(100);
        birthdayLabel.setLayoutY(235);

        idLabel = new Label("ID: " + patientID);
        idLabel.getStyleClass().add("sidebarDOBID");
        idLabel.setLayoutX(114);
        idLabel.setLayoutY(277);

        pharmLabel = new Label("Pharmacy: CVS Pharmacy \n " +
                "909 E Apache Blvd, Tempe, AZ 85281");
        pharmLabel.getStyleClass().add("sidebarSmallLabel");
        pharmLabel.setLayoutX(45);
        pharmLabel.setLayoutY(360);

        phonelabel = new Label("Phone: 480-694-5998");
        phonelabel.getStyleClass().add("sidebarSmallLabel");
        phonelabel.setLayoutX(45);
        phonelabel.setLayoutY(425);

        addressLabel = new Label("Address: 3951 Dye Street, \n" +
                "Phoenix,AZ, 85024");
        addressLabel.getStyleClass().add("sidebarSmallLabel");
        addressLabel.setLayoutX(45);
        addressLabel.setLayoutY(466);

        insuranceLabel = new Label("Insurance: Blue Cross Blue Shield \n" +
                "ID: DZW92000000");
        insuranceLabel.getStyleClass().add("sidebarSmallLabel");
        insuranceLabel.setLayoutX(45);
        insuranceLabel.setLayoutY(531);

        FileInputStream inputstream = new FileInputStream("src/logo.png");
        patientPFP = new Image(inputstream);
        patientPFPView = new ImageView(patientPFP);
        patientPFPView.setFitWidth(158);
        patientPFPView.setFitHeight(158);
        patientPFPView.setLayoutX(134);
        patientPFPView.setLayoutY(12);

        this.setBackground(new Background(new BackgroundFill(Color.web("#659BFF"), null, null)));
        this.getChildren().addAll(patientPFPView, nameLabel, birthdayLabel, idLabel, pharmLabel, phonelabel, addressLabel, insuranceLabel);
    }

}
