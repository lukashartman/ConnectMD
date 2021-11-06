import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;


public class NurseViewPatientVitalsPane {
    private Label vitalsLabel, helloNurseLabel, weightLabel, poundsLabel, heightLabel, feetLabel, inchesLabel,
            bodyTempLabel, degreesLabel, bloodPressureLabel, mmHgLabel;
    private TextField weightField, heightField, bodyTempField,bloodPressureField;
    private Button backButton, nextButton;
    private String specialistName = "";

    public NurseViewPatientVitalsPane() throws FileNotFoundException {
       //LABELS
        vitalsLabel = new Label("Vitals");
        vitalsLabel.getStyleClass().add("blueLabel");
        vitalsLabel.setLayoutX(0);
        vitalsLabel.setLayoutY(0);

        helloNurseLabel = new Label("Hello, " + specialistName + " R.N.");
        helloNurseLabel.getStyleClass().add("blueLabel");
        helloNurseLabel.setLayoutX(0);
        helloNurseLabel.setLayoutY(0);

        weightLabel = new Label("Weight");
        weightLabel.getStyleClass().add("blueLabel");
        weightLabel.setLayoutX(0);
        weightLabel.setLayoutY(0);

        poundsLabel = new Label("Ibs.");
        poundsLabel.getStyleClass().add("blueLabel");
        poundsLabel.setLayoutX(0);
        poundsLabel.setLayoutY(0);

        heightLabel = new Label("Height");
        heightLabel.getStyleClass().add("blueLabel");
        heightLabel.setLayoutX(0);
        heightLabel.setLayoutY(0);

        feetLabel = new Label("ft.");
        feetLabel.getStyleClass().add("blueLabel");
        feetLabel.setLayoutX(0);
        feetLabel.setLayoutY(0);

        inchesLabel = new Label();
        inchesLabel.getStyleClass().add("blueLabel");
        inchesLabel.setLayoutX(0);
        inchesLabel.setLayoutY(0);

        bodyTempLabel = new Label();
        bodyTempLabel.getStyleClass().add("blueLabel");
        bodyTempLabel.setLayoutX(0);
        bodyTempLabel.setLayoutY(0);

        degreesLabel = new Label();
        degreesLabel.getStyleClass().add("blueLabel");
        degreesLabel.setLayoutX(0);
        degreesLabel.setLayoutY(0);

        bloodPressureLabel = new Label();
        bloodPressureLabel.getStyleClass().add("blueLabel");
        bloodPressureLabel.setLayoutX(0);
        bloodPressureLabel.setLayoutY(0);

        mmHgLabel = new Label();
        mmHgLabel.getStyleClass().add("blueLabel");
        mmHgLabel.setLayoutX(0);
        mmHgLabel.setLayoutY(0);

        //BUTTONS
        backButton = new Button("< Back");
        backButton.getStyleClass().add("backButton");
        backButton.setLayoutX(0);
        backButton.setLayoutY(0);

        nextButton = new Button("Next >");
        nextButton.getStyleClass().add("nextButton");
        nextButton.setLayoutX(0);
        nextButton.setLayoutY(0);

        // TEXT FIELDS
        weightField = new TextField();
        weightField.getStyleClass().add("weightTextField");
        weightField.setLayoutX(0);
        weightField.setLayoutY(0);

        heightField = new TextField();
        heightField.getStyleClass().add("heightTextField");
        heightField.setLayoutX(0);
        heightField.setLayoutY(0);

        bodyTempField = new TextField() ;
        bodyTempField.getStyleClass().add("bodyTempTextField");
        bodyTempField.setLayoutX(0);
        bodyTempField.setLayoutY(0);

        bloodPressureField = new TextField();
        bloodPressureField.getStyleClass().add("bloodPressureTextField");
        bloodPressureField.setLayoutX(0);
        bloodPressureField.setLayoutY(0);

       this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
       this.getChildren().addAll(vitalsLabel, helloNurseLabel, weightLabel, poundsLabel, heightLabel, feetLabel, inchesLabel,
               bodyTempLabel, degreesLabel, bloodPressureLabel, mmHgLabel, weightField, heightField, bodyTempField,
               bloodPressureField, backButton, nextButton);

        backButton.setOnAction(event -> SceneController.changeSceneTest());
        nextButton.setOnAction(event -> SceneController.changeSceneTest());
    }
}
