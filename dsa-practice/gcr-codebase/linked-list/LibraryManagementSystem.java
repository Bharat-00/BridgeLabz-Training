// Doubly Linked List for Library Management System
public class LibraryManagementSystem {
    // Node class representing a Book
    class BookNode {
        int bookId;
        String title;
        String author;
        String genre;
        boolean isAvailable;
        BookNode prev;
        BookNode next;
        BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.isAvailable = isAvailable;
            this.prev = null;
            this.next = null;
        }
    }
    private BookNode head;
    private BookNode tail;
    // 1. Add book at end
    public void addBook(int id, String title, String author, String genre, boolean status) {
        BookNode newNode = new BookNode(id, title, author, genre, status);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Book added.");
    }
    // 2. Remove book by Book ID
    public void removeBook(int id) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }
    // 3. Search by Title or Author
    public void searchBook(String keyword) {
        BookNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(keyword) ||
                temp.author.equalsIgnoreCase(keyword)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No matching books found.");
        }
    }
    // 4. Update availability
    public void updateAvailability(int id, boolean status) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }
    // 5. Display forward
    public void displayForward() {
        BookNode temp = head;
        System.out.println("\n--- Library Books (Forward) ---");
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }
    // 6. Display reverse
    public void displayReverse() {
        BookNode temp = tail;
        System.out.println("\n--- Library Books (Reverse) ---");
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }
    // 7. Count books
    public void countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
    }
    // Helper method
    private void displayBook(BookNode book) {
        System.out.println("ID: " + book.bookId +
                ", Title: " + book.title +
                ", Author: " + book.author +
                ", Genre: " + book.genre +
                ", Available: " + book.isAvailable);
    }
    // Main method
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.addBook(1, "Java Basics", "James Gosling", "Programming", true);
        library.addBook(2, "Clean Code", "Robert Martin", "Software", true);
        library.addBook(3, "DSA", "Narasimha Karumanchi", "Computer Science", false);
        library.displayForward();
        library.displayReverse();
        library.searchBook("Clean Code");
        library.updateAvailability(3, true);
        library.removeBook(2);
        library.countBooks();
    }
}
