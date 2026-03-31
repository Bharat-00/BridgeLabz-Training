public class PracticeProblem5 {
    private String title;
    private String author;
    private double price;
    private boolean availability;
    public PracticeProblem5(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true; // Default to available
    }
    public void borrowBook() {
        if (this.availability == true) {
            this.availability = false;
            System.out.println("Success: You have borrowed '" + title + "'.");
        } else {
            System.out.println("Sorry, '" + title + "' is currently unavailable.");
        }
    }
    // Main method to test the code
    public static void main(String[] args) {
        System.out.println("--- Problem 5: Library System ---");
        PracticeProblem5 libBook = new PracticeProblem5("Java Programming", "James Gosling", 50.0);
        libBook.borrowBook(); // Should succeed
        libBook.borrowBook(); // Should fail (already borrowed)
    }
}