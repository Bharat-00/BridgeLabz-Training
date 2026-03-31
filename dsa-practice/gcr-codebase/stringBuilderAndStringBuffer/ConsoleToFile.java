import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class ConsoleToFile {
    public static void main(String[] args) {
        String filePath = "output.txt";
        try {
            // Step 1: Read from console
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            // Step 2: Write to file
            FileWriter writer = new FileWriter(filePath);
            System.out.println("Enter text (type 'exit' to stop):");
            String input;
            // Step 3 & 4: Read input and write to file
            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                writer.write(input + "\n");
            }
            // Step 5 & 6: Close resources
            writer.close();
            br.close();
            isr.close();
            System.out.println("Input saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error during input/output.");
            e.printStackTrace();
        }
    }
}
