import java.time.LocalDate;

public class Visit
{
    private LocalDate visitDate;
    private float weight;
    private int heightFt;
    private int heightIn;
    private float bodyTemp;
    private String bloodPressure;
    private String physicalExamNotes, knownAllergies, healthIssues, medications, immunizations, notes;

    public Visit()
    {
        visitDate = LocalDate.now();
        weight = 0;
        heightFt = 0;
        heightIn = 0;
        bodyTemp = 0;
        bloodPressure = "";
        physicalExamNotes = "";
        knownAllergies = "";
        healthIssues = "";
        medications = "";
        immunizations = "";
        notes = "";
    }

    public void updateVitals(float weight, int heightFt, int heightIn, float bodyTemp, String bloodPressure)
    {
        this.weight = weight;
        this.heightFt = heightFt;
        this.heightIn = heightIn;
        this.bodyTemp = bodyTemp;
        this.bloodPressure = bloodPressure;
    }

    public void updateHealthHistory(String knownAllergies, String healthIssues)
    {
        this.knownAllergies = knownAllergies;
        this.healthIssues += " " + healthIssues;
    }

    public void prescribeMedication(String medication)
    {
        medications = medication;
    }

    // getters
    public LocalDate getVisitDate() {return visitDate;}
    public float getWeight(){return weight;}
    public int getHeightFt(){return heightFt;}
    public int getHeightIn(){return heightIn;}
    public float getBodyTemp(){return bodyTemp;}
    public String getBloodPressure(){return bloodPressure;}
    public String getPhysicalExamNotes(){return physicalExamNotes;}
    public String getKnownAllergies(){return knownAllergies;}
    public String getHealthIssues(){return healthIssues;}
    public String getMedications(){return medications;}
    public String getImmunizations(){return immunizations;}
    public String getNotes(){return notes;}

}
