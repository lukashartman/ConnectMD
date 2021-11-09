import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;

public class PatientMessagesPane extends Pane {
    private Button backButton, submitAndFinishButton;
    private Label msgProviderLabel, helloLabel, messageToLabel, subjectLabel, bodyLabel;
    private ComboBox messageToBox;
    private TextField subjectField;
    private TextArea bodyField;
    private Pane rightPane;
    private String patientName = "";


    public PatientMessagesPane() throws FileNotFoundException {
        //TODO: dynamically replace this parameter with the parameter from the dropdown in the previous view
        rightPane = new PatientInformationSidebarPane("P44924663");
        rightPane.setLayoutX(852);
        rightPane.setLayoutY(0);

        // create labels
        helloLabel = new Label("Hello, " + patientName);
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


        //create Combo box
        messageToBox = new ComboBox();
        messageToBox.getStyleClass().add("selectPatientDropdown");
        messageToBox.setMaxWidth(360);
        messageToBox.setLayoutX(279);
        messageToBox.setLayoutY(143);

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

        //create Buttons
        backButton = new Button("< Back");
        backButton.getStyleClass().add("smallBlueButton");
        backButton.setLayoutX(14);
        backButton.setLayoutY(662);

        submitAndFinishButton = new Button("Send and Finish");
        submitAndFinishButton.getStyleClass().add("smallBlueButton");
        submitAndFinishButton.setMinWidth(250);
        submitAndFinishButton.setLayoutX(347);
        submitAndFinishButton.setLayoutY(527);


        this.setBackground(new Background (new BackgroundFill(Color.web("#FFFFFF"),null, null)));
        this.getChildren().addAll(helloLabel, msgProviderLabel, messageToBox, subjectField, bodyField,
                submitAndFinishButton, backButton, messageToLabel, subjectLabel, bodyLabel, rightPane );



    }
}

