import java.util.LinkedList;
import java.util.Queue;
/* ================= Vehicle Node ================= */
class Vehicle {
    String number;
    Vehicle next;
    Vehicle(String number) {
        this.number = number;
        this.next = null;
    }
}
/* ================= Traffic Manager ================= */
class TrafficManager {
    private Vehicle head = null;
    private Vehicle tail = null;
    private final Queue<String> waitingQueue = new LinkedList<>();
    private final int maxQueueSize = 5;
    // Add vehicle to roundabout
    public void addVehicle(String number) {
        Vehicle newVehicle = new Vehicle(number);
        if (head == null) {
            head = tail = newVehicle;
            tail.next = head;
        } else {
            tail.next = newVehicle;
            tail = newVehicle;
            tail.next = head;
        }
        System.out.println("Vehicle " + number + " entered roundabout");
    }
    // Remove vehicle
    public void removeVehicle() {
        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }
        System.out.println("Vehicle " + head.number + " exited roundabout");
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }
    // Queue handling
    public void addToQueue(String number) {
        if (waitingQueue.size() == maxQueueSize) {
            System.out.println("Queue Overflow! Cannot add vehicle " + number);
        } else {
            waitingQueue.add(number);
            System.out.println("Vehicle " + number + " added to waiting queue");
        }
    }
    // Print roundabout
    public void displayRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }
        Vehicle temp = head;
        System.out.print("Roundabout: ");
        do {
            System.out.print(temp.number + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Start)");
    }
}
/* ================= Main ================= */
public class TrafficManagerSystem {
    public static void main(String[] args) {
        TrafficManager tm = new TrafficManager();
        tm.addVehicle("CAR-101");
        tm.addVehicle("CAR-102");
        tm.displayRoundabout();
        tm.removeVehicle();
        tm.displayRoundabout();
        tm.addToQueue("CAR-201");
        tm.addToQueue("CAR-202");
    }
}
