// Program to demonstrate Hospital Management System
// Concepts used: static, this, final, instanceof
// Patient class definition
class Patient {
    // Static variables
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;
    // Instance variables
    private final String patientID;   // final variable (unique identifier)
    private final String name;
    private final int age;
    private final String ailment;
    // Constructor using 'this' keyword
    public Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;              // increment patient count
    }
    // Static method to get total patients admitted
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
        System.out.println("Hospital Name: " + hospitalName);
    }
    // Method to display patient details
    public void displayPatientDetails() {
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }
}
// Main class
public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Creating Patient objects
        Patient patient1 = new Patient("P001", "Lathika", 30, "Flu");
        Patient patient2 = new Patient("P002", "Lidiya", 45, "Fracture");
        // Display total patients and hospital name
        Patient.getTotalPatients();
        // Checking instanceof before displaying details
        if (patient1 instanceof Patient) {
            System.out.println("Hospital Name: " + Patient.hospitalName);
            patient1.displayPatientDetails();
        }
        System.out.println();
        if (patient2 instanceof Patient) {
            System.out.println("Hospital Name: " + Patient.hospitalName);
            patient2.displayPatientDetails();
        }
    }
}
