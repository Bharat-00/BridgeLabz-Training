import java.util.Scanner;
public class MovieTicketBookingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char continueBooking = 0;
        System.out.println("🎬 Welcome to Movie Ticket Booking App");
        do {
            int ticketPrice = 0;
            // Movie type
            System.out.print("\nSelect Movie Type (1-Regular, 2-3D): ");
            int movieType = scanner.nextInt();
            switch (movieType) {
                case 1 -> ticketPrice += 150;
                case 2 -> ticketPrice += 250;
                default -> {
                    System.out.println("Invalid movie type!");
                    continue;
                }
            }
            // Seat type
            System.out.print("Select Seat Type (1-Gold, 2-Silver): ");
            int seatType = scanner.nextInt();
            switch (seatType) {
                case 1 -> ticketPrice += 100;
                case 2 -> ticketPrice += 50;
                default -> {
                    System.out.println("Invalid seat type!");
                    continue;
                }
            }
            // Snacks
            System.out.print("Do you want snacks? (Y/N): ");
            char snacks = scanner.next().charAt(0);
            if (snacks == 'Y' || snacks == 'y') {
                ticketPrice += 80;
            }
            System.out.println("🎟️ Total Ticket Price: ₹" + ticketPrice);
            System.out.print("\nBook ticket for another customer? (Y/N): ");
            continueBooking = scanner.next().charAt(0);
        } while (continueBooking == 'Y' || continueBooking == 'y');
        System.out.println("🎬 Booking Session Ended");
    }
}
