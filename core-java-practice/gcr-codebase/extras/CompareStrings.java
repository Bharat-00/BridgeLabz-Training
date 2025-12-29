import java.util.*;
public class CompareStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int len = Math.min(s1.length(), s2.length());
        int flag = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) < s2.charAt(i))
                    System.out.println(s1 + " comes before " + s2);
                else
                    System.out.println(s2 + " comes before " + s1);
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            if (s1.length() < s2.length())
                System.out.println(s1 + " comes before " + s2);
            else if (s1.length() > s2.length())
                System.out.println(s2 + " comes before " + s1);
            else
                System.out.println("Both strings are equal");
        }
    }
}
