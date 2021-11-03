import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LoginPane extends HBox {

    private Button patientSubmitButton, providerSubmitButton, createAccountButton;
    private Pane patientLoginBackground, logoBackground, providerLoginBackground;
    private Label patientLoginLabel, providerLoginLabel, connectmdLabel, ehrLabel, newPatientLabel;
    private TextField firstNameField, lastNameField, usernameField, passwordField;
    private DatePicker dobField;
    private Image logoImage;
    private ImageView logoImageView;

    public LoginPane() throws FileNotFoundException {
        //Create buttons, give styles, and position within left sidebar
        patientLoginLabel = new Label("Patient Login");
        patientLoginLabel.getStyleClass().add("whiteLabel");
        patientLoginLabel.setLayoutX(55);
        patientLoginLabel.setLayoutY(38);

        firstNameField = new TextField();
        firstNameField.getStyleClass().add("loginTextField");
        firstNameField.setPromptText("First Name");
        firstNameField.setLayoutX(50);
        firstNameField.setLayoutY(196);

        lastNameField = new TextField();
        lastNameField.getStyleClass().add("loginTextField");
        lastNameField.setPromptText("Last Name");
        lastNameField.setLayoutX(50);
        lastNameField.setLayoutY(271);

        dobField = new DatePicker();
        dobField.getStyleClass().add("loginTextField");
        dobField.setPromptText("Date of Birth");
        dobField.setLayoutX(50);
        dobField.setLayoutY(346);

        patientSubmitButton = new Button("Submit");
        patientSubmitButton.getStyleClass().add("whiteSubmitButton");
        patientSubmitButton.setLayoutX(149);
        patientSubmitButton.setLayoutY(411);

        newPatientLabel = new Label("New patient? Start here.");
        newPatientLabel.getStyleClass().add("whiteLabel");
        newPatientLabel.setStyle("-fx-font-size: 20;");
        newPatientLabel.setLayoutX(97);
        newPatientLabel.setLayoutY(600);

        createAccountButton = new Button("Create Account");
        createAccountButton.getStyleClass().add("whiteSubmitButton");
        createAccountButton.setStyle("-fx-pref-width: 235;");
        createAccountButton.setLayoutX(95);
        createAccountButton.setLayoutY(639);

        //Create left sidebar
        patientLoginBackground = new Pane();
        patientLoginBackground.setPrefWidth(426);
        patientLoginBackground.getChildren().addAll(patientLoginLabel, firstNameField, lastNameField, dobField, patientSubmitButton, newPatientLabel, createAccountButton);
        patientLoginBackground.setBackground(new Background(new BackgroundFill(Color.web("#659BFF"), null, null)));

        FileInputStream inputstream = new FileInputStream("src/logo.png");
        logoImage = new Image(inputstream);
        logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(335);
        logoImageView.setFitHeight(335);
        logoImageView.setLayoutX(46);
        logoImageView.setLayoutY(137);

        connectmdLabel = new Label("ConnectMD");
        connectmdLabel.getStyleClass().add("connectMDLabel");
        connectmdLabel.setLayoutX(29);
        connectmdLabel.setLayoutY(470);

        ehrLabel = new Label("Electronic Health Record");
        ehrLabel.getStyleClass().add("connectMDLabel");
        ehrLabel.setStyle("-fx-font-size: 30;");
        ehrLabel.setLayoutX(35);
        ehrLabel.setLayoutY(547);

        //Create middle bar
        logoBackground = new Pane();
        logoBackground.setPrefWidth(430);
        logoBackground.getChildren().addAll(logoImageView, connectmdLabel, ehrLabel);
        logoBackground.setBackground(new Background(new BackgroundFill(Color.web("#FFFFFF"), null, null)));

        //Create buttons, give styles, and position within left sidebar
        providerLoginLabel = new Label("Provider Login");
        providerLoginLabel.getStyleClass().add("whiteLabel");
        providerLoginLabel.setLayoutX(55);
        providerLoginLabel.setLayoutY(38);

        usernameField = new TextField();
        usernameField.getStyleClass().add("loginTextField");
        usernameField.setPromptText("Username");
        usernameField.setLayoutX(55);
        usernameField.setLayoutY(271);

        passwordField = new TextField();
        passwordField.getStyleClass().add("loginTextField");
        passwordField.setPromptText("Password");
        passwordField.setLayoutX(55);
        passwordField.setLayoutY(346);

        providerSubmitButton = new Button("Submit");
        providerSubmitButton.getStyleClass().add("whiteSubmitButton");
        providerSubmitButton.setLayoutX(147);
        providerSubmitButton.setLayoutY(411);

        //Create right sidebar
        providerLoginBackground = new Pane();
        providerLoginBackground.setPrefWidth(426);
        providerLoginBackground.getChildren().addAll(providerLoginLabel, usernameField, passwordField, providerSubmitButton);
        providerLoginBackground.setBackground(new Background(new BackgroundFill(Color.web("#659BFF"), null, null)));

        //Add all bars to pane, set pane color
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.getChildren().addAll(patientLoginBackground, logoBackground, providerLoginBackground);

        patientSubmitButton.setOnAction(event -> SceneController.changeSceneTest());

    }
}
