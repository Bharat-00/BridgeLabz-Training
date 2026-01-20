class Vehicle {
    int vehicleId;
    Vehicle next;
    public Vehicle(int vehicleId) {
        this.vehicleId = vehicleId;
        this.next = null;
    }
}
// Circular Linked List for Roundabout
class Roundabout {
    private Vehicle tail;
    public Roundabout() {
        tail = null;
    }
    // Add vehicle to roundabout
    public void addVehicle(int id) {
        Vehicle newVehicle = new Vehicle(id);
        if (tail == null) {
            tail = newVehicle;
            tail.next = tail;
        } else {
            newVehicle.next = tail.next;
            tail.next = newVehicle;
            tail = newVehicle;
        }
        System.out.println("Vehicle " + id + " entered the roundabout.");
    }
    // Remove vehicle from roundabout
    public void removeVehicle() {
        if (tail == null) {
            System.out.println("Roundabout is empty. No vehicle to remove.");
            return;
        }
        Vehicle head = tail.next;
        if (head == tail) {
            System.out.println("Vehicle " + head.vehicleId + " exited the roundabout.");
            tail = null;
        } else {
            System.out.println("Vehicle " + head.vehicleId + " exited the roundabout.");
            tail.next = head.next;
        }
    }
    // Print roundabout state
    public void display() {
        if (tail == null) {
            System.out.println("Roundabout is empty.");
            return;
        }
        System.out.print("Roundabout vehicles: ");
        Vehicle current = tail.next;
        do {
            System.out.print(current.vehicleId + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }
}
// Queue for waiting vehicles
class VehicleQueue {
    private int[] queue;
    private int front, rear, size;
    public VehicleQueue(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    public void enqueue(int id) {
        if (size == queue.length) {
            System.out.println("Queue Overflow! Vehicle " + id + " cannot enter.");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = id;
        size++;
        System.out.println("Vehicle " + id + " added to waiting queue.");
    }
    public Integer dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow! No waiting vehicles.");
            return null;
        }
        int vehicleId = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return vehicleId;
    }
}
// Main class
public class TrafficManager {
    public static void main(String[] args) {
        Roundabout roundabout = new Roundabout();
        VehicleQueue waitingQueue = new VehicleQueue(3);
        waitingQueue.enqueue(101);
        waitingQueue.enqueue(102);
        waitingQueue.enqueue(103);
        waitingQueue.enqueue(104); // overflow
        Integer v;
        while ((v = waitingQueue.dequeue()) != null) {
            roundabout.addVehicle(v);
        }
        roundabout.display();
        roundabout.removeVehicle();
        roundabout.display();
        roundabout.addVehicle(105);
        roundabout.display();
    }
}
