import java.util.Scanner;
public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        char mostFrequentChar = ' ';
        int maxFrequency = 0;
        // Count frequency of each character
        for (int i = 0; i < inputString.length(); i++) {
            int count = 0;
            for (int j = 0; j < inputString.length(); j++) {
                if (inputString.charAt(i) == inputString.charAt(j)) {
                    count++;
                }
            }
            if (count > maxFrequency) {
                maxFrequency = count;
                mostFrequentChar = inputString.charAt(i);
            }
        }
        System.out.println("Most Frequent Character: " + mostFrequentChar);
    }
}
