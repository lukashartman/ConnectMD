import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;

public class HealthHistoryScrollBar extends Pane {
    private Label physicalExamLabel, weightLabel, heightLabel, bodyTempLabel,
            bloodPressureLabel, allergiesLabel, medicationsLabel, immunizationsLabel, notesLabel, poundsLabel,
            inchesLabel, feetLabel, degreesLabel, mmHgLabel;
    private Button newPrescriptionButton;
    private TextField physicalExamField, weightField, heightFieldInField, heightFieldFtField, bodyTempField,
            bloodPressureField, allergiesField, medicationsField, immunizationsField, notesField;

    public HealthHistoryScrollBar() throws FileNotFoundException {
        physicalExamLabel = new Label("Physical Exam");
        physicalExamLabel.getStyleClass().add("bluePhysicalExamLabel");
        physicalExamLabel.setLayoutX(0);
        physicalExamLabel.setLayoutY(0);

        weightLabel = new Label("Weight");
        weightLabel.getStyleClass().add("blueWeightLabel");
        weightLabel.setLayoutX(0);
        weightLabel.setLayoutY(0);

        heightLabel = new Label("Height");
        heightLabel.getStyleClass().add("blueHeightLabel");
        heightLabel.setLayoutX(0);
        heightLabel.setLayoutY(0);

        feetLabel = new Label("ft.");
        feetLabel.getStyleClass().add("blueFeetLabel");
        feetLabel.setLayoutX(0);
        feetLabel.setLayoutY(0);

        inchesLabel = new Label("in.");
        inchesLabel.getStyleClass().add("blueInchesLabel");
        inchesLabel.setLayoutX(0);
        inchesLabel.setLayoutY(0);

        bodyTempLabel = new Label("Body Temperature");
        bodyTempLabel.getStyleClass().add("blueBodyTempLabel");
        bodyTempLabel.setLayoutX(0);
        bodyTempLabel.setLayoutY(0);

        bloodPressureLabel = new Label("Blood Pressure");
        bloodPressureLabel.getStyleClass().add("blueBloodPressureLabel");
        bloodPressureLabel.setLayoutX(0);
        bloodPressureLabel.setLayoutY(0);

        allergiesLabel = new Label("Allergies");
        allergiesLabel.getStyleClass().add("blueAllergiesLabel");
        allergiesLabel.setLayoutX(0);
        allergiesLabel.setLayoutY(0);

        medicationsLabel = new Label("Medications");
        medicationsLabel.getStyleClass().add("blueMedicationsLabel");
        medicationsLabel.setLayoutX(0);
        medicationsLabel.setLayoutY(0);

        immunizationsLabel = new Label("Immunizations");
        immunizationsLabel.getStyleClass().add("blueImmunizationsLabel");
        immunizationsLabel.setLayoutX(0);
        immunizationsLabel.setLayoutY(0);

        notesLabel = new Label("Notes");
        notesLabel.getStyleClass().add("blueNotesLabel");
        notesLabel.setLayoutX(0);
        notesLabel.setLayoutY(0);

        poundsLabel = new Label("Ibs.");
        poundsLabel.getStyleClass().add("bluePoundsNotesLabel");
        poundsLabel.setLayoutX(0);
        poundsLabel.setLayoutY(0);

        degreesLabel = new Label("F.");
        degreesLabel.getStyleClass().add("blueDegreesNotesLabel");
        degreesLabel.setLayoutX(0);
        degreesLabel.setLayoutY(0);

        mmHgLabel = new Label("mmHg");
        mmHgLabel.getStyleClass().add("blueDegreesNotesLabel");
        mmHgLabel.setLayoutX(0);
        mmHgLabel.setLayoutY(0);

        //BUTTON
        newPrescriptionButton = new Button("New Prescription");
        newPrescriptionButton.getStyleClass().add("bigBlueButton");
        newPrescriptionButton.setLayoutX(0);
        newPrescriptionButton.setLayoutY(0);

        //TEXT FIELDS
        weightField = new TextField();
        weightField.getStyleClass().add("whiteTextField");
        weightField.setLayoutX(0);
        weightField.setLayoutY(0);
        weightField.setPrefWidth(0);
        weightField.setPrefHeight(0);

        physicalExamField = new TextField();
        physicalExamField.getStyleClass().add("whiteTextField");
        physicalExamField.setLayoutX(0);
        physicalExamField.setLayoutY(0);
        physicalExamField.setPrefWidth(0);
        physicalExamField.setPrefHeight(0);

        heightFieldFtField = new TextField();
        heightFieldFtField.getStyleClass().add("whiteTextField");
        heightFieldFtField.setLayoutX(0);
        heightFieldFtField.setLayoutY(0);
        heightFieldFtField.setPrefWidth(0);
        heightFieldFtField.setPrefHeight(0);

        heightFieldInField = new TextField();
        heightFieldInField.getStyleClass().add("whiteTextField");
        heightFieldInField.setLayoutX(0);
        heightFieldInField.setLayoutY(0);
        heightFieldInField.setPrefWidth(0);
        heightFieldInField.setPrefHeight(0);

        bodyTempField = new TextField();
        bodyTempField.getStyleClass().add("whiteTextField");
        bodyTempField.setLayoutX(0);
        bodyTempField.setLayoutY(0);
        bodyTempField.setPrefWidth(0);
        bodyTempField.setPrefHeight(0);

        bloodPressureField = new TextField();
        bloodPressureField.getStyleClass().add("whiteTextField");
        bloodPressureField.setLayoutX(0);
        bloodPressureField.setLayoutY(0);
        bloodPressureField.setPrefWidth(0);
        bloodPressureField.setPrefHeight(0);

        allergiesField = new TextField();
        allergiesField.getStyleClass().add("whiteTextField");
        allergiesField.setLayoutX(0);
        allergiesField.setLayoutY(0);
        allergiesField.setPrefWidth(0);
        allergiesField.setPrefHeight(0);

        medicationsField = new TextField();
        medicationsField.getStyleClass().add("whiteTextField");
        medicationsField.setLayoutX(0);
        medicationsField.setLayoutY(0);
        medicationsField.setPrefWidth(0);
        medicationsField.setPrefHeight(0);

        immunizationsField = new TextField();
        immunizationsField.getStyleClass().add("whiteTextField");
        immunizationsField.setLayoutX(0);
        immunizationsField.setLayoutY(0);
        immunizationsField.setPrefWidth(0);
        immunizationsField.setPrefHeight(0);

        notesField = new TextField();
        notesField.getStyleClass().add("whiteTextField");
        notesField.setLayoutX(0);
        notesField.setLayoutY(0);
        notesField.setPrefWidth(0);
        notesField.setPrefHeight(0);

        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.getChildren().addAll(physicalExamLabel, weightLabel, heightLabel, bodyTempLabel, bloodPressureLabel,
                allergiesLabel, medicationsLabel, immunizationsLabel, notesLabel, poundsLabel, inchesLabel, feetLabel,
                degreesLabel, mmHgLabel, newPrescriptionButton, physicalExamField, weightField, heightFieldInField, heightFieldFtField,
                bodyTempField, bloodPressureField, allergiesField, medicationsField, immunizationsField, notesField);

        newPrescriptionButton.setOnAction(event -> HealthCarePortalSystem.changeSceneTest());
    }
}
