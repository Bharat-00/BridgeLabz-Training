import java.util.*;
// -------------------- 1. Reverse a Queue --------------------
class QueueReversal {
    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) return;
        int front = queue.remove();
        reverseQueue(queue);
        queue.add(front);
    }
}
// -------------------- 2. Generate Binary Numbers --------------------
class BinaryNumberGenerator {
    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);
            queue.add(current + "0");
            queue.add(current + "1");
        }
        return result;
    }
}
// -------------------- 3. Hospital Triage System --------------------
class Patient {
    String name;
    int severity;
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}
class HospitalTriage {
    private PriorityQueue<Patient> pq = new PriorityQueue<>(
            (a, b) -> b.severity - a.severity
    );
    public void addPatient(String name, int severity) {
        pq.add(new Patient(name, severity));
    }
    public void treatPatients() {
        System.out.println("Treatment Order:");
        while (!pq.isEmpty()) {
            Patient p = pq.remove();
            System.out.println(p.name);
        }
    }
}
// -------------------- 4. Stack Using Two Queues --------------------
class StackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    public int pop() {
        return q1.remove();
    }
    public int top() {
        return q1.peek();
    }
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
// -------------------- 5. Circular Buffer --------------------
class CircularBuffer {
    private int[] buffer;
    private int front = 0, size = 0;
    private int capacity;
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }
    public void insert(int value) {
        buffer[(front + size) % capacity] = value;
        if (size < capacity) {
            size++;
        } else {
            front = (front + 1) % capacity;
        }
    }
    public void display() {
        System.out.print("Buffer: ");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}
// -------------------- MAIN CLASS --------------------
public class QueueInterface {
    public static void main(String[] args) {
        // 1. Reverse a Queue
        Queue<Integer> queue = new LinkedList<>(List.of(10, 20, 30));
        QueueReversal.reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
        // 2. Binary Number Generation
        System.out.println("Binary Numbers: " +
                BinaryNumberGenerator.generateBinary(5));
        // 3. Hospital Triage
        HospitalTriage hospital = new HospitalTriage();
        hospital.addPatient("John", 3);
        hospital.addPatient("Alice", 5);
        hospital.addPatient("Bob", 2);
        hospital.treatPatients();
        // 4. Stack Using Queues
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack Pop: " + stack.pop());
        // 5. Circular Buffer
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.insert(4);
        buffer.display();
    }
}
