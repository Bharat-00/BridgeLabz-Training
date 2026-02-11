import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
class TaskRunner extends Thread {
    public TaskRunner(String name) {
        super(name);
    }
    @Override
    public void run() {
        try {
            // Simulate computation (RUNNABLE)
            for (int i = 0; i < 5_000_000; i++) {
                double temp = Math.sqrt(i); // dummy computation
            }
            // Simulate sleep (TIMED_WAITING)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
class StateMonitor extends Thread {
    private Thread[] threads;
    private Map<String, Integer> stateCount = new HashMap<>();
    public StateMonitor(Thread... threads) {
        this.threads = threads;
    }
    @Override
    public void run() {
        boolean allTerminated = false;
        while (!allTerminated) {
            allTerminated = true;
            for (Thread t : threads) {
                Thread.State state = t.getState();
                System.out.println("[Monitor] " + t.getName() +
                        " is in " + state +
                        " state at " + LocalTime.now());
                stateCount.put(t.getName(),
                        stateCount.getOrDefault(t.getName(), 0) + 1);
                if (state != Thread.State.TERMINATED) {
                    allTerminated = false;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        printSummary();
    }
    private void printSummary() {
        System.out.println(" Summary ");
        for (Map.Entry<String, Integer> entry : stateCount.entrySet()) {
            System.out.println(entry.getKey() +
                    " state checks observed: " + entry.getValue());
        }
    }
}
public class ThreadStateMonitoringSystem {
    public static void main(String[] args) throws InterruptedException {
        TaskRunner task1 = new TaskRunner("Task-1");
        TaskRunner task2 = new TaskRunner("Task-2");
        // Demonstrating NEW state before start
        System.out.println("Initial State:");
        System.out.println(task1.getName() + " -> " + task1.getState());
        System.out.println(task2.getName() + " -> " + task2.getState());
        StateMonitor monitor = new StateMonitor(task1, task2);
        task1.start();
        task2.start();
        monitor.start();
        task1.join();
        task2.join();
        monitor.join();
        System.out.println("\nAll tasks completed.");
    }
}
