//Patient Node to store data

import java.util.Date;

public class PatientNode {
    //DECLARING VARIABLES
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String homeAddress;
    private final String pharmacyName;
    private final String pharmacyAddress;
    private final String insuranceName;
    private final Integer phoneNumber;
    private final Date birthDate;

    //CONSTRUCTOR
    public PatientNode(String newUsername, String newPassword, String newFirstName, String newLastName, String newHomeAddress,
                   String newPharmacyName,  String newPharmacyAddress,String newInsuranceName, Integer newPhoneNumber,
                   Integer newBirthDate)
    {
        firstName = firstNameField.getText();
        lastName = "";
        username = "";
        password = "";
        homeAddress = "";
        pharmacyName = "";
        pharmacyAddress = "";
        insuranceName = "";
        phoneNumber = 0;
        birthDate = new Date(2000,1,1);

    }

    //GETTERS
    public String getUsername() {return username;}
    public String getPassword() {return password;}
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
    public Integer getPhoneNumber() {return phoneNumber;}
    public Date getBirthDate()
    {
        return birthDate;
    }

    //SETTERS
    public String setUsername() {return username;}
    public String setPassword() {return password;}
    public String setFirstName()
    {
        return firstName;
    }
    public String setLastName()
    {
        return lastName;
    }
    public String setHomeAddress() {return homeAddress;}
    public String setPharmacyName() {return pharmacyName;}
    public String setPharmacyAddress()
    {
        return pharmacyAddress;
    }
    public String setInsuranceName() {return insuranceName;}
    public Integer setPhoneNumber() {return phoneNumber;}
    public Date setBirthDate()
    {
        return birthDate;
    }
}
