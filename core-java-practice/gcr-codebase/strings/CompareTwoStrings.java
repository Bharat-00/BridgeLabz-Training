import java.util.Scanner;
public class CompareTwoStrings{
    static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter first string:");
        String str1 = sc.nextLine();
        System.out.println("Enter second string:");
        String str2 = sc.nextLine();
        boolean resultCharAt = compareUsingCharAt(str1, str2);
        boolean resultEquals = str1.equals(str2);
        System.out.println("Comparison using charAt method: " + resultCharAt);
        System.out.println("Comparison using equals method: " + resultEquals);
        if(resultCharAt == resultEquals){
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("Methods give different results.");
        }

    }
}