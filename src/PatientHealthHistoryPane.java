import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;
import javafx.scene.control.ScrollPane;

public class PatientHealthHistoryPane extends Pane
{
    private Label historyPhysLabel, helloLabel;
    private Button finishButton;
    private String userName = "";
    private Pane rightPane, scrollPane;
    private ScrollPane scroll;

public PatientHealthHistoryPane() throws FileNotFoundException {
        if (Main.currentHealthcareSpecialist == null) {
                rightPane = new PatientVisitSidebarPane();
                userName = Main.currentPatient.getFirstName() + " " + Main.currentPatient.getLastName();
        } else if (Main.currentHealthcareSpecialist.getType().equals("Doctor")) {
                rightPane = new PatientVisitSidebarPane();
                userName = Main.currentHealthcareSpecialist.getTitleName();
        } else if (Main.currentHealthcareSpecialist.getType().equals("Nurse")) {
                rightPane = new PatientInformationSidebarPane();
                userName = Main.currentHealthcareSpecialist.getTitleName();
        }

        rightPane.setLayoutX(852);
        rightPane.setLayoutY(0);

        scrollPane = new HealthHistoryScrollBar();

        scroll = new ScrollPane();
        scroll.setPrefSize(779, 532);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setMinViewportWidth(785);
        scroll.setMinViewportHeight(532);
        scroll.setLayoutX(39);
        scroll.setLayoutY(90);
        scroll.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
        scroll.setContent(scrollPane);

        //LABELS
        historyPhysLabel = new Label("Health History & Physical");
        historyPhysLabel.getStyleClass().add("welcomeLabel");
        historyPhysLabel.setLayoutX(14);
        historyPhysLabel.setLayoutY(36);

        helloLabel = new Label("Hello, " + userName);
        helloLabel.getStyleClass().add("helloLabel");
        helloLabel.setLayoutX(14);
        helloLabel.setLayoutY(12);

        //BUTTONS
        finishButton = new Button("< Back");
        finishButton.getStyleClass().add("smallBlueButton");
        finishButton.setLayoutX(15);
        finishButton.setLayoutY(656);

        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.getChildren().addAll(historyPhysLabel, helloLabel, rightPane, scroll, finishButton);

        if (Main.currentHealthcareSpecialist == null) {
                finishButton.setOnAction(event -> HealthCarePortalSystem.showPatientWelcomePane());
        } else {
                finishButton.setOnAction(event -> HealthCarePortalSystem.showSpecialistWelcomePane());
        }

    }


}
