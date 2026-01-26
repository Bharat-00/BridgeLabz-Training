import java.io.*;
public class BufferedVsUnbufferedCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.txt";
        // Unbuffered copy
        try {
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream("unbuffered.txt");
            byte[] buffer = new byte[4096];
            int bytesRead;
            long startTime = System.nanoTime();
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            long endTime = System.nanoTime();
            fis.close();
            fos.close();
            System.out.println("Unbuffered Stream Time: " + (endTime - startTime) + " ns");
        } catch (IOException e) {
            System.out.println("Error in unbuffered file copy.");
        }
        // Buffered copy
        try {
            BufferedInputStream bis =
                    new BufferedInputStream(new FileInputStream(sourceFile));
            BufferedOutputStream bos =
                    new BufferedOutputStream(new FileOutputStream("buffered.txt"));
            byte[] buffer = new byte[4096];
            int bytesRead;
            long startTime = System.nanoTime();
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            long endTime = System.nanoTime();
            bis.close();
            bos.close();
            System.out.println("Buffered Stream Time: " + (endTime - startTime) + " ns");
        } catch (IOException e) {
            System.out.println("Error in buffered file copy.");
        }
    }
}
