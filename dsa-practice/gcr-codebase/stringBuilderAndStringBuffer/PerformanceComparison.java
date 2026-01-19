import java.io.*;
import java.util.*;
public class PerformanceComparison {
    private static final int ITERATIONS = 1_000_000;
    public static void main(String[] args) throws Exception {
        // ---------------- STRINGBUILDER vs STRINGBUFFER ----------------
        System.out.println("---- StringBuilder vs StringBuffer ----");
        List<String> data = Collections.nCopies(ITERATIONS, "hello");
        // StringBuilder
        long startSB = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (String s : data) {
            sb.append(s);
        }
        long endSB = System.nanoTime();
        System.out.println("StringBuilder Time (ms): " + (endSB - startSB) / 1_000_000);
        // StringBuffer
        long startSBuf = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (String s : data) {
            sbuf.append(s);
        }
        long endSBuf = System.nanoTime();
        System.out.println("StringBuffer Time (ms): " + (endSBuf - startSBuf) / 1_000_000);
        // ---------------- FILEREADER vs INPUTSTREAMREADER ----------------
        System.out.println("\n---- FileReader vs InputStreamReader ----");
        String filePath = "largefile.txt"; // replace with 100MB file path
        // FileReader
        long startFR = System.nanoTime();
        int wordsFR = countWordsUsingFileReader(filePath);
        long endFR = System.nanoTime();
        System.out.println("FileReader Word Count: " + wordsFR);
        System.out.println("FileReader Time (ms): " + (endFR - startFR) / 1_000_000);
        // InputStreamReader
        long startISR = System.nanoTime();
        int wordsISR = countWordsUsingInputStreamReader(filePath);
        long endISR = System.nanoTime();
        System.out.println("InputStreamReader Word Count: " + wordsISR);
        System.out.println("InputStreamReader Time (ms): " + (endISR - startISR) / 1_000_000);
    }
    // ---------- FileReader Method ----------
    private static int countWordsUsingFileReader(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        int count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            if (!line.trim().isEmpty()) {
                count += words.length;
            }
        }
        br.close();
        return count;
    }
    // ---------- InputStreamReader Method ----------
    private static int countWordsUsingInputStreamReader(String path) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), "UTF-8")
        );
        int count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            if (!line.trim().isEmpty()) {
                count += words.length;
            }
        }
        br.close();
        return count;
    }
}
