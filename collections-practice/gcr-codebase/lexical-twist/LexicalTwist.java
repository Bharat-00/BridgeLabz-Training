import java.util.*;
public class LexicalTwist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first word");
        String first = sc.nextLine();
        // Validation for first word
        if (first.trim().contains(" ")) {
            System.out.println(first + " is an invalid word");
            return;
        }
        System.out.println("Enter the second word");
        String second = sc.nextLine();
        // Validation for second word
        if (second.trim().contains(" ")) {
            System.out.println(second + " is an invalid word");
            return;
        }
        // Check if second word is reverse of first (case-insensitive)
        String reversedFirst = new StringBuilder(first).reverse().toString();
        if (reversedFirst.equalsIgnoreCase(second)) {
            // Step 1–4 (reverse → lowercase → replace vowels)
            String transformed = reversedFirst.toLowerCase();
            transformed = transformed.replaceAll("[aeiou]", "@");
            System.out.println(transformed);
        } else {
            // Combine and convert to uppercase
            String combined = (first + second).toUpperCase();
            int vowels = 0, consonants = 0;
            Set<Character> vowelSet = new LinkedHashSet<>();
            Set<Character> consonantSet = new LinkedHashSet<>();
            for (char ch : combined.toCharArray()) {
                if (ch >= 'A' && ch <= 'Z') {
                    if ("AEIOU".indexOf(ch) != -1) {
                        vowels++;
                        vowelSet.add(ch);
                    } else {
                        consonants++;
                        consonantSet.add(ch);
                    }
                }
            }
            if (vowels > consonants) {
                printFirstTwo(vowelSet);
            } else if (consonants > vowels) {
                printFirstTwo(consonantSet);
            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }
        sc.close();
    }
    private static void printFirstTwo(Set<Character> set) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (char ch : set) {
            result.append(ch);
            count++;
            if (count == 2) break;
        }
        System.out.println(result.toString());
    }
}
