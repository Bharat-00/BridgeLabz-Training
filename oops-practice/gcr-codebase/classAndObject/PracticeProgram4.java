public class PracticeProgram4 {
    private String guestName;
    private String roomType;
    private int nights;
    // 1. Default Constructor
    public PracticeProgram4() {
        this.guestName = "Walk-in Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }
    // 2. Parameterized Constructor
    public PracticeProgram4(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    // 3. Copy Constructor
    public PracticeProgram4(PracticeProgram4 booking) {
        this.guestName = booking.guestName;
        this.roomType = booking.roomType;
        this.nights = booking.nights;
    }
    public void showBooking() {
        System.out.println("Guest: " + guestName + ", Room: " + roomType + ", Nights: " + nights);
    }
    // Main method to test the code
    public static void main(String[] args) {
        System.out.println("--- Problem 4: Hotel Booking ---");
        PracticeProgram4 b1 = new PracticeProgram4(); // Default
        b1.showBooking();
        PracticeProgram4 b2 = new PracticeProgram4("Alice Wonderland", "Suite", 5); // Param
        b2.showBooking();
        PracticeProgram4 b3 = new PracticeProgram4(b2); // Copy
        System.out.print("Copy of Alice's booking: ");
        b3.showBooking();
    }
}