import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadFileLineByLine {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // replace with your file name
        try {
            // Create FileReader
            FileReader fileReader = new FileReader(filePath);
            // Wrap FileReader in BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // Read file line by line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            // Close resources
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}
