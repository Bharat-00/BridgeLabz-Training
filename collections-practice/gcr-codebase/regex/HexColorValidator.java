import java.util.Scanner;
import java.util.regex.Pattern;
public class HexColorValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hex color code: ");
        String color = scanner.nextLine();
        String regex = "^#[0-9A-Fa-f]{6}$";
        if (Pattern.matches(regex, color)) {
            System.out.println("Valid hex color");
        } else {
            System.out.println("Invalid hex color");
        }
        scanner.close();
    }
}
