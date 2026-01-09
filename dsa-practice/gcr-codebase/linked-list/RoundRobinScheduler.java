public class RoundRobinScheduler {
    static class ProcessNode {
        int pid, burstTime;
        ProcessNode next;
        ProcessNode(int pid, int burstTime) {
            this.pid = pid;
            this.burstTime = burstTime;
        }
    }
    private ProcessNode head = null;
    public void addProcess(int pid, int burstTime) {
        ProcessNode newNode = new ProcessNode(pid, burstTime);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        ProcessNode temp = head;
        while (temp.next != head)
            temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
    }
    public void displayProcesses() {
        ProcessNode temp = head;
        do {
            System.out.println("Process " + temp.pid);
            temp = temp.next;
        } while (temp != head);
    }
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 10);
        scheduler.addProcess(2, 5);
        scheduler.displayProcesses();
    }
}
