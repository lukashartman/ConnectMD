import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import java.io.FileNotFoundException;


public class ViewMessagePane extends Pane {
    private Button backButton, submitAndFinishButton;
    private Label helloLabel, messageLabel, fromTitleLabel, subjectTitleLabel, bodyTitleLabel, fromInfoLabel, subjectInfoLabel, bodyInfoLabel;
    private TextField subjectField;
    private TextArea bodyField;
    private ComboBox messageToBox;
    String name = "";
    String subject = "";
    String body = "";

    public ViewMessagePane() throws FileNotFoundException {

        // create labels
        helloLabel = new Label("Hello, " + name);
        helloLabel.getStyleClass().add("blueHelloLabel");
        helloLabel.setLayoutX(0);
        helloLabel.setLayoutY(0);

        messageLabel = new Label("Message");
        messageLabel.getStyleClass().add("blueMessageLabel");
        messageLabel.setLayoutX(0);
        messageLabel.setLayoutY(0);

        fromTitleLabel = new Label("From");
        fromTitleLabel.getStyleClass().add("blueFromLabel");
        fromTitleLabel.setLayoutX(0);
        fromTitleLabel.setLayoutY(0);

        fromInfoLabel = new Label(name);
        fromInfoLabel.getStyleClass().add("blackFromInfoLabel");
        fromInfoLabel.setLayoutX(0);
        fromInfoLabel.setLayoutY(0);

        subjectTitleLabel = new Label("Subject");
        subjectTitleLabel.getStyleClass().add("blueSubjectLabel");
        subjectTitleLabel.setLayoutX(0);
        subjectTitleLabel.setLayoutY(0);

        subjectInfoLabel = new Label(subject);
        subjectInfoLabel.getStyleClass().add("blackSubjectInfoLabel");
        subjectInfoLabel.setLayoutX(0);
        subjectInfoLabel.setLayoutY(0);

        bodyTitleLabel = new Label("Body");
        bodyTitleLabel.getStyleClass().add("blueBodyLabel");
        bodyTitleLabel.setLayoutX(0);
        bodyTitleLabel.setLayoutY(0);

        bodyInfoLabel = new Label(body);
        bodyInfoLabel.getStyleClass().add("blackBodyInfoLabel");
        bodyInfoLabel.setLayoutX(0);
        bodyInfoLabel.setLayoutY(0);



        //create Combo box
        messageToBox = new ComboBox();
        messageToBox.getStyleClass().add("selectPersonDropdown");
        messageToBox.setMaxWidth(0);
        messageToBox.setLayoutX(0);
        messageToBox.setLayoutY(0);

        //create text fields
        subjectField = new TextField();
        subjectField.getStyleClass().add("whiteTextField");
        subjectField.setPrefWidth(0);
        subjectField.setPrefHeight(0);
        subjectField.setLayoutX(0);
        subjectField.setLayoutY(0);

        bodyField = new TextArea();
        bodyField.getStyleClass().add("whiteTextArea");
        bodyField.setPrefWidth(0);
        bodyField.setPrefHeight(0);
        bodyField.setLayoutX(0);
        bodyField.setLayoutY(0);


        //create Buttons
        backButton = new Button("< Back");
        backButton.getStyleClass().add("smallBlueButton");
        backButton.setLayoutX(0);
        backButton.setLayoutY(0);

        submitAndFinishButton = new Button("Send and Finish");
        submitAndFinishButton.getStyleClass().add("smallBlueButton");
        submitAndFinishButton.setMinWidth(0);
        submitAndFinishButton.setLayoutX(0);
        submitAndFinishButton.setLayoutY(0);

        //backButton.setOnAction(event -> SpecialistMessagesPane.changeSceneTest());
        //submitAndFinishButton.setOnAction(event -> .changeSceneTest());
    }
}
