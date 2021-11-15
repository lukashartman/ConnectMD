import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private String specialistNameAndTitle = "";
    private Pane rightPane, scrollPane;
    private ScrollPane scroll;

public PatientHealthHistoryPane() throws FileNotFoundException
    {
       // rightPane = new HealthHistorySidebarPane();
        rightPane.setLayoutX(852);
        rightPane.setLayoutY(0);

        scrollPane = new HealthHistoryScrollBar();
        scrollPane.setLayoutX(0);
        scrollPane.setLayoutY(0);

        scroll = new ScrollPane();
        scroll.setPrefSize(0, 0);
        scroll.setContent(scrollPane);

        //LABELS
        historyPhysLabel = new Label("Health History and Physical");
        historyPhysLabel.getStyleClass().add("blueHistoryPhysLabel");
        historyPhysLabel.setLayoutX(14);
        historyPhysLabel.setLayoutY(36);

        helloLabel = new Label("Hello " + specialistNameAndTitle);
        helloLabel.getStyleClass().add("blueHelloLabel");
        helloLabel.setLayoutX(14);
        helloLabel.setLayoutY(12);

        //BUTTONS
        finishButton = new Button("Finish");
        finishButton.getStyleClass().add("smallBlueButton");
        finishButton.setLayoutX(0);
        finishButton.setLayoutY(0);

        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.getChildren().addAll(historyPhysLabel, helloLabel, rightPane, scrollPane);
        finishButton.setOnAction(event -> HealthCarePortalSystem.changeSceneTest());
    }
}