import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class ByteToCharacterStream {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // file encoded in UTF-8
        try {
            // Step 1: FileInputStream (byte stream)
            FileInputStream fis = new FileInputStream(filePath);
            // Step 2: Convert byte stream to character stream
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            // Step 3: Wrap in BufferedReader
            BufferedReader br = new BufferedReader(isr);
            String line;
            // Step 4: Read and print file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            // Close resources
            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Error while reading file.");
            e.printStackTrace();
        }
    }
}
