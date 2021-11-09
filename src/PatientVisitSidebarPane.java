import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PatientVisitSidebarPane extends Pane {

    private Image patientPFP;
    private ImageView patientPFPView;
    private Label nameLabel, birthdayLabel, idLabel;
    private String patientID;

    public PatientVisitSidebarPane(String patientID) throws FileNotFoundException {
        //Set size of the sidebar across all calls to view it
        this.setPrefWidth(427);
        this.setPrefHeight(720);

        //LABELS
        //TODO: for all these elements, grab the correct patient information using the patientID passed into here
        nameLabel = new Label("Amanda Weiler");
        nameLabel.getStyleClass().add("whiteLabel");
        nameLabel.setLayoutX(70);
        nameLabel.setLayoutY(187);

        birthdayLabel = new Label("DOB: " + "10/20/2000");
        birthdayLabel.getStyleClass().add("sidebarDOBID");
        birthdayLabel.setLayoutX(100);
        birthdayLabel.setLayoutY(235);

        idLabel = new Label("ID: " + patientID);
        idLabel.getStyleClass().add("sidebarDOBID");
        idLabel.setLayoutX(114);
        idLabel.setLayoutY(277);

        FileInputStream inputstream = new FileInputStream("src/logo.png");
        patientPFP = new Image(inputstream);
        patientPFPView = new ImageView(patientPFP);
        patientPFPView.setFitWidth(158);
        patientPFPView.setFitHeight(158);
        patientPFPView.setLayoutX(134);
        patientPFPView.setLayoutY(12);



        this.setBackground(new Background(new BackgroundFill(Color.web("#659BFF"), null, null)));
        this.getChildren().addAll(patientPFPView, nameLabel, birthdayLabel, idLabel);

    }
}
