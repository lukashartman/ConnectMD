import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Ben
 */
public class PatientRegsitrationPane extends StackPane
{
    private Pane root;
    private VBox fieldsVBox, left, right; 
    private HBox buttonBox; 
    private BorderPane border; 
    private TextField firstName, lastName, email, password, passwordConfirm; 
    private Button confirm, cancel; 
    
    
    public void newPatientPane()
    {     
        fieldsVBox = new VBox(15);
        left = new VBox(); 
        right = new VBox();
        buttonBox = new HBox(); 
        border = new BorderPane();
        
        firstName = new TextField();
        lastName = new TextField();
        email = new TextField();
        password = new TextField();
        passwordConfirm = new TextField();
        confirm = new Button();
        cancel = new Button();
        
        firstName.setText("First Name");
        lastName.setText("Last Name");
        email.setText("Email");
        password.setText("Password");
        passwordConfirm.setText("Confirm Password");
        confirm.setText("Confirm");
        cancel.setText("Cancel");
        
        fieldsVBox.setAlignment(Pos.CENTER);
        fieldsVBox.setPrefWidth(500);
        buttonBox.setAlignment(Pos.CENTER);
        left.setPrefWidth(100);
        right.setPrefWidth(100);
        
        buttonBox.getChildren().addAll(confirm, cancel);
        fieldsVBox.getChildren().addAll(firstName, lastName, email, password, passwordConfirm, buttonBox); 
        
        border.setCenter(fieldsVBox);
        border.setLeft(left);
        border.setRight(right);
        
        this.getChildren().add(border);
    }
    
}
