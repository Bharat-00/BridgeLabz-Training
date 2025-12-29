import java.util.Scanner;
public class RemoveSpecificCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        System.out.print("Enter character to remove: ");
        char characterToRemove = scanner.next().charAt(0);
        String modifiedString = "";
        // Remove specified character
        for (int index = 0; index < inputString.length(); index++) {
            if (inputString.charAt(index) != characterToRemove) {
                modifiedString += inputString.charAt(index);
            }
        }
        System.out.println("Modified String: " + modifiedString);
    }
}
