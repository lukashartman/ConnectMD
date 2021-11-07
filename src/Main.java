import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {

    //Instance Variables
    protected static Stage window;
    private Scene scene1;
    private Pane currentPane;

    //Method to launch application
    public static void main(String[] args){
        launch(args);
    }

    //Method to display application
    public void start (Stage primaryStage) throws FileNotFoundException {

        //Setup stage, scene, and window
        primaryStage.setResizable(false);
        window = primaryStage;
        currentPane = new PatientInformationPane();

        scene1 = new Scene(currentPane, 1280, 720);
        scene1.getStylesheets().add("theme.css");

        window.setScene(scene1);
        window.setTitle("ConnectMD | Log In");
        window.show();
    }


    //Method to run on application stop
    public void stop(){
        System.out.println("Application stopped");
    }

    private void setScene(){
        window.setScene(scene1);
    }

}
