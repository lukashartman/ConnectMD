import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;
import javafx.scene.control.ScrollPane;

public class PatientHealthHistoryPane extends Pane
{
    private Label historyPhysLabel, helloLabel;
    private Button finishButton;
    private String specialistNameAndTitle = "";
    private Pane rightPane, scrollPane;
    private ScrollPane scroll;

public PatientHealthHistoryPane() throws FileNotFoundException
    {
        //TODO: Create correct sidebar
        rightPane = new PatientInformationSidebarPane();
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

        helloLabel = new Label("Hello, " + specialistNameAndTitle);
        helloLabel.getStyleClass().add("helloLabel");
        helloLabel.setLayoutX(14);
        helloLabel.setLayoutY(12);

        //BUTTONS
        finishButton = new Button("Finish");
        finishButton.getStyleClass().add("smallBlueButton");
        finishButton.setLayoutX(0);
        finishButton.setLayoutY(0);

        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.getChildren().addAll(historyPhysLabel, helloLabel, rightPane, scroll);
        finishButton.setOnAction(event -> HealthCarePortalSystem.changeSceneTest());
    }
}
