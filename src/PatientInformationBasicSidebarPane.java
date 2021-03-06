import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;

public class PatientInformationBasicSidebarPane extends Pane {
    private Label nameLabel, birthdayLabel, idLabel;

    public PatientInformationBasicSidebarPane() {

        //Set size of the sidebar across all calls to view it
        this.setPrefWidth(427);
        this.setPrefHeight(720);

        //LABELS
        nameLabel = new Label(Main.currentPatient.getFirstName() + " " + Main.currentPatient.getLastName());
        nameLabel.getStyleClass().add("whiteLabel");
        nameLabel.layoutXProperty().bind(this.widthProperty().subtract(nameLabel.widthProperty()).divide(2));
        nameLabel.setLayoutY(187);

        birthdayLabel = new Label("DOB: " + Main.currentPatient.getBirthDate());
        birthdayLabel.getStyleClass().add("sidebarDOBID");
        birthdayLabel.setLayoutX(100);
        birthdayLabel.setLayoutY(235);

        idLabel = new Label("ID: " + Main.currentPatient.getPatientID());
        idLabel.getStyleClass().add("sidebarDOBID");
        idLabel.setLayoutX(114);
        idLabel.setLayoutY(277);

        this.setBackground(new Background(new BackgroundFill(Color.web("#659BFF"), null, null)));
        this.getChildren().addAll(nameLabel, birthdayLabel, idLabel);
    }

}
