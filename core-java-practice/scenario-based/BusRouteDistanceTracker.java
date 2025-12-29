import java.util.Scanner;
public class BusRouteDistanceTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalDistance = 0;
        int stopNumber = 1;
        char choice;
        System.out.println("🚌 Bus Route Distance Tracker Started");
        // Loop runs until passenger chooses to get off
        while (true) {
            System.out.print("Enter distance covered at stop " + stopNumber + ": ");
            int distance = scanner.nextInt();
            totalDistance += distance;
            System.out.println("Total distance covered so far: " + totalDistance + " km");
            System.out.print("Do you want to get off at this stop? (Y/N): ");
            choice = scanner.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                System.out.println("Passenger got off the bus.");
                break; // exit loop
            }
            stopNumber++;
        }
        System.out.println("Final distance travelled: " + totalDistance + " km");
        System.out.println("🚌 Journey Ended");
    }
}
