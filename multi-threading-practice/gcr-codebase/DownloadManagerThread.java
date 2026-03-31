import java.util.Random;
class FileDownloader extends Thread {
    private String fileName;
    public FileDownloader(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i <= 100; i += 10) {
            try {
                Thread.sleep(random.nextInt(300) + 200); // Random delay
            } catch (InterruptedException e) {
                System.out.println("Download interrupted: " + fileName);
            }
            System.out.println("[" + Thread.currentThread().getName() +
                    "] Downloading " + fileName + ": " + i + "%");
        }
    }
}
public class DownloadManagerThread {
    public static void main(String[] args) throws InterruptedException {
        FileDownloader t1 = new FileDownloader("Document.pdf");
        FileDownloader t2 = new FileDownloader("Image.jpg");
        FileDownloader t3 = new FileDownloader("Video.mp4");
        t1.start();
        t2.start();
        t3.start();
        // Wait for all downloads to complete
        t1.join();
        t2.join();
        t3.join();
        System.out.println("All downloads complete!");
    }
}
