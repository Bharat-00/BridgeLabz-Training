public class BackgroundJobApplication {
    public static void main(String[] args) {
        // Runnable task for background processing
        Runnable backgroundTask = () -> {
            System.out.println("Background job started");
            System.out.println("Executing task...");
            System.out.println("Background job completed");
        };
        // Executes task asynchronously
        Thread workerThread = new Thread(backgroundTask);
        workerThread.start();
    }
}
