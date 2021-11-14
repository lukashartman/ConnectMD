//Patient Node to store data

import java.time.LocalDate;
import java.util.ArrayList;

public class PatientNode {
    //DECLARING VARIABLES
    private String firstName;
    private String lastName;
    private String homeAddress;
    private String pharmacyName;
    private String pharmacyAddress;
    private String insuranceName;
    private String insuranceID;
    private int phoneNumber;
    private LocalDate birthDate;

    //CONSTRUCTOR
    public PatientNode(String newFirstName, String newLastName, String newHomeAddress,
                   String newPharmacyName, String newPharmacyAddress, String newInsuranceName,
                       String newInsuranceID int newPhoneNumber,
                   LocalDate newBirthDate)
    {
        firstName = newFirstName;
        lastName = newLastName;
        homeAddress = newHomeAddress;
        pharmacyName = newPharmacyName;
        pharmacyAddress = newPharmacyAddress;
        insuranceName = newInsuranceName;
        insuranceID = newInsuranceID;
        phoneNumber = newPhoneNumber;
        birthDate = newBirthDate;
        ArrayList<Visit> visits = new ArrayList<Visit>();

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
    public int getPhoneNumber() {return phoneNumber;}
    public LocalDate getBirthDate()
    {
        return birthDate;
    }

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
        this.pharmacyAddress = pharamcyAddress;
    }
    public void setInsuranceName(String insuranceName)
    {
        this.insuranceName = insuranceName;
    }

    public void setInsuranceID(String insuranceID)
    {
        this.insuranceID = insuranceID;
    }

    public void setPhoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }
}
