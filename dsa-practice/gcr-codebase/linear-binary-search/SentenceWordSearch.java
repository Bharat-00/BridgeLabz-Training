public class SentenceWordSearch {
    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence; // first sentence containing the word
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        String[] sentences = {
            "Java is a programming language",
            "I love data structures",
            "Linear search is simple"
        };
        String word = "data";
        String result = findSentence(sentences, word);
        System.out.println(result);
    }
}
