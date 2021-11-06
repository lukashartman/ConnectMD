import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.scene.layout.*;


/**
 *
 * @author Noah
 */

public class PatientInformationPane  extends HBox  {
    
    private Image patientProfileImage;
    private ImageView patientProfileImageView;
    private Label helloLabel, yourInfoLabel, DOBLabel, IDLabel;
    private TextField pharmNameField, pharmAddressField, PhoneField, insuranceNameField; 
    private Button backButton; 
    private String patientName = "";
    private String patientDOB = "";
    private String patientID = "";
    
   
    public PatientInformationPane()throws FileNotFoundException{
        
        
        // labels
        helloLabel = new Label("Hello, " + patientName);
        helloLabel.getStyleClass().add("blueLabel");
        helloLabel.setLayoutX(0);
        helloLabel.setLayoutY(0);
        
        yourInfoLabel = new Label ("My Information");
        yourInfoLabel.getStyleClass().add("whiteLabel");
        yourInfoLabel.setLayoutX(0);
        yourInfoLabel.setLayoutY(0);
        
        DOBLabel = new Label (patientDOB);
        DOBLabel.getStyleClass().add("whiteLabel");
        DOBLabel.setLayoutX(0);
        DOBLabel.setLayoutY(0);
        
        IDLabel = new Label (patientID);
        IDLabel.getStyleClass().add("whiteLabel");
        IDLabel.setLayoutX(0);
        IDLabel.setLayoutY(0);
        
        //buttons
        backButton = new Button("Back");
        backButton.getStyleClass().add("blueLabel");
        backButton.setLayoutX(0);
        backButton.setLayoutY(0);
        
        //text fields
      
        pharmNameField = new TextField();
        pharmNameField.getStyleClass().add("blueLabel");
        pharmNameField.setPromptText("Pharmacy Name");
        pharmNameField.setLayoutX(0);
        pharmNameField.setLayoutY(0);

        pharmAddressField = new TextField();
        pharmAddressField.getStyleClass().add("blueLabel");
        pharmAddressField.setPromptText("Pharmacy Address");
        pharmAddressField.setLayoutX(0);
        pharmAddressField.setLayoutY(0);
        
        PhoneField = new TextField();
        PhoneField.getStyleClass().add("blueLabel");
        PhoneField.setPromptText("Phone Number");
        PhoneField.setLayoutX(0);
        PhoneField.setLayoutY(0);
        
        insuranceNameField = new TextField();
        insuranceNameField.getStyleClass().add("blueLabel");
        insuranceNameField.setPromptText("Insurance Name");
        insuranceNameField.setLayoutX(0);
        insuranceNameField.setLayoutY(0);
        
        //images
      
        FileInputStream profilePictureInput = new FileInputStream((""));
        patientProfileImage = new Image(profilePictureInput);
        patientProfileImageView = new ImageView(patientProfileImage);
        patientProfileImageView.setFitWidth(100);
        patientProfileImageView.setFitHeight(100);
        patientProfileImageView.setLayoutX(0);
        patientProfileImageView.setLayoutY(0);
    }
    
}
