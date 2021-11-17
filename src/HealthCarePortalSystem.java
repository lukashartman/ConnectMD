import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Random;


public class HealthCarePortalSystem extends Main {

    private static AuthenticationSystem authenticationSystem = new AuthenticationSystem();

    public static void registerPatient(String newFirstName, String newLastName, LocalDate newDOB, String newProviderPref) {
        PatientNode newPatient;

        int providerIndex = findProviderByTitleName(newProviderPref);

        Random rnd = new Random();
        int n = 1000000 + rnd.nextInt(9999999);

        String patientID = "P" + n;
        LocalDate birthDate = newDOB;
        String firstName = newFirstName;
        String lastName = newLastName;
        String homeAddress = "Not set";
        String pharmacyName = "Not set";
        String pharmacyAddress = "Not set";
        String insuranceName = "Not set";
        String insuranceID = "Not set";
        String phoneNumber = "0000000000";
        HealthcareSpecialistNode provider = healthcareSpecialistList.get(providerIndex);

        newPatient = new PatientNode(patientID, provider.getProviderID(), firstName, lastName, homeAddress, pharmacyName, pharmacyAddress,
                insuranceName, insuranceID, phoneNumber, birthDate); // create and initialize all attributes of new patient

        patientList.add(newPatient); // add new patient to array list of type patient
        healthcareSpecialistList.get(findProviderByTitleName(provider.getTitleName())).addPatient(newPatient);
        syncDoctorAndNursePatients();

        logOutUser();

    }

    public static void loginPatient(String firstName, String lastName, LocalDate dob) {
        int patientIndex = 0;

        patientIndex = authenticationSystem.loginPatientAuthentication(firstName, lastName, dob); //patient login request; returns status (yes or no)

        if(patientIndex != -1) {
            currentPatient = patientList.get(patientIndex);

            try {
                mainPane.getChildren().removeAll();
                mainPane.getChildren().add(new PatientWelcomePane());
                System.out.println("Scene changed");
            } catch (FileNotFoundException e) {
                System.out.println("You broke it");
                e.printStackTrace();
            }

        } else {
            System.out.println("Patient not found");

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Patient Not Found");
            alert.setHeaderText("There was an error finding the patient");
            alert.setContentText("Ensure all fields are filled and date is in the format of MM/DD/YYY");
            alert.showAndWait();

        }

    }

    public static void loginSpecialist(String userName, String password) {
        int specialistIndex = 0;

        specialistIndex = authenticationSystem.loginSpecialistAuthentication(userName, password); //specialist login request; returns status (yes or no)

        if(specialistIndex != -1){
            currentHealthcareSpecialist = healthcareSpecialistList.get(specialistIndex);


            try {
                mainPane.getChildren().removeAll();
                mainPane.getChildren().add(new SpecialistWelcomePane());
                System.out.println("Scene changed");
            } catch (FileNotFoundException e) {
                System.out.println("You broke it");
                e.printStackTrace();
            }

        } else {
            System.out.println("Specialist not found");

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Specialist Not Found");
            alert.setHeaderText("There was an error finding the specialist");
            alert.setContentText("Ensure all fields are filled");
            alert.showAndWait();

        }

    }

