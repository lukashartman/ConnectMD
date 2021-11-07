import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Ben
 */
public class PatientVisitSidebarPane extends VBox
{
    private ComboBox visitMenu;
    private TextArea visitSummary;
    private TextField searchVisits;
    private HBox comboBoxHBox;
    private HBox visitSummaryHBox;
    private Insets insets1;
    private Insets insets2;
    private Insets insets3;

    public void visitPane()
    {
        // create neccesary pane contents
        visitMenu = new ComboBox();
        visitSummary = new TextArea();
        visitSummaryHBox = new HBox();
        comboBoxHBox = new HBox();
        searchVisits = new TextField();
        insets1 = new Insets(50, 20, 0, 0);
        insets2 = new Insets(20, 20, 0, 0);
        insets3 = new Insets(20, 0, 0, 0);

        // set default menu contents
        visitMenu.getItems().add("11/21/21");
        visitMenu.getItems().add("10/12/21");
        visitMenu.getItems().add("09/04/21");
        visitMenu.getItems().add("08/28/21");
        visitMenu.getItems().add("07/11/21");

        visitSummary.setPrefRowCount(30); // size of text field that will display visit summary
        searchVisits.setText("Search Visit Date"); // set text field default contents

        // padding and alignment
        comboBoxHBox.setPadding(insets2);
        comboBoxHBox.setAlignment(Pos.CENTER);
        visitSummaryHBox.setPadding(insets3);

        // add contents to both HBox's
        comboBoxHBox.getChildren().addAll(visitMenu);
        visitSummaryHBox.getChildren().addAll(visitSummary);

        // add contents to the Patient Visit Pane
        this.getChildren().addAll(searchVisits, comboBoxHBox, visitSummaryHBox);
        this.setPrefWidth(300);
        this.setPadding(insets1);
    }
}
