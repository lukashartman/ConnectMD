public class AuthenticationSystem extends HealthCarePortalSystem
{
    public boolean loginPatient(String firstName, String lastName, String dob)
    {
        for(int i = 0; i < patientList.size(); i++){
            if (patientList.get(i).equals(firstName) && patientList.get(i).equals(lastName) && patientList.get(i).equals(dob)){
                return true;
            }
        }

        return false;
    }

    public boolean loginSpecialist(String userName, String password)
    {
        for(int i = 0; i < healthcareSpecialistList.size(); i++){
            if (healthcareSpecialistList.get(i).equals(userName) && healthcareSpecialistList.get(i).equals(password)){
                return true;
            }
        }
        return false;
    }


}
