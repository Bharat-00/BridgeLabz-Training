import java.util.Scanner;
public class ReplaceWordInSentence {
    // Method to replace a word
    static String replaceWord(String sentence, String oldWord, String newWord) {
        String[] words = sentence.split(" ");
        String resultSentence = "";
        for (String word : words) {
            if (word.equals(oldWord)) {
                resultSentence += newWord + " ";
            } else {
                resultSentence += word + " ";
            }
        }
        return resultSentence.trim();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        System.out.print("Enter word to replace: ");
        String oldWord = scanner.next();
        System.out.print("Enter new word: ");
        String newWord = scanner.next();
        System.out.println("Updated Sentence: " + replaceWord(sentence, oldWord, newWord));
    }
}
