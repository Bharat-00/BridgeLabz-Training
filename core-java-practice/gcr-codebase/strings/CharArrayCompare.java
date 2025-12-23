import java.util.Scanner;
public class CharArrayCompare {
    static char[] getCharsUsingMethod(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }
    static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = sc.next();
        char[] userArray = getCharsUsingMethod(text);
        char[] builtInArray = text.toCharArray();
        boolean result = compareCharArrays(userArray, builtInArray);
        System.out.println("User-defined method result:");
        for (char c : userArray) {
            System.out.print(c + " ");
        }
        System.out.println("\nBuilt-in toCharArray() result:");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }
        System.out.println("\nBoth arrays are same: " + result);
    }
}
