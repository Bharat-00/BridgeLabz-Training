import java.util.Scanner;
import java.util.regex.Pattern;
public class UsernameValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";
        if (Pattern.matches(regex, username)) {
            System.out.println("Valid username");
        } else {
            System.out.println("Invalid username");
        }
        scanner.close();
    }
}
