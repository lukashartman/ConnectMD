import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;

public class NurseViewPatientVitalsPane extends Pane {
    private Label vitalsLabel, helloLabel, weightLabel, poundsLabel, heightLabel, feetLabel, inchesLabel,
            bodyTempLabel, degreesLabel, bloodPressureLabel, mmHgLabel;
    private TextField weightField, heightFieldFt, heightFieldIn, bodyTempField,bloodPressureField;
    private Button backButton, nextButton;
    private String specialistNameAndTitle = "";
    private Pane rightPane;

    public NurseViewPatientVitalsPane() throws FileNotFoundException {
        specialistNameAndTitle = Main.currentHealthcareSpecialist.getTitleName();

        //Create right sidebar
        rightPane = new PatientInformationSidebarPane();
        rightPane.setLayoutX(852);
        rightPane.setLayoutY(0);

       //LABELS
        vitalsLabel = new Label("Vitals");
        vitalsLabel.getStyleClass().add("welcomeLabel");
        vitalsLabel.setLayoutX(14);
        vitalsLabel.setLayoutY(36);

        helloLabel = new Label("Hello, " + specialistNameAndTitle);
        helloLabel.getStyleClass().add("helloLabel");
        helloLabel.setLayoutX(14);
        helloLabel.setLayoutY(12);

        weightLabel = new Label("Weight");
        weightLabel.getStyleClass().add("textBoxTitleLabel");
        weightLabel.setLayoutX(202);
        weightLabel.setLayoutY(252);

        poundsLabel = new Label("Ibs.");
        poundsLabel.getStyleClass().add("textBoxUnitLabel");
        poundsLabel.setLayoutX(683);
        poundsLabel.setLayoutY(259);

        heightLabel = new Label("Height");
        heightLabel.getStyleClass().add("textBoxTitleLabel");
        heightLabel.setLayoutX(206);
        heightLabel.setLayoutY(312);

        feetLabel = new Label("ft.");
        feetLabel.getStyleClass().add("textBoxUnitLabel");
        feetLabel.setLayoutX(482);
        feetLabel.setLayoutY(319);

        inchesLabel = new Label("in.");
        inchesLabel.getStyleClass().add("textBoxUnitLabel");
        inchesLabel.setLayoutX(693);
        inchesLabel.setLayoutY(319);

        bodyTempLabel = new Label("Body Temperature");
        bodyTempLabel.getStyleClass().add("textBoxTitleLabel");
        bodyTempLabel.setLayoutX(38);
        bodyTempLabel.setLayoutY(372);

        degreesLabel = new Label("F.");
        degreesLabel.getStyleClass().add("textBoxUnitLabel");
        degreesLabel.setLayoutX(693);
        degreesLabel.setLayoutY(379);

        bloodPressureLabel = new Label("Blood Pressure");
        bloodPressureLabel.getStyleClass().add("textBoxTitleLabel");
        bloodPressureLabel.setLayoutX(81);
        bloodPressureLabel.setLayoutY(432);

        mmHgLabel = new Label("mmHg");
        mmHgLabel.getStyleClass().add("textBoxUnitLabel");
        mmHgLabel.setLayoutX(683);
        mmHgLabel.setLayoutY(439);

        //BUTTONS
        backButton = new Button("< Back");
        backButton.getStyleClass().add("smallBlueButton");
        backButton.setLayoutX(15);
        backButton.setLayoutY(656);

        nextButton = new Button("Next >");
        nextButton.getStyleClass().add("smallBlueButton");
        nextButton.setLayoutX(711);
        nextButton.setLayoutY(656);

        // TEXT FIELDS
        weightField = new TextField();
        weightField.getStyleClass().add("whiteTextField");
        weightField.setLayoutX(317);
        weightField.setLayoutY(252);
        weightField.setPrefWidth(361);
        weightField.setPrefHeight(30);

        heightFieldFt = new TextField();
        heightFieldFt.getStyleClass().add("whiteTextField");
        heightFieldFt.setLayoutX(317);
        heightFieldFt.setLayoutY(312);
        heightFieldFt.setPrefWidth(160);
        heightFieldFt.setPrefHeight(30);

        heightFieldIn = new TextField();
        heightFieldIn.getStyleClass().add("whiteTextField");
        heightFieldIn.setLayoutX(518);
        heightFieldIn.setLayoutY(312);
        heightFieldIn.setPrefWidth(160);
        heightFieldIn.setPrefHeight(30);

        bodyTempField = new TextField() ;
        bodyTempField.getStyleClass().add("whiteTextField");
        bodyTempField.setLayoutX(317);
        bodyTempField.setLayoutY(372);
        bodyTempField.setPrefWidth(361);
        bodyTempField.setPrefHeight(30);

        bloodPressureField = new TextField();
        bloodPressureField.getStyleClass().add("whiteTextField");
        bloodPressureField.setLayoutX(317);
        bloodPressureField.setLayoutY(432);
        bloodPressureField.setPrefWidth(361);
        bloodPressureField.setPrefHeight(30);

       this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
       this.getChildren().addAll(vitalsLabel, helloLabel, weightLabel, poundsLabel, heightLabel, feetLabel, inchesLabel,
               bodyTempLabel, degreesLabel, bloodPressureLabel, mmHgLabel, weightField, heightFieldFt, heightFieldIn, bodyTempField,
               bloodPressureField, backButton, nextButton, rightPane);

        backButton.setOnAction(event -> HealthCarePortalSystem.showSpecialistWelcomePane());
        nextButton.setOnAction(event -> HealthCarePortalSystem.enterPatientVitals(Float.parseFloat(weightField.getText()),
                Float.parseFloat(bodyTempField.getText()), Integer.parseInt(heightFieldFt.getText()),
                Integer.parseInt(heightFieldIn.getText()), bloodPressureField.getText()));
    }
}
