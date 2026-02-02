import java.util.Scanner;
import java.util.regex.Pattern;
public class LicensePlateValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter license plate number: ");
        String plate = scanner.nextLine();
        String regex = "^[A-Z]{2}[0-9]{4}$";
        if (Pattern.matches(regex, plate)) {
            System.out.println("Valid license plate");
        } else {
            System.out.println("Invalid license plate");
        }
        scanner.close();
    }
}
