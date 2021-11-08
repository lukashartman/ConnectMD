import javafx.scene.control.Alert;

public class SceneController extends Main {

    public static void changeSceneTest(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("This is where we change the scene");
        //alert.setContentText("Careful with the next step!");

        alert.showAndWait();
    }

    public static void calculateDaysBetweenDates(){

    }

}
