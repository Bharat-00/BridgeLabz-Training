// Interface for bill calculation
interface IPayable {
    double calculateBill();
}
// Doctor class
class Doctor {
    private final String doctorName;
    private final String specialization;
    public Doctor(String doctorName, String specialization) {
        this.doctorName = doctorName;
        this.specialization = specialization;
    }
    public String getDoctorName() {
        return doctorName;
    }
}
// Abstract Patient class
abstract class Patient {
    private final int patientId;
    private final String name;
    private final int age;
    protected Doctor doctor;
    public Patient(int patientId, String name, int age, Doctor doctor) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.doctor = doctor;
    }
    public int getPatientId() {
        return patientId;
    }
    public abstract void displayInfo();
}
// InPatient class
class InPatient extends Patient implements IPayable {
    private final int daysAdmitted;
    private final double dailyCharge;
    public InPatient(int id, String name, int age, Doctor doctor, int daysAdmitted, double dailyCharge) {
        super(id, name, age, doctor);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }
    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }
    @Override
    public void displayInfo() {
        System.out.println("InPatient ID: " + getPatientId() +
                ", Doctor: " + doctor.getDoctorName() +
                ", Bill: ₹" + calculateBill());
    }
}
// OutPatient class
class OutPatient extends Patient implements IPayable {
    private final double consultationFee;
    public OutPatient(int id, String name, int age, Doctor doctor, double fee) {
        super(id, name, age, doctor);
        this.consultationFee = fee;
    }
    @Override
    public double calculateBill() {
        return consultationFee;
    }
    @Override
    public void displayInfo() {
        System.out.println("OutPatient ID: " + getPatientId() +
                ", Doctor: " + doctor.getDoctorName() +
                ", Bill: ₹" + calculateBill());
    }
}
// Main class
public class HospitalPatientManagementSystem {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("Dr. Sharma", "Cardiology");
        Patient p1 = new InPatient(101, "Rahul", 30, doctor, 5, 2000);
        Patient p2 = new OutPatient(102, "Anita", 25, doctor, 500);
        p1.displayInfo();
        p2.displayInfo();
    }
}
