/**
 * Online Ticket Reservation System using Circular Linked List
 */
public class TicketReservationSystem {
    // Node representing a ticket
    static class Ticket {
        int ticketId;
        String customerName;
        String movieName;
        int seatNumber;
        String bookingTime;
        Ticket next;
        Ticket(int ticketId, String customerName, String movieName,
               int seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
        }
    }
    private Ticket head = null;
    // Add new ticket
    public void addTicket(int id, String name, String movie, int seat, String time) {
        Ticket newTicket = new Ticket(id, name, movie, seat, time);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
        System.out.println("Ticket booked successfully for " + name);
    }
    // Remove ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets found");
            return;
        }
        Ticket current = head;
        Ticket prev = null;
        do {
            if (current.ticketId == ticketId) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    Ticket temp = head;
                    while (temp.next != head)
                        temp = temp.next;
                    head = head.next;
                    temp.next = head;
                }
                System.out.println("Ticket ID " + ticketId + " cancelled");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Ticket not found");
    }
    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }
        Ticket temp = head;
        System.out.println("\nBooked Tickets:");
        do {
            System.out.println("ID: " + temp.ticketId +
                    ", Name: " + temp.customerName +
                    ", Movie: " + temp.movieName +
                    ", Seat: " + temp.seatNumber +
                    ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }
    // Search ticket
    public void searchTicket(String keyword) {
        if (head == null)
            return;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) ||
                temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket Found → ID: " + temp.ticketId);
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket not found");
    }
    // Count total tickets
    public void countTickets() {
        if (head == null) {
            System.out.println("Total tickets: 0");
            return;
        }
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total tickets booked: " + count);
    }
    // Main method
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(101, "Rahul", "Inception", 12, "10:30 AM");
        system.addTicket(102, "Aman", "Avatar", 15, "1:00 PM");
        system.displayTickets();
        system.searchTicket("Avatar");
        system.countTickets();
        system.removeTicket(101);
        system.displayTickets();
    }
}
