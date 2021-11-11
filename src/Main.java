import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileNotFoundException;

public class Main extends Application {

    //Instance Variables
    protected static Stage window;
    protected static Scene scene1;
    protected static Pane mainPane;

    //Method to launch application
    public static void main(String[] args){
        launch(args);
    }

    //Method to display application
    public void start (Stage primaryStage) throws FileNotFoundException {

        //TODO: Read from plaintext into Vector of patients

        //Setup stage, scene, and window8
        primaryStage.setResizable(false);
        window = primaryStage;
        mainPane = new MainPane();

        scene1 = new Scene(mainPane, 1280, 720);
        scene1.getStylesheets().add("theme.css");

        window.setScene(scene1);
        window.setTitle("ConnectMD | Log In");
        window.show();
        System.out.println("Application started");
    }

    //Method to run on application stop
    public void stop(){
        System.out.println("Application stopped");
    }

    public class MainPane extends StackPane {
            public MainPane() throws FileNotFoundException {

            this.getChildren().add(new LoginPane());
        }
    }
}
