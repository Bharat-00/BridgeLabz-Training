// Program to model a movie ticket booking system
// MovieTicket class definition
class MovieTicket {
    // Instance variables
    private final String movieName;
    private final String seatNumber;
    private final double price;
    private boolean isBooked;
    // Constructor to initialize ticket details
    public MovieTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isBooked = false;
    }
    // Method to book a ticket
    public void bookTicket() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: " + price);
        } else {
            System.out.println("House full!! sorry.... Ticket already booked");
        }
    }
    // Method to display ticket details
    public void displayTicketDetails() {
        if (!isBooked) {
            System.out.println("Ticket have not booked yet...");
        }
        System.out.println("Ticket booked for movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }
}
// Main class
public class MovieTicketBooking {
    public static void main(String[] args) {
        // Creating MovieTicket object
        MovieTicket ticket = new MovieTicket("Dragon", "A10", 5120.0);
        // Display before booking
        ticket.displayTicketDetails();
        // Booking the ticket
        ticket.bookTicket();
        // Trying to book again
        ticket.bookTicket();
    }
}
