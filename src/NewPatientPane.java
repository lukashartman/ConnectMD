import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class NewPatientPane extends Pane {
    private Label firstNameLabel, lastNameLabel, dobLabel, providerPrefLabel, welcomeLabel, helloLabel, enterInfoLabel;
    private Button quitButton, submitAndFinishButton;
    private TextField firstNameField, lastNameField;
    private DatePicker dobField;
    private ComboBox providerPrefField;
    private ObservableList<String> list = FXCollections.observableArrayList();


    public NewPatientPane() {
// labels
        helloLabel = new Label("Hello, new patient");
        helloLabel.getStyleClass().add("helloLabel");
        helloLabel.setLayoutX(14);
        helloLabel.setLayoutY(12);

        welcomeLabel = new Label ("Welcome to ConnectMD");
        welcomeLabel.getStyleClass().add("welcomeLabel");
        welcomeLabel.setLayoutX(14);
        welcomeLabel.setLayoutY(36);

        firstNameLabel = new Label ("First Name");
        firstNameLabel.getStyleClass().add("textBoxTitleLabel");
        firstNameLabel.setLayoutX(441);
        firstNameLabel.setLayoutY(318);

        lastNameLabel = new Label ("Last Name");
        lastNameLabel.getStyleClass().add("textBoxTitleLabel");
        lastNameLabel.setLayoutX(443);
        lastNameLabel.setLayoutY(378);

        dobLabel = new Label ("Date of Birth");
        dobLabel.getStyleClass().add("textBoxTitleLabel");
        dobLabel.setLayoutX(416);
        dobLabel.setLayoutY(438);

        providerPrefLabel = new Label ("Provider Preference");
        providerPrefLabel.getStyleClass().add("textBoxTitleLabel");
        providerPrefLabel.setLayoutX(312);
        providerPrefLabel.setLayoutY(498);

        enterInfoLabel = new Label ("Please enter the following information to create your account:");
        enterInfoLabel.getStyleClass().add("welcomeLabel");
        enterInfoLabel.setLayoutX(56);
        enterInfoLabel.setLayoutY(166);


        //buttons
        quitButton = new Button("Quit");
        quitButton.getStyleClass().add("logOutButton");
        quitButton.setLayoutX(1130);
        quitButton.setLayoutY(20);

        submitAndFinishButton = new Button("Submit and Finish");
        submitAndFinishButton.getStyleClass().add("wideBlueButton");
        submitAndFinishButton.setLayoutX(515);
        submitAndFinishButton.setLayoutY(572);

        //text fields
        firstNameField = new TextField();
        firstNameField.getStyleClass().add("whiteTextField");
        firstNameField.setPrefWidth(361);
        firstNameField.setLayoutX(607);
        firstNameField.setLayoutY(318);

        lastNameField = new TextField();
        lastNameField.getStyleClass().add("whiteTextField");
        lastNameField.setPrefWidth(361);
        lastNameField.setLayoutX(607);
        lastNameField.setLayoutY(378);

        dobField = new DatePicker();
        dobField.getStyleClass().add("whiteTextField");
        dobField.setPrefWidth(361);
        dobField.setLayoutX(607);
        dobField.setLayoutY(438);

        for (int i =0; i < Main.healthcareSpecialistList.size(); i++) {
            if (Main.healthcareSpecialistList.get(i).getType().equals("Doctor")) {
                list.add(Main.healthcareSpecialistList.get(i).getTitleName());
            }
        }

        providerPrefField = new ComboBox(list);
        providerPrefField.getStyleClass().add("whiteTextField");
        providerPrefField.setPrefWidth(361);
        providerPrefField.setLayoutX(607);
        providerPrefField.setLayoutY(498);

        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.getChildren().addAll(firstNameLabel, lastNameLabel, dobLabel, providerPrefLabel, welcomeLabel,
                helloLabel, enterInfoLabel, quitButton, submitAndFinishButton, firstNameField, lastNameField, dobField,
                providerPrefField);

        submitAndFinishButton.setOnAction(event -> HealthCarePortalSystem.registerPatient(firstNameField.getText(), lastNameField.getText(), dobField.getValue(), providerPrefField.getValue().toString()));
        quitButton.setOnAction(event -> HealthCarePortalSystem.logOutUser());
    }
    
}
