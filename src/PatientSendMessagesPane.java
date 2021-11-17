import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;

public class PatientSendMessagesPane extends Pane {
    private Button backButton, submitAndFinishButton;
    private Label msgProviderLabel, helloLabel, messageToLabel, subjectLabel, bodyLabel;
    private Label messageToLabelProviderName;
    private TextField subjectField;
    private TextArea bodyField;
    private Pane rightPane;

    public PatientSendMessagesPane() throws FileNotFoundException {
        rightPane = new PatientInformationSidebarPane();
        rightPane.setLayoutX(852);
        rightPane.setLayoutY(0);

        // create labels
        helloLabel = new Label("Hello, " + Main.currentPatient.getFirstName() + " " + Main.currentPatient.getLastName());
        helloLabel.getStyleClass().add("helloLabel");
        helloLabel.setLayoutX(14);
        helloLabel.setLayoutY(12);

        msgProviderLabel = new Label("Message Provider");
        msgProviderLabel.getStyleClass().add("welcomeLabel");
        msgProviderLabel.setLayoutX(14);
        msgProviderLabel.setLayoutY(48);

        messageToLabel = new Label("Message To: ");
        messageToLabel.getStyleClass().add("textBoxTitleLabel");
        messageToLabel.setLayoutX(85);
        messageToLabel.setLayoutY(146);

        subjectLabel = new Label("Subject");
        subjectLabel.getStyleClass().add("textBoxTitleLabel");
        subjectLabel.setLayoutX(150);
        subjectLabel.setLayoutY(205);

        bodyLabel = new Label("Body");
        bodyLabel.getStyleClass().add("textBoxTitleLabel");
        bodyLabel.setLayoutX(185);
        bodyLabel.setLayoutY(265);

        messageToLabelProviderName = new Label(Main.currentPatient.getHealthCareSpecialist().getFirstName() + " " + Main.currentPatient.getHealthCareSpecialist().getLastName());
        messageToLabelProviderName.getStyleClass().add("messageContentLabel");
        messageToLabelProviderName.setMaxWidth(360);
        messageToLabelProviderName.setLayoutX(279);
        messageToLabelProviderName.setLayoutY(152);

        //create text fields
        subjectField = new TextField();
        subjectField.getStyleClass().add("whiteTextField");
        subjectField.setPrefWidth(361);
        subjectField.setPrefHeight(36);
        subjectField.setLayoutX(279);
        subjectField.setLayoutY(205);

        bodyField = new TextArea();
        bodyField.getStyleClass().add("whiteTextField");
        bodyField.setPrefWidth(361);
        bodyField.setPrefHeight(238);
        bodyField.setLayoutX(279);
        bodyField.setLayoutY(268);
        bodyField.setWrapText(true);

        //create Buttons
        backButton = new Button("< Back");
        backButton.getStyleClass().add("smallBlueButton");
        backButton.setLayoutX(14);
        backButton.setLayoutY(662);

        submitAndFinishButton = new Button("Send and Finish");
        submitAndFinishButton.getStyleClass().add("wideBlueButton");
        submitAndFinishButton.setMinWidth(250);
        submitAndFinishButton.setLayoutX(281);
        submitAndFinishButton.setLayoutY(527);


        this.setBackground(new Background (new BackgroundFill(Color.web("#FFFFFF"),null, null)));
        this.getChildren().addAll(helloLabel, msgProviderLabel, messageToLabel, subjectField, bodyField,
                submitAndFinishButton, backButton, subjectLabel, messageToLabelProviderName, bodyLabel, rightPane);

        backButton.setOnAction(event -> HealthCarePortalSystem.showPatientWelcomePane());
        submitAndFinishButton.setOnAction(event -> HealthCarePortalSystem.sendMessage(Main.currentPatient.getHealthCareSpecialist().getProviderID(), Main.currentPatient.getPatientID(), subjectField.getText(), bodyField.getText()));

    }
}

