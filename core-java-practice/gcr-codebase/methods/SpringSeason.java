public class SpringSeason {
    // Method to check Spring Season
    public static boolean isSpring(int month, int day) {
        return (month == 3 && day >= 20) ||
               (month == 4 || month == 5) ||
               (month == 6 && day <= 20);
    }
    public static void main(String[] args) {
        // Taking input from command line
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        // Checking and printing result
        if (isSpring(month, day))
            System.out.println("Its a Spring Season");
        else
            System.out.println("Not a Spring Season");
    }
}
