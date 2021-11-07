import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//This pane will be a VBox in nurseViewPatientVitalsPane

public class PatientInfoSideBarPane extends Pane {
    private Image patientPFP;
    private Label nameLabel, birthdayLabel, idLabel, pharmLabel, phonelabel, addressLabel, insuranceLabel;

    public PatientInfoSideBarPane(String patientID) throws FileNotFoundException {
        //LABELS
        //TODO: for all these elements, grab the correct patient information using the patientID passed into here
        nameLabel = new Label("Amanda Weiler");
        nameLabel.getStyleClass().add("whiteLabel");
        nameLabel.setLayoutX(0);
        nameLabel.setLayoutY(0);

        birthdayLabel = new Label("10/20/2000");
        birthdayLabel.getStyleClass().add("whiteLabel");
        birthdayLabel.setLayoutX(0);
        birthdayLabel.setLayoutY(0);

        idLabel = new Label("P44924663");
        idLabel.getStyleClass().add("whiteLabel");
        idLabel.setLayoutX(0);
        idLabel.setLayoutY(0);

        pharmLabel = new Label("Pharmacy: CVS Pharmacy /n " +
                "909 E Apache Blvd, Tempe, AZ 85281");
        pharmLabel.getStyleClass().add("whiteLabel");
        pharmLabel.setLayoutX(0);
        pharmLabel.setLayoutY(0);

        phonelabel = new Label("480-694-5998");
        phonelabel.getStyleClass().add("whiteLabel");
        phonelabel.setLayoutX(0);
        phonelabel.setLayoutY(0);

        addressLabel = new Label("Address: 3951 Dye Street, /n" +
                "Phoenix,AZ, 85024");
        addressLabel.getStyleClass().add("whiteLabel");
        addressLabel.setLayoutX(0);
        addressLabel.setLayoutY(0);


        insuranceLabel = new Label("Insurance = Blue Cross Blue Shield /n" +
                "ID: DZW92000000");
        insuranceLabel.getStyleClass().add("whiteLabel");
        insuranceLabel.setLayoutX(0);
        insuranceLabel.setLayoutY(0);

        this.setBackground(new Background(new BackgroundFill(Color.web("#659BFF"), null, null)));
        this.getChildren().addAll(nameLabel, birthdayLabel, idLabel, pharmLabel, phonelabel, addressLabel, insuranceLabel);
    }

}
