import java.util.ArrayList;
import java.util.List;
public class HospitalAdminApplication {
    public static void main(String[] args) {
        // Stores all hospital patient IDs
        List<Integer> patientIdList = new ArrayList<>();
        patientIdList.add(1001);
        patientIdList.add(1002);
        patientIdList.add(1003);
        patientIdList.add(1004);
        patientIdList.add(1005);
        // Triggers printing of patient IDs for admin verification
        printPatientIds(patientIdList);
    }
    private static void printPatientIds(List<Integer> patientIds) {
        // Handles null or empty patient list safely
        if (patientIds == null || patientIds.isEmpty()) {
            System.out.println("No patient records found.");
            return;
        }
        // Displays patient IDs header
        System.out.println("Patient IDs for verification:");
        // Method reference used instead of lambda expression
        patientIds.forEach(System.out::println);
    }
}
