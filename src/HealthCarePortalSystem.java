import jdk.vm.ci.meta.Local;
import sun.util.resources.LocaleData;

import java.io.FileNotFoundException;
import java.time.LocalDate;


public class HealthCarePortalSystem extends Main
{
    AuthenticationSystem authenticationSystem = new AuthenticationSystem();


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

    public void registerPatient()
    {
        PatientNode newPatient;

        LocalDate birthDate;
        String firstName = "";
        String lastName = "";
        String username = "";
        String password = "";
        String homeAddress = "";
        String pharmacyName = "";
        String pharmacyAddress = "";
        String insuranceName = "";
        String insuranceAddress = "";
        integer phoneNumber = 0;
        birthDate = LocalDate.of(2000, 1, 1);


        newPatient = new Patient(userName, password, firstName, lastName, homeAddress, pharmacyName, pharmacyAddress,
                insuranceName, phoneNumber, birthDate); // create and initialize all attributes of new patient

       patientList.add(newPatient); // add new patient to array list of type patient

    }

    public void loginPatient(String firstName, String lastName, LocalDate dob)
    {
        int status = 0;

        status = authenticationSystem.loginPatientAuthentication(firstName, lastName, dob); //patient login request; returns status (yes or no)

        if(status != -1)
            currentPatient = patientList.get(status);

    }

    public void loginSpecialist(String userName, String password)
    {
        int status = 0;

        status = authenticationSystem.loginSpecialistAuthentication(userName, password); //specialist login request; returns status (yes or no)

        if(status != -1)
            currentHealthcareSpecialist = healthcareSpecialistList.get(status);

        // if true , switch pane
        // if not, do nothing
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

    public void editPatientInfoPatient(String firstName, String lastName)
    {
        int patientIndex = -1;





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

    public int findPatient(String firstName, String lastName)
    {
        int index = -1;

        for(int i = 0; i < patientList.size(); i++)
            if(patientList.get(i).getFirstName().equals(firstName) && patientList.get(i).getLastName().equals(lastName))
                index = i;

            return index;
    }



}