import javafx.scene.control.Alert;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Random;


public class HealthCarePortalSystem extends Main
{
    private static AuthenticationSystem authenticationSystem = new AuthenticationSystem();

    //Note: this method is just for Luke to play around with and will be
    // removed in the final version.
    public static void changeSceneTest() {
        try {
            mainPane.getChildren().removeAll();
            mainPane.getChildren().add(new PatientWelcomePane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            System.out.println("You broke it");
            e.printStackTrace();
        }
    }

    public static void registerPatient(String newFirstName, String newLastName, LocalDate newDOB, String newProviderPref)
    {
        PatientNode newPatient;

        //TODO: here we need to add this patient's new ID to that specific specialist's list of patients
        // Along with the the doctor's nurse's array of patients

        int providerIndex = -1;
        providerIndex = findProviderByTitleName(newProviderPref);

        Random rnd = new Random();
        int n = 1000000 + rnd.nextInt(9999999);

        String patientID = "P" + n;
        LocalDate birthDate = newDOB;
        String firstName = newFirstName;
        String lastName = newLastName;
        String homeAddress = "";
        String pharmacyName = "";
        String pharmacyAddress = "";
        String insuranceName = "";
        String insuranceID = "";
        int phoneNumber = 0;
        HealthcareSpecialistNode provider = healthcareSpecialistList.get(providerIndex);

        newPatient = new PatientNode(patientID, firstName, lastName, homeAddress, pharmacyName, pharmacyAddress,
                insuranceName, insuranceID, phoneNumber, birthDate, provider); // create and initialize all attributes of new patient

       patientList.add(newPatient); // add new patient to array list of type patient

    }

    public static void loginPatient(String firstName, String lastName, LocalDate dob)
    {
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

    public static void loginSpecialist(String userName, String password)
    {
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

    public static void showCreateAccountPane(){
        mainPane.getChildren().removeAll();
        mainPane.getChildren().add(new NewPatientPane());
        System.out.println("Scene changed");
    }


    public void sendMessage(String to, String from, String subject, String body)
    {
        Message newMessage;
        newMessage = new Message(to, from, subject, body); // creates new message with previously initialized members

        messages.add(0, newMessage); // adds message to head of Array List
    }

    public void viewMessage()
    {
        //TODO get fucked

    }

    public void editPatientHealthHistory()
    {
        // TODO how do we select what is to be edited
    }

    public void enterPatientVitals(String patientFirstName, String patientLastName, float weight, float temp, int heightFeet, int heightInch, String bloodPressure)
    {
        Visit newVisit = new Visit();
        int patientIndex = -1;

        newVisit.updateVitals(weight, heightFeet, heightInch, temp, bloodPressure);

        patientIndex = findPatient(patientFirstName, patientLastName);

        if(patientIndex != -1)
            patientList.get(patientIndex).visits.add(0, newVisit);
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

    public static void editPatientInfoPatient(String newPharmacyName, String newPharmacyAddress, int newPhoneNumber, String newHomeAddress, String newInsuranceName, String newInsuranceID)
    {

        int patientIndex = -1;


        patientIndex = findPatient(currentPatient.getFirstName(), currentPatient.getLastName());  // finds patient in array list

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

    public void viewPatientInfoSpecialist()
    {
        // change panes and pull info for said patient

    }

    public void viewPatientInfoPatient()
    {


    }

    public void viewVisitSummary()
    {

    }

    public void prescribeMedication(String patientFirstName, String patientLastName, String prescriptionName)
    {
        Visit tempVisitNode = new Visit();
        int visitIndex;

        int patientIndex = -1;

        patientIndex = findPatient(patientFirstName,patientLastName);

        if(patientIndex != -1)
        {
            visitIndex = patientList.get(patientIndex).visits.indexOf(tempVisitNode.getVisitDate().equals(LocalDate.now()));
            patientList.get(patientIndex).visits.get(visitIndex).prescribeMedication(prescriptionName);
        }

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

        try {
            mainPane.getChildren().removeAll();
            mainPane.getChildren().add(new PatientWelcomePane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            System.out.println("You broke it");
            e.printStackTrace();
        }
    }


    //Helper Methods
    public static int findPatient(String firstName, String lastName)
    {
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

    public static void logOutUser(){
        currentPatient = null;
        currentHealthcareSpecialist = null;
        try {
            mainPane.getChildren().removeAll();
            mainPane.getChildren().add(new LoginPane());
            System.out.println("Scene changed");
        } catch (FileNotFoundException e) {
            System.out.println("You broke it");
            e.printStackTrace();
        }
    }

}