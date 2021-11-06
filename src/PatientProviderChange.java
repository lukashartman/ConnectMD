import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PatientProviderChange extends HBox {
    private Button backButton, submitAndFinishButton;
    private Pane changeOfProviderBackground, patientInformationBackground;
    private Label changeOfProviderLabel, helloLabel, patientNameLabel, dateOfBirthLabel, patientIdLabel, pharmacyLabel, phoneLabel, addressLabel, insuranceLabel;
    private ComboBox chooseNewProviderField;
    private TextField reasonField;
    private Image patientProfileImage;
    private ImageView patientProfileImageView;


    public PatientProviderChange() throws FileNotFoundException {
        //create variables that store patient information
        String patientName = "";
        String patientDOB = "";
        String patientID = "";
        String patientPharmacy = "";
        String patientPhone = "";
        String patientAddress= "";
        String patientInsurance = "";

        //create left side background
        changeOfProviderBackground = new Pane();
        changeOfProviderBackground.setPrefWidth(0);
        changeOfProviderBackground.getChildren().addAll(helloLabel, changeOfProviderLabel, chooseNewProviderField, reasonField,submitAndFinishButton, backButton);
        changeOfProviderBackground.setBackground(new Background (new BackgroundFill(Color.web("#FFFFFF"),null, null)));

        // create labels
        helloLabel = new Label("Hello, " + patientName);
        helloLabel.getStyleClass().add("blueLabel");
        helloLabel.setLayoutX(0);
        helloLabel.setLayoutY(0);

        changeOfProviderLabel = new Label("Request Change of Provider");
        changeOfProviderLabel.getStyleClass().add("blueLabel");
        changeOfProviderLabel.setLayoutX(0);
        changeOfProviderLabel.setLayoutY(0);

        //providers list
        String[] providers = {""};

        //create Combo box
        chooseNewProviderField = new ComboBox(FXCollections.observableList(providers));
        chooseNewProviderField.setValue("Message to:");
        chooseNewProviderField.setLayoutX(0);
        chooseNewProviderField.setLayoutY(0);

        //create text field
        reasonField = new TextField();
        reasonField.getStyleClass().add("blueLabel");
        reasonField.setPromptText("Reasons");
        reasonField.setLayoutX(0);
        reasonField.setLayoutY(0);

        //create Buttons
        backButton = new Button("Back");
        backButton.getStyleClass().add("blueLabel");
        backButton.setLayoutX(0);
        backButton.setLayoutY(0);

        submitAndFinishButton = new Button("Submit and Finish");
        submitAndFinishButton.getStyleClass().add("blueLabel");
        submitAndFinishButton.setLayoutX(0);
        submitAndFinishButton.setLayoutY(0);

        //create right sidebar
        patientInformationBackground = new Pane();
        patientInformationBackground.setPrefWidth(0);
        patientInformationBackground.getChildren().addAll(patientProfileImage, patientNameLabel, dateOfBirthLabel, patientIdLabel, pharmacyLabel, phoneLabel, addressLabel, insuranceLabel);
        patientInformationBackground.setBackground(new Background (new BackgroundFill(Color.web("#659BFF"),null, null)));

        //create labels
        //not sure if the patient information -name, DOB, etc. would be a label
        patientNameLabel = new Label (patientName);
        patientNameLabel.getStyleClass().add("whiteLabel");
        patientNameLabel.setLayoutX(0);
        patientNameLabel.setLayoutY(0);

        dateOfBirthLabel = new Label (patientDOB);
        dateOfBirthLabel.getStyleClass().add("whiteLabel");
        dateOfBirthLabel.setLayoutX(0);
        dateOfBirthLabel.setLayoutY(0);

        patientIdLabel = new Label (patientID);
        patientIdLabel.getStyleClass().add("whiteLabel");
        patientIdLabel.setLayoutX(0);
        patientIdLabel.setLayoutY(0);

        pharmacyLabel = new Label (patientPharmacy);
        pharmacyLabel.getStyleClass().add("whiteLabel");
        pharmacyLabel.setLayoutX(0);
        pharmacyLabel.setLayoutY(0);

        phoneLabel = new Label (patientPhone);
        phoneLabel.getStyleClass().add("whiteLabel");
        phoneLabel.setLayoutX(0);
        phoneLabel.setLayoutY(0);

        addressLabel = new Label (patientAddress);
        addressLabel.getStyleClass().add("whiteLabel");
        addressLabel.setLayoutX(0);
        addressLabel.setLayoutY(0);

        insuranceLabel = new Label(patientInsurance);
        insuranceLabel.getStyleClass().add("whiteLabel");
        insuranceLabel.setLayoutX(0);
        insuranceLabel.setLayoutY(0);

        //create patient image
        FileInputStream inputStream = new FileInputStream()
        patientProfileImage = new Image(InputStream);
        patientProfileImageView = new ImageView(patientProfileImage);
        patientProfileImageView.setFitWidth();
        patientProfileImageView.setFitHeight();
        patientProfileImageView.setLayoutX();
        patientProfileImageView.setLayoutY();

    }
}
