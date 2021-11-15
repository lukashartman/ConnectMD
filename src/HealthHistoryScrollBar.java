import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HealthHistoryScrollBar extends Pane {
    private Label physicalExamLabel, weightLabel, heightLabel, bodyTempLabel,
            bloodPressureLabel, allergiesLabel, medicationsLabel, immunizationsLabel, notesLabel, poundsLabel,
            inchesLabel, feetLabel, degreesLabel, mmHgLabel, healthIssuesLabel;
    private Button newPrescriptionButton;
    private TextField physicalExamField, weightField, heightFieldInField, heightFieldFtField, bodyTempField,
            bloodPressureField, allergiesField, medicationsField, immunizationsField, notesField, healthIssuesField;

    public HealthHistoryScrollBar() {
        physicalExamLabel = new Label("Physical Exam");
        physicalExamLabel.getStyleClass().add("textBoxTitleLabel");
        physicalExamLabel.setLayoutX(98);
        physicalExamLabel.setLayoutY(103);

        weightLabel = new Label("Weight");
        weightLabel.getStyleClass().add("textBoxTitleLabel");
        weightLabel.setLayoutX(203);
        weightLabel.setLayoutY(295);

        heightLabel = new Label("Height");
        heightLabel.getStyleClass().add("textBoxTitleLabel");
        heightLabel.setLayoutX(207);
        heightLabel.setLayoutY(355);

        feetLabel = new Label("ft.");
        feetLabel.getStyleClass().add("textBoxUnitLabel");
        feetLabel.setLayoutX(517);
        feetLabel.setLayoutY(362);

        inchesLabel = new Label("in.");
        inchesLabel.getStyleClass().add("textBoxUnitLabel");
        inchesLabel.setLayoutX(736);
        inchesLabel.setLayoutY(360);

        bodyTempLabel = new Label("Body Temperature");
        bodyTempLabel.getStyleClass().add("textBoxTitleLabel");
        bodyTempLabel.setLayoutX(39);
        bodyTempLabel.setLayoutY(415);

        bloodPressureLabel = new Label("Blood Pressure");
        bloodPressureLabel.getStyleClass().add("textBoxTitleLabel");
        bloodPressureLabel.setLayoutX(82);
        bloodPressureLabel.setLayoutY(475);

        allergiesLabel = new Label("Allergies");
        allergiesLabel.getStyleClass().add("textBoxTitleLabel");
        allergiesLabel.setLayoutX(74);
        allergiesLabel.setLayoutY(578);

        healthIssuesLabel = new Label("Health Issues");
        healthIssuesLabel.getStyleClass().add("textBoxTitleLabel");
        healthIssuesLabel.setLayoutX(109);
        healthIssuesLabel.setLayoutY(660);

        medicationsLabel = new Label("Medications");
        medicationsLabel.getStyleClass().add("textBoxTitleLabel");
        medicationsLabel.setLayoutX(127);
        medicationsLabel.setLayoutY(824);

        immunizationsLabel = new Label("Immunizations");
        immunizationsLabel.getStyleClass().add("textBoxTitleLabel");
        immunizationsLabel.setLayoutX(92);
        immunizationsLabel.setLayoutY(985);

        notesLabel = new Label("Notes");
        notesLabel.getStyleClass().add("textBoxTitleLabel");
        notesLabel.setLayoutX(218);
        notesLabel.setLayoutY(1149);

        poundsLabel = new Label("lbs.");
        poundsLabel.getStyleClass().add("textBoxUnitLabel");
        poundsLabel.setLayoutX(736);
        poundsLabel.setLayoutY(302);

        degreesLabel = new Label("F.");
        degreesLabel.getStyleClass().add("textBoxUnitLabel");
        degreesLabel.setLayoutX(736);
        degreesLabel.setLayoutY(418);

        mmHgLabel = new Label("mmHg");
        mmHgLabel.getStyleClass().add("textBoxUnitLabel");
        mmHgLabel.setLayoutX(736);
        mmHgLabel.setLayoutY(476);

        //BUTTON
        newPrescriptionButton = new Button("New Prescription");
        newPrescriptionButton.getStyleClass().add("smallBlueButton");
        newPrescriptionButton.setLayoutX(123);
        newPrescriptionButton.setLayoutY(860);
        newPrescriptionButton.setMaxWidth(185);

        //TEXT FIELDS
        weightField = new TextField();
        weightField.getStyleClass().add("whiteTextField");
        weightField.setLayoutX(323);
        weightField.setLayoutY(295);
        weightField.setPrefWidth(406);
        weightField.setPrefHeight(36);

        physicalExamField = new TextField();
        physicalExamField.getStyleClass().add("whiteTextField");
        physicalExamField.setLayoutX(328);
        physicalExamField.setLayoutY(103);
        physicalExamField.setPrefWidth(450);
        physicalExamField.setPrefHeight(134);

        heightFieldFtField = new TextField();
        heightFieldFtField.getStyleClass().add("whiteTextField");
        heightFieldFtField.setLayoutX(323);
        heightFieldFtField.setLayoutY(355);
        heightFieldFtField.setPrefWidth(189);
        heightFieldFtField.setPrefHeight(36);

        heightFieldInField = new TextField();
        heightFieldInField.getStyleClass().add("whiteTextField");
        heightFieldInField.setLayoutX(548);
        heightFieldInField.setLayoutY(355);
        heightFieldInField.setPrefWidth(181);
        heightFieldInField.setPrefHeight(36);

        bodyTempField = new TextField();
        bodyTempField.getStyleClass().add("whiteTextField");
        bodyTempField.setLayoutX(323);
        bodyTempField.setLayoutY(415);
        bodyTempField.setPrefWidth(406);
        bodyTempField.setPrefHeight(36);

        bloodPressureField = new TextField();
        bloodPressureField.getStyleClass().add("whiteTextField");
        bloodPressureField.setLayoutX(323);
        bloodPressureField.setLayoutY(475);
        bloodPressureField.setPrefWidth(406);
        bloodPressureField.setPrefHeight(36);

        allergiesField = new TextField();
        allergiesField.getStyleClass().add("whiteTextField");
        allergiesField.setLayoutX(328);
        allergiesField.setLayoutY(578);
        allergiesField.setPrefWidth(450);
        allergiesField.setPrefHeight(62);

        healthIssuesField = new TextField();
        healthIssuesField.getStyleClass().add("whiteTextField");
        healthIssuesField.setLayoutX(328);
        healthIssuesField.setLayoutY(666);
        healthIssuesField.setPrefWidth(450);
        healthIssuesField.setPrefHeight(134);

        medicationsField = new TextField();
        medicationsField.getStyleClass().add("whiteTextField");
        medicationsField.setLayoutX(328);
        medicationsField.setLayoutY(824);
        medicationsField.setPrefWidth(450);
        medicationsField.setPrefHeight(134);

        immunizationsField = new TextField();
        immunizationsField.getStyleClass().add("whiteTextField");
        immunizationsField.setLayoutX(328);
        immunizationsField.setLayoutY(985);
        immunizationsField.setPrefWidth(450);
        immunizationsField.setPrefHeight(134);

        notesField = new TextField();
        notesField.getStyleClass().add("whiteTextField");
        notesField.setLayoutX(328);
        notesField.setLayoutY(1149);
        notesField.setPrefWidth(450);
        notesField.setPrefHeight(134);

        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.getChildren().addAll(physicalExamLabel, weightLabel, heightLabel, bodyTempLabel, bloodPressureLabel,
                allergiesLabel, medicationsLabel, immunizationsLabel, notesLabel, poundsLabel, inchesLabel, feetLabel,
                degreesLabel, mmHgLabel, newPrescriptionButton, physicalExamField, weightField, heightFieldInField, heightFieldFtField,
                bodyTempField, bloodPressureField, allergiesField, medicationsField, immunizationsField, notesField, healthIssuesField);

        newPrescriptionButton.setOnAction(event -> HealthCarePortalSystem.changeSceneTest());
    }
}
