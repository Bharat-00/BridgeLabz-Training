import java.io.*;
public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "student.dat";
        // Writing primitive data to file
        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream(fileName))) {
            int rollNumber = 101;
            String name = "Rahul";
            double gpa = 8.75;
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data stored successfully.");
        } catch (IOException e) {
            System.out.println("Error while writing data.");
        }
        // Reading primitive data from file
        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream(fileName))) {
            int roll = dis.readInt();
            String studentName = dis.readUTF();
            double studentGpa = dis.readDouble();
            System.out.println("\nRetrieved Student Details:");
            System.out.println("Roll Number: " + roll);
            System.out.println("Name: " + studentName);
            System.out.println("GPA: " + studentGpa);
        } catch (IOException e) {
            System.out.println("Error while reading data.");
        }
    }
}
