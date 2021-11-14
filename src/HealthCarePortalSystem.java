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

        // get info that was entered into pane fields

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

        newVisit.updateVitals(weight, heightFeet, heightInch, temp, bloodPressure);

        for(int i = 0; i < patientList.size(); i++)
            if(patientList.get(i).getFirstName().equals(patientFirstName) && patientList.get(i).getLastName().equals(patientLastName)
                patientList.get(i).visits.add(0, newVisit);
s
    }

    public void editPatientInfoPatient()
    {


    }

    public void viewPatientInfoSpecialist()
    {


    }

    public void viewPatientInfoPatient()
    {


    }

    public void viewVisitSummary()
    {

    }

    public void prescribeMedication()
    {

    }



}