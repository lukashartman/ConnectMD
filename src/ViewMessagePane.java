import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class ViewMessagePane extends Pane {
    private Button backButton, submitAndFinishButton;
    private Label helloLabel, messageLabel, fromTitleLabel, subjectTitleLabel,
            bodyTitleLabel, fromInfoLabel, subjectInfoLabel, bodyInfoLabel,
            subjectTitleLabel2, bodyTitleLabel2, messageToTitleLabel, fromInfoLabel2;
    private TextField subjectField;
    private TextArea bodyField;
    String body = "";
    String specialistNameAndTitle = "";

    public ViewMessagePane() {

        // create labels
        helloLabel = new Label("Hello, " + specialistNameAndTitle);
        helloLabel.getStyleClass().add("helloLabel");
        helloLabel.setLayoutX(14);
        helloLabel.setLayoutY(12);

        messageLabel = new Label("Message");
        messageLabel.getStyleClass().add("welcomeLabel");
        messageLabel.setLayoutX(14);
        messageLabel.setLayoutY(36);

        fromTitleLabel = new Label("From");
        fromTitleLabel.getStyleClass().add("textBoxTitleLabel");
        fromTitleLabel.setLayoutX(64);
        fromTitleLabel.setLayoutY(146);

        fromInfoLabel = new Label("Amanda Weiler");
        fromInfoLabel.getStyleClass().add("messageContentLabel");
        fromInfoLabel.setLayoutX(166);
        fromInfoLabel.setLayoutY(152);

        subjectTitleLabel = new Label("Subject");
        subjectTitleLabel.getStyleClass().add("textBoxTitleLabel");
        subjectTitleLabel.setLayoutX(29);
        subjectTitleLabel.setLayoutY(209);

        subjectInfoLabel = new Label("Medication Question");
        subjectInfoLabel.getStyleClass().add("messageContentLabel");
        subjectInfoLabel.setLayoutX(166);
        subjectInfoLabel.setLayoutY(215);

        bodyTitleLabel = new Label("Body");
        bodyTitleLabel.getStyleClass().add("textBoxTitleLabel");
        bodyTitleLabel.setLayoutX(64);
        bodyTitleLabel.setLayoutY(272);

        bodyInfoLabel = new Label(body);
        bodyInfoLabel.getStyleClass().add("messageContentLabel");
        bodyInfoLabel.setLayoutX(166);
        bodyInfoLabel.setLayoutY(278);

        bodyTitleLabel2 = new Label("Body");
        bodyTitleLabel2.getStyleClass().add("textBoxTitleLabel");
        bodyTitleLabel2.setLayoutX(708);
        bodyTitleLabel2.setLayoutY(267);

        subjectTitleLabel2 = new Label("Subject");
        subjectTitleLabel2.getStyleClass().add("textBoxTitleLabel");
        subjectTitleLabel2.setLayoutX(672);
        subjectTitleLabel2.setLayoutY(207);

        messageToTitleLabel = new Label("Message To");
        messageToTitleLabel.getStyleClass().add("textBoxTitleLabel");
        messageToTitleLabel.setLayoutX(608);
        messageToTitleLabel.setLayoutY(148);

        fromInfoLabel2 = new Label("Amanda Weiler");
        fromInfoLabel2.getStyleClass().add("messageContentLabel");
        fromInfoLabel2.setLayoutX(802);
        fromInfoLabel2.setLayoutY(152);

        //create text fields
        subjectField = new TextField();
        subjectField.getStyleClass().add("whiteTextField");
        subjectField.setPrefWidth(361);
        subjectField.setPrefHeight(26);
        subjectField.setLayoutX(802);
        subjectField.setLayoutY(207);

        bodyField = new TextArea();
        bodyField.getStyleClass().add("whiteTextField");
        bodyField.setPrefWidth(361);
        bodyField.setPrefHeight(238);
        bodyField.setLayoutX(802);
        bodyField.setLayoutY(270);


        //create Buttons
        backButton = new Button("< Back");
        backButton.getStyleClass().add("smallBlueButton");
        backButton.setLayoutX(19);
        backButton.setLayoutY(654);

        submitAndFinishButton = new Button("Send and Finish");
        submitAndFinishButton.getStyleClass().add("wideBlueButton");
        submitAndFinishButton.setMaxWidth(230);
        submitAndFinishButton.setLayoutX(873);
        submitAndFinishButton.setLayoutY(531);

        this.getChildren().addAll(helloLabel, messageLabel, fromTitleLabel, fromInfoLabel, subjectTitleLabel,
                subjectInfoLabel, bodyTitleLabel, bodyInfoLabel, subjectField, bodyField, backButton,
                submitAndFinishButton, subjectTitleLabel2, bodyTitleLabel2, messageToTitleLabel, fromInfoLabel2);

        //backButton.setOnAction(event -> SpecialistMessagesPane.changeSceneTest());
        //submitAndFinishButton.setOnAction(event -> .changeSceneTest());
    }
}
