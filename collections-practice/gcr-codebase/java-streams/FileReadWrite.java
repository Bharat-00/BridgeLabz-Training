import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileReadWrite {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);
            int data;
            while ((data = fileInputStream.read()) != -1) {
                fileOutputStream.write(data);
            }
            fileInputStream.close();
            fileOutputStream.close();
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Error: Source file does not exist or cannot be read.");
        }
    }
}
