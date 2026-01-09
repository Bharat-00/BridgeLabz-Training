// Circular Linked List for Task Scheduler
public class TaskScheduler{
    // Node class representing a Task
    class TaskNode{
        int taskId;
        String taskName;
        String priority;
        String dueDate;
        TaskNode next;
        // Constructor
        TaskNode(int taskId, String taskName, String priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }
    // Head pointer
    private TaskNode head;
    // 1. Add task at beginning
    public void addAtBeginning(int id, String name, String priority, String dueDate){
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if(head == null){
            head=newNode;
            newNode.next=head; 
        }else{
            TaskNode temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
        System.out.println("Task added at beginning.");
    }
    // 2. Add task at end
    public void addAtEnd(int id,String name,String priority,String dueDate){
        TaskNode newNode=new TaskNode(id, name, priority, dueDate);
        if(head==null){
            head=newNode;
            newNode.next=head;
        }else{
            TaskNode temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.next=head;
        }
        System.out.println("Task added at end.");
    }
    // 3. Add task at specific position (1-based index)
    public void addAtPosition(int position,int id,String name,String priority,String dueDate){
        if(position<=0){
            System.out.println("Invalid Position");
            return;
        }
        if(position==1){
            addAtBeginning(id, name, priority, dueDate);
            return;
        }
        TaskNode newNode=new TaskNode(id, name, priority, dueDate);
        TaskNode temp=head;
        for(int i = 1; i < position - 1 && temp.next != head; i++){
            temp=temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Task added at position " + position);
    }
    // 4. Remove task by Task ID
    public void removeByTaskId(int id) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode curr = head;
        TaskNode prev = null;
        do {
            if (curr.taskId == id) {
                if (curr == head) {
                    TaskNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else if (prev != null) {
                    prev.next = curr.next;
                }
                System.out.println("Task removed successfully.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
        System.out.println("Task not found.");
    }
    // 5. View current task and move to next
    public void viewAndMoveNext() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task:");
        displayTask(head);
        head = head.next;
        System.out.println("Moved to next task.");
    }
    // 6. Display all tasks from head
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        TaskNode temp = head;
        System.out.println("\n--- Task List ---");
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }
    // 7. Search task by Priority
    public void searchByPriority(String priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode temp = head;
        boolean found = false;
        System.out.println("\nTasks with priority: " + priority);
        do {
            if (temp.priority.equalsIgnoreCase(priority)) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No matching tasks found.");
        }
    }
    // Helper method to display a task
    private void displayTask(TaskNode task) {
        System.out.println("Task ID: " + task.taskId +
                ", Name: " + task.taskName +
                ", Priority: " + task.priority +
                ", Due Date: " + task.dueDate);
    }
    // Main method to test the program
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addAtBeginning(1, "Design UI", "High", "10-02-2026");
        scheduler.addAtEnd(2, "Write Code", "Medium", "15-02-2026");
        scheduler.addAtEnd(3, "Testing", "Low", "20-02-2026");
        scheduler.addAtPosition(2, 4, "Database Setup", "High", "12-02-2026");
        scheduler.displayTasks();
        scheduler.searchByPriority("High");
        scheduler.viewAndMoveNext();
        scheduler.viewAndMoveNext();
        scheduler.removeByTaskId(2);
        scheduler.displayTasks();
    }
}

