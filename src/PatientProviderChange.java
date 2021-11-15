import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.io.FileNotFoundException;

public class PatientProviderChange extends Pane {
    private Button backButton, submitAndFinishButton;
    private Label changeOfProviderLabel, helloLabel, reasonLabel;
    private TextArea reasonField;
    private ComboBox chooseNewProviderField;
    private Pane rightPane;
    private String patientName = "";


    public PatientProviderChange() throws FileNotFoundException {

        //TODO: dynamically replace this parameter with the parameter from the dropdown in the previous view
        rightPane = new PatientInformationSidebarPane("P44924663");
        rightPane.setLayoutX(852);
        rightPane.setLayoutY(0);

        // create labels
        helloLabel = new Label("Hello, " + patientName);
        helloLabel.getStyleClass().add("helloLabel");
        helloLabel.setLayoutX(14);
        helloLabel.setLayoutY(12);

        changeOfProviderLabel = new Label("Request Change of Provider");
        changeOfProviderLabel.getStyleClass().add("welcomeLabel");
        changeOfProviderLabel.setLayoutX(14);
        changeOfProviderLabel.setLayoutY(36);

        reasonLabel = new Label("Reason");
        reasonLabel.getStyleClass().add("textBoxTitleLabel");
        reasonLabel.setLayoutX(143);
        reasonLabel.setLayoutY(247);

        //providers list
        String[] providers = {""};

        //create Combo box
        //TODO: fill this combo box with the list of providers
        chooseNewProviderField = new ComboBox();
        chooseNewProviderField.setValue("Choose New Provider");
        chooseNewProviderField.getStyleClass().add("selectPatientDropdown");
        chooseNewProviderField.setMaxWidth(361);
        chooseNewProviderField.setLayoutX(261);
        chooseNewProviderField.setLayoutY(164);

        //create text field
        reasonField = new TextArea();
        reasonField.getStyleClass().add("whiteTextField");
        reasonField.setPrefWidth(361);
        reasonField.setPrefHeight(238);
        reasonField.setLayoutX(261);
        reasonField.setLayoutY(247);

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

        this.getChildren().addAll(helloLabel, changeOfProviderLabel, chooseNewProviderField, reasonField,submitAndFinishButton, reasonLabel, backButton, rightPane);
        this.setBackground(new Background (new BackgroundFill(Color.web("#FFFFFF"),null, null)));

        submitAndFinishButton.setOnAction(event -> HealthCarePortalSystem.requestProviderChange(chooseNewProviderField.getValue().toString(), reasonField.getText()));
        backButton.setOnAction(event -> HealthCarePortalSystem.showPatientWelcomePane());

    }
}
