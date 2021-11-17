import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    public static ArrayList<Message> messages = new ArrayList<>();

    public static HealthcareSpecialistNode currentHealthcareSpecialist = null; // current healthcare specialist that is logged in
    public static PatientNode currentPatient = null; // current patient that is logged in

    public static LocalDate currentVisitDate = null;

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
            String patientPhoneNumber = patientDataScanner.nextLine();
            LocalDate patientDOB = LocalDate.parse(patientDataScanner.nextLine());

            PatientNode patient = new PatientNode(patientID, providerID, patientFirstName, patientLastName, patientAddress, pharmacyName, pharmacyAddress, insuranceName, insuranceID, patientPhoneNumber, patientDOB);
            patientList.add(patient);

            while (patientDataScanner.hasNextLine()){
                String tempString = patientDataScanner.nextLine();
                if (!tempString.equals("#")) {
                    LocalDate visitDate = LocalDate.parse(tempString);
                    float weight = Float.parseFloat(patientDataScanner.nextLine());
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
                        PatientNode tempPatient = HealthCarePortalSystem.findPatientByID(tempString);
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

        HealthCarePortalSystem.syncDoctorAndNursePatients();


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
    public void stop() throws IOException {
        System.out.println("Starting writing");

        File patientDataCreator = new File("src/patientData.txt");
        patientDataCreator.createNewFile();
        File patientData = new File("src/patientData.txt");
        FileWriter patientDataWriter = new FileWriter(patientData);
        for (int i = 0; i < patientList.size(); i++){
            patientDataWriter.write(patientList.get(i).getPatientID() + "\n");
            patientDataWriter.write(patientList.get(i).getProviderID() + "\n");
            patientDataWriter.write(patientList.get(i).getFirstName() + "\n");
            patientDataWriter.write(patientList.get(i).getLastName() + "\n");
            patientDataWriter.write(patientList.get(i).getHomeAddress() + "\n");
            patientDataWriter.write(patientList.get(i).getPharmacyName() + "\n");
            patientDataWriter.write(patientList.get(i).getPharmacyAddress() + "\n");
            patientDataWriter.write(patientList.get(i).getInsuranceName() + "\n");
            patientDataWriter.write(patientList.get(i).getInsuranceID() + "\n");
            patientDataWriter.write(patientList.get(i).getPhoneNumber() + "\n");
            patientDataWriter.write(patientList.get(i).getBirthDate() + "\n");

            for (int j = 0; j < patientList.get(i).visits.size(); j++){
                patientDataWriter.write(patientList.get(i).visits.get(j).getVisitDate() + "\n");
                patientDataWriter.write(patientList.get(i).visits.get(j).getWeight() + "\n");
                patientDataWriter.write(patientList.get(i).visits.get(j).getHeightFt() + "\n");
                patientDataWriter.write(patientList.get(i).visits.get(j).getHeightIn() + "\n");
                patientDataWriter.write(patientList.get(i).visits.get(j).getBodyTemp() + "\n");
                patientDataWriter.write(patientList.get(i).visits.get(j).getBloodPressure() + "\n");
                patientDataWriter.write(patientList.get(i).visits.get(j).getPhysicalExamNotes() + "\n");
                patientDataWriter.write(patientList.get(i).visits.get(j).getKnownAllergies() + "\n");
                patientDataWriter.write(patientList.get(i).visits.get(j).getHealthIssues() + "\n");
                patientDataWriter.write(patientList.get(i).visits.get(j).getMedications() + "\n");
                patientDataWriter.write(patientList.get(i).visits.get(j).getImmunizations() + "\n");
                patientDataWriter.write(patientList.get(i).visits.get(j).getNotes() + "\n");
            }
            patientDataWriter.write("#\n");
        }
        patientDataWriter.close();

        File nurseDataCreator = new File("src/nurseData.txt");
        nurseDataCreator.createNewFile();
        File nurseData = new File("src/nurseData.txt");
        FileWriter nurseDataWriter = new FileWriter(nurseData);
        for (int i = 0; i < healthcareSpecialistList.size(); i++){
            if (healthcareSpecialistList.get(i).getType().equals("Nurse")){
                nurseDataWriter.write(healthcareSpecialistList.get(i).getProviderID() + "\n");
                nurseDataWriter.write(healthcareSpecialistList.get(i).getUsername() + "\n");
                nurseDataWriter.write(healthcareSpecialistList.get(i).getPassword() + "\n");
                nurseDataWriter.write(healthcareSpecialistList.get(i).getFirstName() + "\n");
                nurseDataWriter.write(healthcareSpecialistList.get(i).getLastName() + "\n");
                nurseDataWriter.write(healthcareSpecialistList.get(i).getTitleName() + "\n");
                nurseDataWriter.write(healthcareSpecialistList.get(i).getType() + "\n");
                nurseDataWriter.write("#\n");
            }
        }
        nurseDataWriter.close();

        File doctorDataCreator = new File("src/doctorData.txt");
        doctorDataCreator.createNewFile();
        File doctorData = new File("src/doctorData.txt");
        FileWriter doctorDataWriter = new FileWriter(doctorData);
        for (int i = 0; i < healthcareSpecialistList.size(); i++){
            if (healthcareSpecialistList.get(i).getType().equals("Doctor")){
                doctorDataWriter.write(healthcareSpecialistList.get(i).getProviderID() + "\n");
                doctorDataWriter.write(healthcareSpecialistList.get(i).getUsername() + "\n");
                doctorDataWriter.write(healthcareSpecialistList.get(i).getPassword() + "\n");
                doctorDataWriter.write(healthcareSpecialistList.get(i).getFirstName() + "\n");
                doctorDataWriter.write(healthcareSpecialistList.get(i).getLastName() + "\n");
                doctorDataWriter.write(healthcareSpecialistList.get(i).getTitleName() + "\n");
                doctorDataWriter.write(healthcareSpecialistList.get(i).getType() + "\n");
                for (int j = 0; j < healthcareSpecialistList.get(i).getPatientIDs().size(); j++){
                    doctorDataWriter.write(healthcareSpecialistList.get(i).getPatientIDs().get(j).getPatientID() + "\n");
                }

                for (int j = 0; j < healthcareSpecialistList.get(i).getNurseIDS().size(); j++){
                    doctorDataWriter.write(healthcareSpecialistList.get(i).getNurseIDS().get(j) + "\n");
                }
                doctorDataWriter.write("#\n");
            }
        }
        doctorDataWriter.close();


        System.out.println("Finished writing");
    }

    //Create pane that will be overwritten for every scene change
    public class MainPane extends StackPane {
            public MainPane() throws FileNotFoundException {

            this.getChildren().add(new LoginPane());
        }
    }

}
