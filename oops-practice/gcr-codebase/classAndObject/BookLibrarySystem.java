// Main Class
public class BookLibrarySystem {
    public String ISBN;
    protected String title;
    private String author;
    public BookLibrarySystem(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }
    // Getter for private author
    public String getAuthor() {
        return author;
    }
    // Setter for private author
    public void setAuthor(String author) {
        this.author = author;
    }
    public static void main(String[] args) {
        System.out.println("--- Access Modifier Problem 2: Library ---");   
        EBook myEbook = new EBook("978-3-16", "Clean Code", "Robert C. Martin");
        myEbook.displayDetails();
    }
}
// Subclass
class EBook extends BookLibrarySystem {   
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }
    public void displayDetails() {
        System.out.println("EBook Details:");   
        // Public access
        System.out.println("ISBN: " + ISBN);
        // Protected access (Allowed in subclass)
        System.out.println("Title: " + title);
        // Private access (Must use public getter)
        System.out.println("Author: " + getAuthor());
    }
}