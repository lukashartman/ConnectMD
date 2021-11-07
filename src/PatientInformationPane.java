import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


/**
 *
 * @author Noah
 */

public class PatientInformationPane extends Pane  {
    private Label helloLabel, yourInfoLabel, pharmNameLabel, pharmAddressLabel, phoneLabel, addressLabel, insuranceNameLabel, insuranceIDLabel;
    private TextField pharmNameField, pharmAddressField, PhoneField, addressField, insuranceNameField, insuranceIDField;
    private Button backButton; 
    private String patientName = "";
    private Pane rightPane;

    public PatientInformationPane()throws FileNotFoundException{
        //TODO: dynamically replace this parameter with the parameter from the dropdown in the previous view
        rightPane = new PatientInformationBasicSidebarPane("P44924663");
        rightPane.setLayoutX(852);
        rightPane.setLayoutY(0);

        // labels
        helloLabel = new Label("Hello, " + patientName);
        helloLabel.getStyleClass().add("helloLabel");
        helloLabel.setLayoutX(14);
        helloLabel.setLayoutY(12);
        
        yourInfoLabel = new Label ("Your Information");
        yourInfoLabel.getStyleClass().add("welcomeLabel");
        yourInfoLabel.setLayoutX(14);
        yourInfoLabel.setLayoutY(36);

        pharmNameLabel = new Label ("Pharmacy Name");
        pharmNameLabel.getStyleClass().add("textBoxTitleLabel");
        pharmNameLabel.setLayoutX(113);
        pharmNameLabel.setLayoutY(204);

        pharmAddressLabel = new Label ("Pharmacy Address");
        pharmAddressLabel.getStyleClass().add("textBoxTitleLabel");
        pharmAddressLabel.setLayoutX(79);
        pharmAddressLabel.setLayoutY(250);

        phoneLabel = new Label ("Phone");
        phoneLabel.getStyleClass().add("textBoxTitleLabel");
        phoneLabel.setLayoutX(258);
        phoneLabel.setLayoutY(316);

        addressLabel = new Label ("Address");
        addressLabel.getStyleClass().add("textBoxTitleLabel");
        addressLabel.setLayoutX(225);
        addressLabel.setLayoutY(362);

        insuranceNameLabel = new Label ("Insurance Name");
        insuranceNameLabel.getStyleClass().add("textBoxTitleLabel");
        insuranceNameLabel.setLayoutX(113);
        insuranceNameLabel.setLayoutY(434);

        insuranceIDLabel = new Label ("Insurance ID");
        insuranceIDLabel.getStyleClass().add("textBoxTitleLabel");
        insuranceIDLabel.setLayoutX(162);
        insuranceIDLabel.setLayoutY(480);
        
        //buttons
        backButton = new Button("< Back");
        backButton.getStyleClass().add("smallBlueButton");
        backButton.setLayoutX(14);
        backButton.setLayoutY(662);
        
        //text fields
        //TODO: dynamically fill all these fields with information based on the current user
        pharmNameField = new TextField();
        pharmNameField.getStyleClass().add("whiteTextField");
        pharmNameField.setLayoutX(369);
        pharmNameField.setLayoutY(204);

        pharmAddressField = new TextField();
        pharmAddressField.getStyleClass().add("whiteTextField");
        pharmAddressField.setLayoutX(369);
        pharmAddressField.setLayoutY(250);
        
        PhoneField = new TextField();
        PhoneField.getStyleClass().add("whiteTextField");
        PhoneField.setLayoutX(369);
        PhoneField.setLayoutY(319);

        addressField = new TextField();
        addressField.getStyleClass().add("whiteTextField");
        addressField.setLayoutX(369);
        addressField.setLayoutY(362);

        insuranceNameField = new TextField();
        insuranceNameField.getStyleClass().add("whiteTextField");
        insuranceNameField.setLayoutX(369);
        insuranceNameField.setLayoutY(434);

        insuranceIDField = new TextField();
        insuranceIDField.getStyleClass().add("whiteTextField");
        insuranceIDField.setLayoutX(369);
        insuranceIDField.setLayoutY(480);

        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.getChildren().addAll(helloLabel, yourInfoLabel, pharmNameLabel, pharmAddressLabel, phoneLabel,
                addressLabel, insuranceNameLabel, insuranceIDLabel, pharmNameField, pharmAddressField, PhoneField,
                addressField, insuranceNameField, insuranceIDField, backButton, rightPane);

    }
    
}