    public static void showSpecialistWelcomePane(){
        try {
            mainPane.getChildren().removeAll();
            mainPane.getChildren().add(new SpecialistWelcomePane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            System.out.println("You broke it");
            e.printStackTrace();
        }
    }

    public static void showCreateAccountPane(){
        mainPane.getChildren().removeAll();
        mainPane.getChildren().add(new NewPatientPane());
        System.out.println("Scene changed");
    }

    public static void sendMessage(String toID, String fromID, String subject, String body) {
        Message newMessage;
        newMessage = new Message(toID, fromID, subject, body); // creates new message with previously initialized members

        messages.add(0, newMessage); // adds message to head of Array List

        if (Main.currentHealthcareSpecialist == null){
            showPatientWelcomePane();
        } else {
            showSpecialistMessagesPane();
        }

    }

    public static void showSpecialistViewMessagePane(Message message) {
        mainPane.getChildren().clear();
        mainPane.getChildren().add(new SpecialistViewMessagePane(message));
        System.out.println("Scene changed");
    }


    public static void showPatientViewMessagePane(Message message) {
        mainPane.getChildren().clear();
        mainPane.getChildren().add(new PatientViewMessagePane(message));
        System.out.println("Scene changed");
    }

    public static void showSpecialistMessagesPane() {
        mainPane.getChildren().removeAll();
        try {
            mainPane.getChildren().add(new SpecialistAllMessagesPane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void showPatientViewAllMessagesPane(){
        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().add(new PatientAllMessagesPane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void showPatientSendMessagesPane(){
        mainPane.getChildren().removeAll();
        try {
            mainPane.getChildren().add(new PatientSendMessagesPane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void showVitalsPane(String nameOfPatient){
        Main.currentPatient = findPatientByName(nameOfPatient);
        currentPatient.visits.add(new Visit());
        Main.currentVisitDate = LocalDate.now();

        mainPane.getChildren().removeAll();
        try {
            mainPane.getChildren().add(new NurseViewPatientVitalsPane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void enterPatientVitals(float weight, float temp, int heightFeet, int heightInch, String bloodPressure) {
        Visit newVisit = new Visit();
        int patientIndex = -1;

        newVisit.updateVitals(weight, heightFeet, heightInch, temp, bloodPressure);

        patientIndex = findPatient(currentPatient.getFirstName(), currentPatient.getLastName());

        if(patientIndex != -1)
            patientList.get(patientIndex).visits.add(0, newVisit);

        showPatientHealthHistoryPane();

    }

    public static void showPatientInfoPane(){
        try {
            mainPane.getChildren().removeAll();
            mainPane.getChildren().add(new PatientInformationPane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            System.out.println("You broke it");
            e.printStackTrace();
        }
    }

    public static void editPatientInfoPatient(String newPharmacyName, String newPharmacyAddress, String newPhoneNumber, String newHomeAddress, String newInsuranceName, String newInsuranceID) {

        int patientIndex = findPatient(currentPatient.getFirstName(), currentPatient.getLastName());  // finds patient in array list

        try{
            String[] dividedAddress = newHomeAddress.split(",");
            String temp = dividedAddress[2];
        } catch (ArrayIndexOutOfBoundsException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incorrect Format");
            alert.setHeaderText("Your address is not in the correct format");
            alert.setContentText("Please place in format of 'Street Address, City, State, Zip Code' and try again");
            alert.showAndWait();
            return;
        }

        // updates patient information, overrides old info
        patientList.get(patientIndex).setPharmacyName(newPharmacyName);
        patientList.get(patientIndex).setPharmacyAddress(newPharmacyAddress);
        patientList.get(patientIndex).setHomeAddress(newHomeAddress);
        patientList.get(patientIndex).setPhoneNumber(newPhoneNumber);
        patientList.get(patientIndex).setInsuranceName(newInsuranceName);
        patientList.get(patientIndex).setInsuranceID(newInsuranceID);

        try {
            mainPane.getChildren().removeAll();
            mainPane.getChildren().add(new PatientWelcomePane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            System.out.println("You broke it");
            e.printStackTrace();
        }

    }

    public static void prescribeMedication() {
        int patientIndex = findPatient(Main.currentPatient.getFirstName(), Main.currentPatient.getLastName());

        TextInputDialog alert = new TextInputDialog();
        alert.setTitle("New Medication");
        alert.setHeaderText("Enter the name of the new medication to be prescribed");
        alert.showAndWait();

        if(patientIndex != -1)
        {
            patientList.get(patientIndex).visits.get(findIndexOfVisitDate(LocalDate.now())).prescribeMedication(alert.getEditor().getText());
        }

        Alert alert2 = new Alert(Alert.AlertType.NONE, "", ButtonType.OK);
        alert2.setHeaderText("Medication has been added to the patient's record and \n sent to pharmacy on file.");
        alert2.showAndWait();

        showPatientHealthHistoryPane(Main.currentPatient.getFirstName() + " " + Main.currentPatient.getLastName());

    }

    public static void showPatientProviderChangePane(){
        try {
            mainPane.getChildren().removeAll();
            mainPane.getChildren().add(new PatientProviderChange());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            System.out.println("You broke it");
            e.printStackTrace();
        }
    }

    public static void requestProviderChange(String newProviderName, String newProviderReason){
        int patientIndex = -1;
        patientIndex = findPatient(currentPatient.getFirstName(), currentPatient.getLastName());

        int providerIndex = -1;
        providerIndex = findProviderByTitleName(newProviderName);

        patientList.get(patientIndex).setProvider(healthcareSpecialistList.get(providerIndex));

        syncDoctorAndNursePatients();
        try {
            mainPane.getChildren().removeAll();
            mainPane.getChildren().add(new PatientWelcomePane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            System.out.println("You broke it");
            e.printStackTrace();
        }
    }

    public static void showPatientWelcomePane(){
        try {
            mainPane.getChildren().removeAll();
            mainPane.getChildren().add(new PatientWelcomePane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            System.out.println("You broke it");
            e.printStackTrace();
        }
    }

    public static void showPatientHealthHistoryPane(){
        System.out.println("Current Visit Date:" + Main.currentVisitDate);

        if (Main.currentPatient.visits.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("No health history found for this patient.");
            alert.showAndWait();
            return;
        }

        try {
            mainPane.getChildren().removeAll();
            mainPane.getChildren().add(new PatientHealthHistoryPane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            System.out.println("You broke it");
            e.printStackTrace();
        }
    }

    public static void showPatientHealthHistoryPane(String patientName){
        Main.currentPatient = findPatientByName(patientName);

        if (Main.currentPatient.visits.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.NONE, "", ButtonType.OK);
            alert.setHeaderText("No health history found for this patient.");
            alert.showAndWait();
            return;
        } else {
            Main.currentVisitDate = Main.currentPatient.visits.get(0).getVisitDate();
            System.out.println("Current Visit Date:" + Main.currentVisitDate);
        }


        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().add(new PatientHealthHistoryPane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            System.out.println("You broke it");
            e.printStackTrace();
        }
    }

    public static void logOutUser(){
        currentPatient = null;
        currentHealthcareSpecialist = null;
        Main.currentVisitDate = null;
        try {
            mainPane.getChildren().removeAll();
            mainPane.getChildren().add(new LoginPane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            System.out.println("You broke it");
            e.printStackTrace();
        }
    }

    //Helper Methods
    public static int findPatient(String firstName, String lastName) {
        int index = -1;

        for(int i = 0; i < patientList.size(); i++)
            if(patientList.get(i).getFirstName().equals(firstName) && patientList.get(i).getLastName().equals(lastName))
                index = i;

            return index;
    }

    public static int findProviderByTitleName(String providerName){
        int index = -1;

        for(int i = 0; i < Main.healthcareSpecialistList.size(); i++)
            if(healthcareSpecialistList.get(i).getTitleName().equals(providerName))
                index = i;

        return index;
    }

    public static HealthcareSpecialistNode findProviderByID(String providerID){
        for (HealthcareSpecialistNode provider : healthcareSpecialistList){
            if (provider.getProviderID().equals(providerID)){
                return provider;
            }
        }
        return null;
    }

    public static PatientNode findPatientByID(String patientID){
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

    public static int findIndexOfVisitDate(LocalDate visitDate){
        for (int i = 0; i < Main.currentPatient.visits.size(); i++){
            if (Main.currentPatient.visits.get(i).getVisitDate().equals(visitDate))
                return i;
        }
        return -1;
    }

    public static void syncDoctorAndNursePatients(){
        for (int i = 0; i < healthcareSpecialistList.size(); i++){
            for(int j = 0; j < healthcareSpecialistList.size(); j++){
                if (healthcareSpecialistList.get(i).getType().equals("Doctor") && healthcareSpecialistList.get(j).getType().equals("Nurse")){
                    if (healthcareSpecialistList.get(i).getNurseIDS().contains(healthcareSpecialistList.get(j).getProviderID())){
                        healthcareSpecialistList.get(j).setPatientIDs(healthcareSpecialistList.get(i).getPatientIDs());
                    }
                }

            }
        }
    }


}