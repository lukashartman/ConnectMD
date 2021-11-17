import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.time.LocalDate;
import java.util.Objects;

public class HealthHistoryScrollBar extends Pane {
    private Label physicalExamLabel, weightLabel, heightLabel, bodyTempLabel,
            bloodPressureLabel, allergiesLabel, medicationsLabel, immunizationsLabel, notesLabel, poundsLabel,
            inchesLabel, feetLabel, degreesLabel, mmHgLabel, healthIssuesLabel;
    private Button newPrescriptionButton;
    private TextArea physicalExamField, allergiesField, medicationsField, immunizationsField, notesField, healthIssuesField;
    private TextField weightField, heightFieldInField, heightFieldFtField, bodyTempField,
            bloodPressureField;

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
        allergiesLabel.setLayoutX(183);
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
        newPrescriptionButton = new Button("New");
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
        weightField.setText(String.valueOf(Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).getWeight()));


        physicalExamField = new TextArea();
        physicalExamField.getStyleClass().add("whiteTextField");
        physicalExamField.setLayoutX(328);
        physicalExamField.setLayoutY(103);
        physicalExamField.setPrefWidth(450);
        physicalExamField.setPrefHeight(134);
        physicalExamField.setWrapText(true);
        physicalExamField.setText(Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).getPhysicalExamNotes());
        physicalExamField.setId("physicalExamField");
        physicalExamField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).updatePhysicalExam(physicalExamField.getText());
            }
        });

        heightFieldFtField = new TextField();
        heightFieldFtField.getStyleClass().add("whiteTextField");
        heightFieldFtField.setLayoutX(323);
        heightFieldFtField.setLayoutY(355);
        heightFieldFtField.setPrefWidth(189);
        heightFieldFtField.setPrefHeight(36);
        heightFieldFtField.setText(String.valueOf(Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).getHeightFt()));

        heightFieldInField = new TextField();
        heightFieldInField.getStyleClass().add("whiteTextField");
        heightFieldInField.setLayoutX(548);
        heightFieldInField.setLayoutY(355);
        heightFieldInField.setPrefWidth(181);
        heightFieldInField.setPrefHeight(36);
        heightFieldInField.setText(String.valueOf(Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).getHeightIn()));

        bodyTempField = new TextField();
        bodyTempField.getStyleClass().add("whiteTextField");
        bodyTempField.setLayoutX(323);
        bodyTempField.setLayoutY(415);
        bodyTempField.setPrefWidth(406);
        bodyTempField.setPrefHeight(36);
        bodyTempField.setText(String.valueOf(Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).getBodyTemp()));


        bloodPressureField = new TextField();
        bloodPressureField.getStyleClass().add("whiteTextField");
        bloodPressureField.setLayoutX(323);
        bloodPressureField.setLayoutY(475);
        bloodPressureField.setPrefWidth(406);
        bloodPressureField.setPrefHeight(36);
        bloodPressureField.setText(String.valueOf(Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).getBloodPressure()));

        allergiesField = new TextArea();
        allergiesField.getStyleClass().add("whiteTextField");
        allergiesField.setLayoutX(328);
        allergiesField.setLayoutY(578);
        allergiesField.setPrefWidth(450);
        allergiesField.setPrefHeight(62);
        allergiesField.setWrapText(true);
        allergiesField.setText(Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).getKnownAllergies());
        allergiesField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).updateAllergies(allergiesField.getText());
            }
        });

        healthIssuesField = new TextArea();
        healthIssuesField.getStyleClass().add("whiteTextField");
        healthIssuesField.setLayoutX(328);
        healthIssuesField.setLayoutY(666);
        healthIssuesField.setPrefWidth(450);
        healthIssuesField.setPrefHeight(134);
        healthIssuesField.setWrapText(true);
        healthIssuesField.setText(Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).getHealthIssues());
        healthIssuesField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).updateHealthIssues(healthIssuesField.getText());
            }
        });

        medicationsField = new TextArea();
        medicationsField.getStyleClass().add("whiteTextField");
        medicationsField.setLayoutX(328);
        medicationsField.setLayoutY(824);
        medicationsField.setPrefWidth(450);
        medicationsField.setPrefHeight(134);
        medicationsField.setWrapText(true);
        medicationsField.setText(Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).getMedications());

        immunizationsField = new TextArea();
        immunizationsField.getStyleClass().add("whiteTextField");
        immunizationsField.setLayoutX(328);
        immunizationsField.setLayoutY(985);
        immunizationsField.setPrefWidth(450);
        immunizationsField.setPrefHeight(134);
        immunizationsField.setWrapText(true);
        immunizationsField.setText(Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).getImmunizations());
        immunizationsField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).updateImmunizations(immunizationsField.getText());
            }
        });

        notesField = new TextArea();
        notesField.getStyleClass().add("whiteTextField");
        notesField.setLayoutX(328);
        notesField.setLayoutY(1149);
        notesField.setPrefWidth(450);
        notesField.setPrefHeight(134);
        notesField.setWrapText(true);
        notesField.setText(Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).getNotes());
        notesField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Main.currentPatient.visits.get(HealthCarePortalSystem.findIndexOfVisitDate(Main.currentVisitDate)).updateNotes(notesField.getText());
            }
        });

        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));


        if (Main.currentHealthcareSpecialist == null){
            //if the user is a patient, they can only view their own information and not change anything
            physicalExamField.setEditable(false);
            physicalExamField.setDisable(true);
            weightField.setEditable(false);
            weightField.setDisable(true);
            heightFieldFtField.setEditable(false);
            heightFieldFtField.setDisable(true);
            heightFieldInField.setEditable(false);
            heightFieldInField.setDisable(true);
            bodyTempField.setEditable(false);
            bodyTempField.setDisable(true);
            bloodPressureField.setEditable(false);
            bloodPressureField.setDisable(true);
            allergiesField.setEditable(false);
            allergiesField.setDisable(true);
            healthIssuesField.setEditable(false);
            healthIssuesField.setDisable(true);
            medicationsField.setEditable(false);
            medicationsField.setDisable(true);
            immunizationsField.setEditable(false);
            immunizationsField.setDisable(true);
            notesField.setEditable(false);
            notesField.setDisable(true);

            this.getChildren().addAll(physicalExamLabel, weightLabel, heightLabel, bodyTempLabel, bloodPressureLabel,
                    allergiesLabel, medicationsLabel, immunizationsLabel, notesLabel, poundsLabel, inchesLabel, feetLabel,
                    degreesLabel, mmHgLabel, physicalExamField, weightField, heightFieldInField, heightFieldFtField,
                    bodyTempField, bloodPressureField, allergiesField, medicationsField, immunizationsField, notesField, healthIssuesField, healthIssuesLabel);

        } else if (Main.currentHealthcareSpecialist.getType().equals("Doctor")){
            //if the user is a doctor, they can view all of the information and edit it only if the visit is taking place on that day
            if (!Objects.equals(Main.currentVisitDate, LocalDate.now())) {
                physicalExamField.setEditable(false);
                physicalExamField.setDisable(true);
                allergiesField.setEditable(false);
                allergiesField.setDisable(true);
                healthIssuesField.setEditable(false);
                healthIssuesField.setDisable(true);
                immunizationsField.setEditable(false);
                immunizationsField.setDisable(true);
                notesField.setEditable(false);
                notesField.setDisable(true);
                medicationsField.setEditable(false);
                medicationsField.setDisable(true);

                //These should never be editable by anytone except the nurse the day of vitals check
                weightField.setEditable(false);
                weightField.setDisable(true);
                heightFieldFtField.setEditable(false);
                heightFieldFtField.setDisable(true);
                heightFieldInField.setEditable(false);
                heightFieldInField.setDisable(true);
                bodyTempField.setEditable(false);
                bodyTempField.setDisable(true);
                bloodPressureField.setEditable(false);
                bloodPressureField.setDisable(true);

                this.getChildren().addAll(physicalExamLabel, weightLabel, heightLabel, bodyTempLabel, bloodPressureLabel,
                        allergiesLabel, medicationsLabel, immunizationsLabel, notesLabel, poundsLabel, inchesLabel, feetLabel,
                        degreesLabel, mmHgLabel, physicalExamField, weightField, heightFieldInField, heightFieldFtField,
                        bodyTempField, bloodPressureField, allergiesField, medicationsField, immunizationsField, notesField, healthIssuesField, healthIssuesLabel);
            } else {
                physicalExamField.setEditable(true);
                physicalExamField.setDisable(false);
                allergiesField.setEditable(true);
                allergiesField.setDisable(false);
                healthIssuesField.setEditable(true);
                healthIssuesField.setDisable(false);
                medicationsField.setEditable(true);
                medicationsField.setDisable(false);
                immunizationsField.setEditable(true);
                immunizationsField.setDisable(false);
                notesField.setEditable(true);
                notesField.setDisable(false);
                medicationsField.setEditable(false);
                medicationsField.setDisable(true);

                //These should never be editable by anytone except the nurse the day of vitals check
                weightField.setEditable(false);
                weightField.setDisable(true);
                heightFieldFtField.setEditable(false);
                heightFieldFtField.setDisable(true);
                heightFieldInField.setEditable(false);
                heightFieldInField.setDisable(true);
                bodyTempField.setEditable(false);
                bodyTempField.setDisable(true);
                bloodPressureField.setEditable(false);
                bloodPressureField.setDisable(true);



                this.getChildren().addAll(physicalExamLabel, weightLabel, heightLabel, bodyTempLabel, bloodPressureLabel,
                        allergiesLabel, medicationsLabel, immunizationsLabel, notesLabel, poundsLabel, inchesLabel, feetLabel,
                        degreesLabel, mmHgLabel, newPrescriptionButton, physicalExamField, weightField, heightFieldInField, heightFieldFtField,
                        bodyTempField, bloodPressureField, allergiesField, medicationsField, immunizationsField, notesField, healthIssuesField, healthIssuesLabel);
            }


        } else if (Main.currentHealthcareSpecialist.getType().equals("Nurse")){
            medicationsField.setDisable(true);
            medicationsField.setEditable(false);
            immunizationsField.setDisable(true);
            immunizationsField.setEditable(false);

            allergiesLabel.setLayoutX(121);
            allergiesLabel.setLayoutY(182);
            healthIssuesLabel.setLayoutX(160);
            healthIssuesLabel.setLayoutY(268);
            medicationsLabel.setLayoutX(178);
            medicationsLabel.setLayoutY(461);
            immunizationsLabel.setLayoutX(143);
            immunizationsLabel.setLayoutY(614);

            allergiesField.setLayoutX(379);
            allergiesField.setLayoutY(182);
            healthIssuesField.setLayoutX(379);
            healthIssuesField.setLayoutY(268);
            medicationsField.setLayoutX(379);
            medicationsField.setLayoutY(461);
            immunizationsField.setLayoutX(379);
            immunizationsField.setLayoutY(614);





            this.getChildren().addAll(allergiesLabel, medicationsLabel, immunizationsLabel,allergiesField, medicationsField, immunizationsField, healthIssuesField, healthIssuesLabel);
        }



        newPrescriptionButton.setOnAction(event -> HealthCarePortalSystem.prescribeMedication());
    }
}
