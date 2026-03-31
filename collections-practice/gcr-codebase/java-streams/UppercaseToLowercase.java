import java.io.*;
public class UppercaseToLowercase {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(outputFile));
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(Character.toLowerCase((char) character));
            }
            reader.close();
            writer.close();
            System.out.println("File converted to lowercase successfully.");
        } catch (IOException e) {
            System.out.println("File processing error occurred.");
        }
    }
}
