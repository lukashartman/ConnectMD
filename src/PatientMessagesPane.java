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



public class PatientMessagesPane extends HBox {
    private Pane messageProviderBackground, patientInformationBackground;
    private Button backButton, submitAndFinishButton;
    private Label msgProviderLabel, helloLabel, patientNameLabel, dateOfBirthLabel, patientIdLabel, pharmacyLabel, phoneLabel, addressLabel, insuranceLabel;
    private ComboBox msgToBox;
    private TextField subjectField, bodyField;
    private Image patientProfileImage;
    private ImageView patientProfileImageView;


    public PatientMessagesPane() throws FileNotFoundException {
        //create variables that store patient information
        String patientName = "";
        String patientDOB = "";
        String patientID = "";
        String patientPharmacy = "";
        String patientPhone = "";
        String patientAddress= "";
        String patientInsurance = "";


        //create left sidebar
        messageProviderBackground = new Pane();
        messageProviderBackground.setPrefWidth(0);
        messageProviderBackground.getChildren().addAll(helloLabel, msgProviderLabel, msgToBox, subjectField, bodyField, submitAndFinishButton, backButton );
        messageProviderBackground.setBackground(new Background (new BackgroundFill(Color.web("#FFFFFF"),null, null)));

        // create labels
        helloLabel = new Label("Hello, " + patientName);
        helloLabel.getStyleClass().add("blueLabel");
        helloLabel.setLayoutX(0);
        helloLabel.setLayoutY(0);

        msgProviderLabel = new Label("Message Provider");
        msgProviderLabel.getStyleClass().add("blueLabel");
        msgProviderLabel.setLayoutX(0);
        msgProviderLabel.setLayoutY(0);

        String[] receiver = {""};

        //create Combo box
        msgToBox = new ComboBox(FXCollections.observableList(receiver));
        msgToBox.setValue("Message to:");
        msgToBox.setLayoutX(0);
        msgToBox.setLayoutY(0);

        //create text fields
        subjectField = new TextField();
        subjectField.getStyleClass().add("blueLabel");
        subjectField.setPromptText("Subject");
        subjectField.setLayoutX(0);
        subjectField.setLayoutY(0);

        bodyField = new TextField();
        bodyField.getStyleClass().add("blueLabel");
        bodyField.setPromptText("Subject");
        bodyField.setLayoutX(0);
        bodyField.setLayoutY(0);

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

