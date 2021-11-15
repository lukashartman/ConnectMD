import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {

    //Instance Variables
    protected static Stage window;
    protected static Scene scene1;
    protected static Pane mainPane;
    public static ArrayList<PatientNode> patientList = new ArrayList<PatientNode>();
    public static ArrayList<HealthcareSpecialistNode> healthcareSpecialistList;
    public static ArrayList<Message> messages;

    public static HealthcareSpecialistNode currentHealthcareSpecialist; // current healthcare specialist that is logged in
    public static PatientNode currentPatient; // current patient that is logged in

    //Method to launch application
    public static void main(String[] args){
        launch(args);
    }

    //Method to display application
    public void start (Stage primaryStage) throws FileNotFoundException {

        System.out.println("Starting Patient Data Input");
        Scanner patientDataScanner = new Scanner(new File("src/patientData.txt"));
        while (patientDataScanner.hasNextLine()){
            String patientID = patientDataScanner.nextLine();
            String patientFirstName = patientDataScanner.nextLine();
            String patientLastName = patientDataScanner.nextLine();
            String patientAddress = patientDataScanner.nextLine();
            String pharmacyName = patientDataScanner.nextLine();
            String pharmacyAddress = patientDataScanner.nextLine();
            String insuranceName = patientDataScanner.nextLine();
            String insuranceID = patientDataScanner.nextLine();
            int patientPhoneNumber = Integer.parseInt(patientDataScanner.nextLine().substring(0, 9));
            LocalDate patientDOB = LocalDate.parse(patientDataScanner.nextLine());
            PatientNode patient = new PatientNode(patientID, patientFirstName, patientLastName, patientAddress, pharmacyName, pharmacyAddress, insuranceName, insuranceID, patientPhoneNumber, patientDOB);
            patientList.add(patient);

            while (patientDataScanner.hasNextLine()){
                String tempString = patientDataScanner.nextLine();
                if (!tempString.equals("#")) {
                    LocalDate visitDate = LocalDate.parse(tempString);
                    int weight = Integer.parseInt(patientDataScanner.nextLine());
                    int heightFt = Integer.parseInt(patientDataScanner.nextLine());
                    int heightIn = Integer.parseInt(patientDataScanner.nextLine());
                    float bodyTemp = Float.parseFloat(patientDataScanner.nextLine());
                    String bloodPressure = patientDataScanner.nextLine();
                    String physicalExam = patientDataScanner.nextLine();
                    String knownAllergies = patientDataScanner.nextLine();
                    String healthIssues = patientDataScanner.nextLine();
                    String medications = patientDataScanner.nextLine();
                    String immunizations = patientDataScanner.nextLine();
                    String notes = patientDataScanner.nextLine();
                    Visit tempVisit = new Visit(visitDate, weight, heightFt, heightIn, bodyTemp, bloodPressure, physicalExam, knownAllergies, healthIssues, medications, immunizations, notes);
                    patient.visits.add(tempVisit);
                } else {
                    break;
                    }
                }
            }
        patientDataScanner.close();
//
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
        window.setTitle("ConnectMD");
        window.show();
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
