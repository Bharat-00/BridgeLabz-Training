class AppointmentNotAvailableException extends Exception {
    public AppointmentNotAvailableException(String msg) {
        super(msg);
    }
}
interface HospitalService {
    double calculateFee();
}
class Person {
    String name;
}
class Patient extends Person implements HospitalService {
    @Override
    public double calculateFee() {
        return 500;
    }
}
class Doctor extends Person {
}
public class HospitalManagementSystem {
    public static void main(String[] args) {
        HospitalService p = new Patient();
        System.out.println("Consultation Fee: ₹" + p.calculateFee());
    }
}
