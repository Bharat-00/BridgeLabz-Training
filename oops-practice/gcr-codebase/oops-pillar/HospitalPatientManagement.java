import java.util.ArrayList;
import java.util.List;
/* -------------------- INTERFACE -------------------- */
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}
/* -------------------- ABSTRACT CLASS -------------------- */
abstract class Patient {
    // Encapsulated fields
    private final int patientId;
    private final String name;
    private final int age;
    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    // Abstract method
    public abstract double calculateBill();
    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
    }
}
/* -------------------- IN PATIENT -------------------- */
class InPatient extends Patient implements MedicalRecord {
    private final int daysAdmitted;
    private final double dailyCharge;
    private final List<String> medicalHistory = new ArrayList<>();
    public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }
    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }
    @Override
    public void viewRecords() {
        System.out.println("Medical Records: " + medicalHistory);
    }
}
/* -------------------- OUT PATIENT -------------------- */
class OutPatient extends Patient implements MedicalRecord {
    private final double consultationFee;
    private final List<String> medicalHistory = new ArrayList<>();
    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }
    @Override
    public double calculateBill() {
        return consultationFee;
    }
    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }
    @Override
    public void viewRecords() {
        System.out.println("Medical Records: " + medicalHistory);
    }
}
/* -------------------- MAIN CLASS -------------------- */
public class HospitalPatientManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        InPatient p1 = new InPatient(1, "Rohit Kumar", 35, 5, 2000);
        OutPatient p2 = new OutPatient(2, "Anjali Sharma", 28, 800);
        p1.addRecord("Admitted for Surgery");
        p2.addRecord("General Checkup");
        patients.add(p1);
        patients.add(p2);
        System.out.println("===== Patient Billing Details =====");
        // Polymorphism
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill : ₹" + patient.calculateBill());
            if (patient instanceof MedicalRecord medicalRecord) {
                medicalRecord.viewRecords();
            }
            System.out.println("---------------------------------");
        }
    }
}
