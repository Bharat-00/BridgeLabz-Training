// Doubly Linked List for Movie Management System
public class MovieManagementSystem {
    // Node class representing a Movie
    class MovieNode {
        String title;
        String director;
        int yearOfRelease;
        double rating;
        MovieNode prev;
        MovieNode next;
        // Constructor
        MovieNode(String title, String director, int yearOfRelease, double rating) {
            this.title = title;
            this.director = director;
            this.yearOfRelease = yearOfRelease;
            this.rating = rating;
            this.prev = null;
            this.next = null;
        }
    }
    // Head and Tail pointers
    private MovieNode head;
    private MovieNode tail;
    // 1. Add movie at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Movie added at beginning.");
    }
    // 2. Add movie at end
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Movie added at end.");
    }
    // 3. Add movie at specific position (1-based index)
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        System.out.println("Movie added at position " + position);
    }
    // 4. Remove movie by title
    public void removeByTitle(String title) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
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
                System.out.println("Movie removed successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }
    // 5. Search movie by director
    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;
        System.out.println("\nMovies directed by " + director + ":");
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found.");
        }
    }
    // 6. Search movie by rating
    public void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;
        System.out.println("\nMovies with rating " + rating + ":");
        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found.");
        }
    }
    // 7. Update rating by movie title
    public void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }
    // 8. Display movies forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies available.");
            return;
        }
        MovieNode temp = head;
        System.out.println("\n--- Movies (Forward Order) ---");
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }
    // 9. Display movies in reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies available.");
            return;
        }
        MovieNode temp = tail;
        System.out.println("\n--- Movies (Reverse Order) ---");
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }
    // Helper method to display movie details
    private void displayMovie(MovieNode movie) {
        System.out.println("Title: " + movie.title +
                ", Director: " + movie.director +
                ", Year: " + movie.yearOfRelease +
                ", Rating: " + movie.rating);
    }
    // Main method to test the program
    public static void main(String[] args) {
        MovieManagementSystem movies = new MovieManagementSystem();
        movies.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movies.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movies.addAtEnd("Avatar", "James Cameron", 2009, 7.8);
        movies.addAtPosition(2, "Titanic", "James Cameron", 1997, 7.9);
        movies.displayForward();
        movies.displayReverse();
        movies.searchByDirector("Christopher Nolan");
        movies.searchByRating(7.9);
        movies.updateRating("Avatar", 8.0);
        movies.removeByTitle("Titanic");
        movies.displayForward();
    }
}
