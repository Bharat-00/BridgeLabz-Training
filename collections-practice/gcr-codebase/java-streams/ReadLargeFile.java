import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadLargeFile {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // change path if needed
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Lines containing word 'error':\n");
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
