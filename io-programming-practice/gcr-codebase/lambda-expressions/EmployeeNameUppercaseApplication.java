import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class EmployeeNameUppercaseApplication {
    public static void main(String[] args) {
        // List of employee names
        List<String> employeeNames = Arrays.asList(
                "Bharat Trivedi",
                "Ananya Sharma",
                "Rohit Mehta",
                "Neha Verma"
        );
        // Converts all employee names to uppercase using method reference
        List<String> upperCaseNames = employeeNames.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        // Prints names formatted for HR letter
        upperCaseNames.forEach(System.out::println);
    }
}
