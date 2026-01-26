import java.io.*;
public class ImageByteArray {
    public static void main(String[] args) {
        String sourceImage = "input.jpg";
        String outputImage = "output.jpg";
        try {
            // Read image into byte array
            FileInputStream fis = new FileInputStream(sourceImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = baos.toByteArray();
            // Write byte array back to image
            ByteArrayInputStream bais =
                    new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(outputImage);
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fis.close();
            fos.close();
            baos.close();
            bais.close();
            // Verify image integrity
            File original = new File(sourceImage);
            File copied = new File(outputImage);
            if (original.length() == copied.length()) {
                System.out.println("Image copied successfully and verified.");
            } else {
                System.out.println("Image copy verification failed.");
            }
        } catch (IOException e) {
            System.out.println("Error processing image file.");
        }
    }
}
