import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ObservableList<String> list = FXCollections.observableArrayList();


    public PatientProviderChange() throws FileNotFoundException {

        rightPane = new PatientInformationSidebarPane();
        rightPane.setLayoutX(852);
        rightPane.setLayoutY(0);

        // create labels
        helloLabel = new Label("Hello, " + Main.currentPatient.getFirstName() + " " + Main.currentPatient.getLastName());
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

        //create Combo box
        for (int i =0; i < Main.healthcareSpecialistList.size(); i++) {
            if (Main.healthcareSpecialistList.get(i).getType().equals("Doctor")) {
                list.add(Main.healthcareSpecialistList.get(i).getTitleName());
            }
        }

        chooseNewProviderField = new ComboBox(list);
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
