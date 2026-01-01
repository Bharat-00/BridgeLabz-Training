public class OnlineCourseManagement {
    // Instance Variables
    private final String courseName;
    private String duration;
    private double fee;
    // Class Variable (Shared Institute Name)
    private static String instituteName = "Tech Academy";
    // Constructor
    public OnlineCourseManagement(String courseName, String duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public OnlineCourseManagement(String courseName) {
        this.courseName = courseName;
    }
    // Instance Method
    public void displayCourseDetails() {
        System.out.println("Institute: " + instituteName + " | Course: " + courseName + " | Duration: " + duration + " | Fee: $" + fee);
    }
    // Class Method: Updates the static variable
    public static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println(">> Institute name updated to: " + newName);
    }
    // Main method to test
    public static void main(String[] args) {
        System.out.println("--- Problem 2: Course Management ---");
        OnlineCourseManagement c1 = new OnlineCourseManagement("Java Basics", "2 Months", 200.0);
        OnlineCourseManagement c2 = new OnlineCourseManagement("Web Dev", "3 Months", 300.0);
        System.out.println("Before Update:");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
        System.out.println();
        // Update the shared institute name
        OnlineCourseManagement.updateInstituteName("CodeInClub Institute");
        System.out.println("\nAfter Update (Notice both changed):");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}