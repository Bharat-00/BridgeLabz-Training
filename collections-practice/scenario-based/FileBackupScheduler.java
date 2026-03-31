import java.util.PriorityQueue;
// Custom Exception
class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}
// Backup Task Model
class BackupTask implements Comparable<BackupTask> {
    private String folderPath;
    private int priority; // Higher value = higher priority
    public BackupTask(String folderPath, int priority)
            throws InvalidBackupPathException {
        if (folderPath == null || folderPath.isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path!");
        }
        this.folderPath = folderPath;
        this.priority = priority;
    }
    public String getFolderPath() {
        return folderPath;
    }
    @Override
    public int compareTo(BackupTask other) {
        return Integer.compare(other.priority, this.priority);
    }
    public void execute() {
        System.out.println("Backing up folder: " + folderPath +
                " | Priority: " + priority);
    }
}
// Scheduler
public class FileBackupScheduler {
    public static void main(String[] args) {
        PriorityQueue<BackupTask> queue = new PriorityQueue<>();
        try {
            queue.add(new BackupTask("C:/Documents", 2));
            queue.add(new BackupTask("C:/System", 5));   // Critical folder
            queue.add(new BackupTask("D:/Media", 1));
        } catch (InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Executing backup tasks in priority order:");
        while (!queue.isEmpty()) {
            queue.poll().execute();
        }
    }
}
