import java.time.LocalDate;

public class AuthenticationSystem extends HealthCarePortalSystem
{
    public int loginPatient(String firstName, String lastName, LocalDate dob)
    {
        int status = -1;

        for(int i = 0; i < patientList.size(); i++){
            if (patientList.get(i).equals(firstName) && patientList.get(i).equals(lastName) && patientList.get(i).equals(dob)){
                status = i;
            }
        }

        return status;
    }

    public int loginSpecialist(String userName, String password)
    {
        int status = -1;
        for(int i = 0; i < healthcareSpecialistList.size(); i++){
            if (healthcareSpecialistList.get(i).equals(userName) && healthcareSpecialistList.get(i).equals(password)){
                status = i;
            }
        }

        return status;
    }


}
