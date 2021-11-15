import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;

public class PatientViewMessagesPane extends Pane {
    private Button backButton;
    private Label helloLabel, welcomeLabel, fromLabel, subjectLabel, bodyLabel;
    private String specialistNameAndTitle = "";

    public PatientViewMessagesPane() throws FileNotFoundException {
        //LABELS
        helloLabel = new Label("Hello " + specialistNameAndTitle);
        helloLabel.getStyleClass().add("helloLabel");
        helloLabel.setLayoutX(14);
        helloLabel.setLayoutY(12);

        welcomeLabel = new Label("Welcome to ConnectMD");
        welcomeLabel.getStyleClass().add("welcomeLabel");
        welcomeLabel.setLayoutX(14);
        welcomeLabel.setLayoutY(36);

        fromLabel = new Label("From");
        fromLabel.getStyleClass().add("textBoxTitleLabel");
        fromLabel.setLayoutX(64);
        fromLabel.setLayoutY(104);

        subjectLabel = new Label("Subject");
        subjectLabel.getStyleClass().add("textBoxTitleLabel");
        subjectLabel.setLayoutX(267);
        subjectLabel.setLayoutY(104);

        bodyLabel = new Label("Body");
        bodyLabel.getStyleClass().add("textBoxTitleLabel");
        bodyLabel.setLayoutX(533);
        bodyLabel.setLayoutY(104);

        //BUTTONS
        backButton = new Button("< Back");
        backButton.getStyleClass().add("smallBlueButton");
        backButton.setLayoutX(19);
        backButton.setLayoutY(654);


        //Set the background and children
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.getChildren().addAll(helloLabel, welcomeLabel, backButton, fromLabel, subjectLabel, bodyLabel);

        //Action Events
        backButton.setOnAction(event -> HealthCarePortalSystem.changeSceneTest());
    }

}
