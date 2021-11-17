import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;

public class PatientAllMessagesPane extends Pane {
    private Button backButton;
    private Label helloLabel, welcomeLabel, fromLabel, subjectLabel, bodyLabel;
    int messageOffset = 104;

    public PatientAllMessagesPane() throws FileNotFoundException {
        //LABELS
        helloLabel = new Label("Hello, " + Main.currentPatient.getFirstName() + " " + Main.currentPatient.getLastName());
        helloLabel.getStyleClass().add("helloLabel");
        helloLabel.setLayoutX(14);
        helloLabel.setLayoutY(12);

        welcomeLabel = new Label("Messages from Provider");
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

        for (int i = 0; i < Main.messages.size(); i++) {
            if (Main.messages.get(i).getRecipientID().equals(Main.currentPatient.getPatientID())) {
                messageOffset += 55;

                Label fromLabel2 = new Label(HealthCarePortalSystem.findProviderByID(Main.messages.get(i).getSenderID()).getFirstName() + " " + HealthCarePortalSystem.findProviderByID(Main.messages.get(i).getSenderID()).getLastName());
                fromLabel2.getStyleClass().add("messageContentLabel");
                fromLabel2.setLayoutX(64);
                fromLabel2.setLayoutY(messageOffset);

                Label subjectLabel2 = new Label(Main.messages.get(i).getMessageSubject());
                subjectLabel2.getStyleClass().add("messageContentLabel");
                subjectLabel2.setLayoutX(267);
                subjectLabel2.setLayoutY(messageOffset);

                Label bodyLabel2 = new Label(Main.messages.get(i).getMessageBody().substring(0, Math.min(Main.messages.get(i).getMessageBody().length(), 40)) + "...");
                bodyLabel2.getStyleClass().add("messageContentLabel");
                bodyLabel2.setLayoutX(533);
                bodyLabel2.setLayoutY(messageOffset);


                Button viewButton = new Button("View");
                viewButton.getStyleClass().add("smallBlueButton");
                viewButton.setLayoutX(1071);
                viewButton.setLayoutY(messageOffset-15);

                this.getChildren().addAll(fromLabel2, subjectLabel2, bodyLabel2, viewButton);
                int finalI = i;
                viewButton.setOnAction(event -> HealthCarePortalSystem.showPatientViewMessagePane(Main.messages.get(finalI)));
            }
        }


        //BUTTONS
        backButton = new Button("< Back");
        backButton.getStyleClass().add("smallBlueButton");
        backButton.setLayoutX(19);
        backButton.setLayoutY(654);


        //Set the background and children
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.getChildren().addAll(helloLabel, welcomeLabel, backButton, fromLabel, subjectLabel, bodyLabel);

        //Action Events
        backButton.setOnAction(event -> HealthCarePortalSystem.showPatientWelcomePane());

    }

}
