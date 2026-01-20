import java.io.*;
public class FileAndInputStreamReader {
    // Using FileReader
    public static long readUsingFileReader(String filePath) throws IOException {
        long start = System.nanoTime();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int wordCount = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        bufferedReader.close();
        long end = System.nanoTime();
        System.out.println("FileReader Word Count: " + wordCount);
        return end - start;
    }
    // Using InputStreamReader
    public static long readUsingInputStreamReader(String filePath) throws IOException {
        long start = System.nanoTime();
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bufferedReader = new BufferedReader(isr);
        int wordCount = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        bufferedReader.close();
        long end = System.nanoTime();
        System.out.println("InputStreamReader Word Count: " + wordCount);
        return end - start;
    }
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Use a large text file
        try {
            long fileReaderTime = readUsingFileReader(filePath);
            long inputStreamReaderTime = readUsingInputStreamReader(filePath);
            System.out.println("\nLarge File Reading Performance");
            System.out.println("FileReader Time        : " + fileReaderTime + " ns");
            System.out.println("InputStreamReader Time : " + inputStreamReaderTime + " ns");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
