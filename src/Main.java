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
    public static ArrayList<PatientNode> patientList = new ArrayList<>();
    public static ArrayList<HealthcareSpecialistNode> healthcareSpecialistList = new ArrayList<>();
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
            String providerID = patientDataScanner.nextLine();
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

        Scanner doctorDataScanner = new Scanner(new File("src/doctorData.txt"));
        while (doctorDataScanner.hasNext()){
            String doctorID = doctorDataScanner.nextLine();
            String username = doctorDataScanner.nextLine();
            String password = doctorDataScanner.nextLine();
            String doctorFirstName = doctorDataScanner.nextLine();
            String doctorLastName = doctorDataScanner.nextLine();
            String drTitle = doctorDataScanner.nextLine();
            String type = doctorDataScanner.nextLine();

            HealthcareSpecialistNode newDoctor = new HealthcareSpecialistNode(doctorID, doctorFirstName, doctorLastName, username, password, drTitle, type);
            healthcareSpecialistList.add(newDoctor);

            while (doctorDataScanner.hasNextLine()){
                String tempString = doctorDataScanner.nextLine();
                if (!tempString.equals("#")) {
                    if (tempString.contains("P")){
                        PatientNode tempPatient = findPatientByID(tempString);
                        healthcareSpecialistList.get(healthcareSpecialistList.size()-1).addPatient(tempPatient);
                    } else{
                        healthcareSpecialistList.get(healthcareSpecialistList.size()-1).addNurseID(tempString);
                    }
                } else {
                    break;
                }
            }
        }
        doctorDataScanner.close();


        Scanner nurseDataScanner = new Scanner(new File("src/nurseData.txt"));
        while (nurseDataScanner.hasNext()){
            String doctorID = nurseDataScanner.nextLine();
            String username = nurseDataScanner.nextLine();
            String password = nurseDataScanner.nextLine();
            String doctorFirstName = nurseDataScanner.nextLine();
            String doctorLastName = nurseDataScanner.nextLine();
            String drTitle = nurseDataScanner.nextLine();
            String type = nurseDataScanner.nextLine();

            HealthcareSpecialistNode newNurse = new HealthcareSpecialistNode(doctorID, doctorFirstName, doctorLastName, username, password, drTitle, type);
            healthcareSpecialistList.add(newNurse);

            String garbageData = nurseDataScanner.nextLine();
        }
        nurseDataScanner.close();

        for (int i = 0; i < healthcareSpecialistList.size(); i++){
            for(int j = 0; j < healthcareSpecialistList.size(); j++){
                if (healthcareSpecialistList.get(i).getType().equals("Doctor")){
                    if (healthcareSpecialistList.get(i).getNurseIDS().contains(healthcareSpecialistList.get(j).getProviderID())){
                        healthcareSpecialistList.get(j).addPatient(healthcareSpecialistList.get(i).getPatientIDs().get(0));
                    }
                }

            }
        }


        for (int i = 0; i < patientList.size(); i++){
            for(int j = 0; j < healthcareSpecialistList.size(); j++){
                if(healthcareSpecialistList.get(j).getPatientIDs().contains(patientList.get(i))){
                    patientList.get(i).setProvider(healthcareSpecialistList.get(j));
                    break;
                }
            }
        }

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
        //TODO; save data to file
    }

    //Create pane that will be overwritten for every scene change
    public class MainPane extends StackPane {
            public MainPane() throws FileNotFoundException {

            this.getChildren().add(new LoginPane());
        }
    }

    public HealthcareSpecialistNode findProviderByID(String providerID){
        for (HealthcareSpecialistNode provider : healthcareSpecialistList){
            if (provider.getProviderID().equals(providerID)){
                return provider;
            }
        }
        return null;
    }

    public PatientNode findPatientByID(String patientID){
        for (PatientNode patient : patientList){
            if (patient.getPatientID().equals(patientID)){
                return patient;
            }
        }
        return null;
    }

    public static PatientNode findPatientByName(String patientName){
        for (PatientNode patient : patientList){
            String fullNameTemp = patient.getFirstName() + " " + patient.getLastName();
            if (fullNameTemp.equals(patientName)){
                return patient;
            }
        }
        return null;
    }
}
