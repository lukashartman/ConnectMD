import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {

    //Instance Variables
    protected static Stage window;
    protected static Scene scene1;
    protected static Pane mainPane;
    public static ArrayList<Patient> patientList = new ArrayList<Patient>();
    public static ArrayList<HealthcareSpecialistNode> healthcareSpecialistList;
    public static ArrayList<Message> messages;

    public static HealthcareSpecialistNode currentHealthcareSpecialist; // current healthcare specialist that is logged in
    public static Patient currentPatient; // current patient that is logged in

    //Method to launch application
    public static void main(String[] args){
        launch(args);
    }

    //Method to display application
    public void start (Stage primaryStage) throws FileNotFoundException {

        System.out.println("Starting Patient Data Input");
        Scanner patientDataScanner = new Scanner(new File("src/patientData.txt"));
        while (patientDataScanner.hasNextLine()){

            for (int i = 0; i < 4; i++) {
                String tempVariable = patientDataScanner.next();
                System.out.print(tempVariable);
            }
            System.out.println("New Patient Incoming");
            //TODO: use the data to create a patient object via constructor
            String tempVariable = patientDataScanner.next();
            System.out.print(tempVariable);
            //Patient tempPatient = new Patient();
            //patientList.add(tempPatient);
        }
        patientDataScanner.close();

//        Scanner specialistDataScanner = new Scanner(new File("src/specialistData.txt"));
//        while (specialistDataScanner.hasNext()){
//            //TODO: use the data to create a healthcare specialist object via constructor
//            HealthcareSpecialistNode tempSepcialist = new HealthcareSpecialistNode();
//            healthcareSpecialistList.add(tempSepcialist);
//        }
//        specialistDataScanner.close();

        //Setup stage, scene, and window8
        primaryStage.setResizable(false);
        window = primaryStage;
        mainPane = new MainPane();

        scene1 = new Scene(mainPane, 1280, 720);
        scene1.getStylesheets().add("theme.css");

        window.setScene(scene1);
        window.setTitle("ConnectMD | Log In");
//        window.show();
        System.out.println("Application started");
    }

    //Method to run on application stop
    public void stop(){
        System.out.println("Application stopped");
    }

    //Create pane that will be overwritten for every scene change
    public class MainPane extends StackPane {
            public MainPane() throws FileNotFoundException {

            this.getChildren().add(new LoginPane());
        }
    }
}
