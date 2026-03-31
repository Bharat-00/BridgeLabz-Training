import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;
    public Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }
    public String getSpecialty() { return specialty; }
    public boolean isAvailableOnWeekend() { return availableOnWeekend; }
    public String getName() { return name; }
}
public class DoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. A", "Cardiology", true),
                new Doctor("Dr. B", "Neurology", false),
                new Doctor("Dr. C", "Orthopedics", true),
                new Doctor("Dr. D", "Dermatology", true)
        );
        doctors.stream().filter(Doctor::isAvailableOnWeekend).sorted(Comparator.comparing(Doctor::getSpecialty)).forEach(d -> System.out.println(d.getName() + " - " + d.getSpecialty()));
    }
}
