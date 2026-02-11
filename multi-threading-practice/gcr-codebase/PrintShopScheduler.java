class PrintJob implements Runnable {
    private String jobName;
    private int pages;
    private int priority;
    public PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }
    @Override
    public void run() {
        String priorityLabel = getPriorityLabel(priority);
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= pages; i++) {
            synchronized (PrintJob.class) {  // single shared printer
                System.out.println("[" + priorityLabel + "] Printing " +
                        jobName + " - Page " + i + " of " + pages);
            }
            try {
                Thread.sleep(100); // simulate 100ms per page
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(jobName + " completed in " +
                (endTime - startTime) + " ms");
    }
    private String getPriorityLabel(int priority) {
        if (priority >= 8) return "High Priority";
        if (priority >= 5) return "Medium Priority";
        return "Low Priority";
    }
}
public class PrintShopScheduler {
    public static void main(String[] args) throws InterruptedException {
        long systemStart = System.currentTimeMillis();
        Thread job1 = new Thread(new PrintJob("Job1", 10, 5));
        Thread job2 = new Thread(new PrintJob("Job2", 5, 8));
        Thread job3 = new Thread(new PrintJob("Job3", 15, 3));
        Thread job4 = new Thread(new PrintJob("Job4", 8, 6));
        Thread job5 = new Thread(new PrintJob("Job5", 12, 7));
        job1.setPriority(5);
        job2.setPriority(8);
        job3.setPriority(3);
        job4.setPriority(6);
        job5.setPriority(7);
        System.out.println("Starting print jobs...\n");
        job1.start();
        job2.start();
        job3.start();
        job4.start();
        job5.start();
        job1.join();
        job2.join();
        job3.join();
        job4.join();
        job5.join();
        long systemEnd = System.currentTimeMillis();
        System.out.println("\nAll jobs completed in " +
                (systemEnd - systemStart) + " ms");
    }
}
