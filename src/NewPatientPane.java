import javafx.geometry.Pos;
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
public class PatientRegistrationPane extends StackPane
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
        left = new VBox(); // left side VBox 
        right = new VBox(); // right side VBox
        buttonBox = new HBox();  // HBox that contains buttons
        border = new BorderPane(); 
        
        firstName = new TextField(); // first name text field 
        lastName = new TextField(); // last name text field 
        email = new TextField(); // email text field 
        password = new TextField(); // password text field 
        passwordConfirm = new TextField(); // confirm password text field 
        confirm = new Button(); // confirm patient registration button 
        cancel = new Button(); // cancel patient registration button 
        
        // set default text of all text fields 
        firstName.setText("First Name"); 
        lastName.setText("Last Name");
        email.setText("Email");
        password.setText("Password");
        passwordConfirm.setText("Confirm Password");
        confirm.setText("Confirm");
        cancel.setText("Cancel");
        
        // set ailgnment and widths 
        fieldsVBox.setAlignment(Pos.CENTER);
        fieldsVBox.setPrefWidth(500);
        buttonBox.setAlignment(Pos.CENTER);
        left.setPrefWidth(100);
        right.setPrefWidth(100);
        
        // add nodes to button HBox and field VBox
        buttonBox.getChildren().addAll(confirm, cancel);
        fieldsVBox.getChildren().addAll(firstName, lastName, email, password, passwordConfirm, buttonBox); 
        
        //set contents of Border Pane
        border.setCenter(fieldsVBox);
        border.setLeft(left);
        border.setRight(right);
        
        this.getChildren().add(border); // set contents of New Patient Pane
    }
    
}
