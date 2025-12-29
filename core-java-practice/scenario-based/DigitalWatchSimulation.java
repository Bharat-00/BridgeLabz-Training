public class DigitalWatchSimulation {
    public static void main(String[] args) {
        System.out.println("⏱️ Digital Watch Simulation Started");
        // Hours loop
        for (int hour = 0; hour < 24; hour++) {
            // Minutes loop
            for (int minute = 0; minute < 60; minute++) {
                // Stop simulation at 13:00
                if (hour == 13 && minute == 0) {
                    System.out.println("\n⚡ Power Cut! Watch stopped at 13:00");
                    return; // exit program
                }
                // Display time in HH:MM format
                System.out.printf("%02d:%02d\n", hour, minute);
            }
        }
    }
}
