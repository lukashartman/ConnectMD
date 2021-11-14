import java.time.LocalDate;

public class AuthenticationSystem extends HealthCarePortalSystem
{
    public int loginPatientAuthentication(String firstName, String lastName, LocalDate dob)
    {
        int status = -1;
        for(int i = 0; i < patientList.size(); i++)
        {
            if (patientList.get(i).getFirstName().equals(firstName) && patientList.get(i).getLastName().equals(lastName) && patientList.get(i).getBirthDate().equals(dob))
                status = i;
        }

        return status;
    }

    public int loginSpecialistAuthentication(String userName, String password)
    {
        int status = -1;
        for(int i = 0; i < healthcareSpecialistList.size(); i++)
        {
            if (healthcareSpecialistList.get(i).getUsername().equals(userName) && healthcareSpecialistList.get(i).getPassword().equals(password))
                status = i;
        }

        return status;
    }


}
