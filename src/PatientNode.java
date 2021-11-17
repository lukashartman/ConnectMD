import java.time.LocalDate;
import java.util.ArrayList;

public class PatientNode {
    //DECLARING VARIABLES
    private String patientID;
    private String providerID;
    private String firstName;
    private String lastName;
    private String homeAddress;
    private String pharmacyName;
    private String pharmacyAddress;
    private String insuranceName;
    private String insuranceID;
    private String phoneNumber;
    private LocalDate birthDate;
    private HealthcareSpecialistNode provider;
    ArrayList<Visit> visits;

    //CONSTRUCTOR
    public PatientNode(String newPatientID, String newProviderID, String newFirstName, String newLastName, String newHomeAddress,
                   String newPharmacyName, String newPharmacyAddress, String newInsuranceName,
                       String newInsuranceID, String newPhoneNumber,
                   LocalDate newBirthDate)
    {
        patientID = newPatientID;
        providerID = newProviderID;
        firstName = newFirstName;
        lastName = newLastName;
        homeAddress = newHomeAddress;
        pharmacyName = newPharmacyName;
        pharmacyAddress = newPharmacyAddress;
        insuranceName = newInsuranceName;
        insuranceID = newInsuranceID;
        phoneNumber = newPhoneNumber;
        birthDate = newBirthDate;
        visits = new ArrayList<Visit>();

    }

    //GETTERS
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getHomeAddress() {return homeAddress;}
    public String getPharmacyName() {return pharmacyName;}
    public String getPharmacyAddress()
    {
        return pharmacyAddress;
    }
    public String getInsuranceName() {return insuranceName;}
    public String getInsuranceID() {return insuranceID;}
    public String getPhoneNumber() {return phoneNumber;}
    public LocalDate getBirthDate()
    {
        return birthDate;
    }
    public String getPatientID() {return patientID;}
    public String getProviderID() {return providerID;}
    public HealthcareSpecialistNode getHealthCareSpecialist() {return provider;}

    //SETTERS
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setHomeAddress(String homeAddress)
    {
        this.homeAddress = homeAddress;
    }
    public void setPharmacyName(String pharmacyName)
    {
        this.pharmacyName = pharmacyName;
    }
    public void setPharmacyAddress(String pharmacyAddress)
    {
        this.pharmacyAddress = pharmacyAddress;
    }
    public void setInsuranceName(String insuranceName)
    {
        this.insuranceName = insuranceName;
    }
    public void setInsuranceID(String insuranceID)
    {
        this.insuranceID = insuranceID;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }
    public void setProvider(HealthcareSpecialistNode newProvider){
        this.provider = newProvider;
        providerID = newProvider.getProviderID();
    }
}
