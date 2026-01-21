import java.util.ArrayList;
import java.util.List;
// Custom Exception for invalid time format
class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}
// Model class (OOPS)
class Movie {
    private String title;
    private String time;
    public Movie(String title, String time) {
        this.title = title;
        this.time = time;
    }
    public String getTitle() {
        return title;
    }
    public String getTime() {
        return time;
    }
    // Formatted movie details
    public String getFormattedDetails() {
        return String.format("Movie: %s | Showtime: %s", title, time);
    }
}
// Service + Manager class
class CinemaTimeManager {
    private List<Movie> movies = new ArrayList<>();
    // Validate time (HH:MM format)
    private void validateTime(String time) throws InvalidTimeFormatException {
        if (!time.matches("([01]\\d|2[0-3]):[0-5]\\d")) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
    }
    // Add movie
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        validateTime(time);
        movies.add(new Movie(title, time));
        System.out.println("Movie added successfully.");
    }
    // Search movie using keyword
    public void searchMovie(String keyword) {
        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(movie.getFormattedDetails());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No movie found with keyword: " + keyword);
        }
    }
    // Display all movies
    public void displayAllMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }
        for (Movie movie : movies) {
            System.out.println(movie.getFormattedDetails());
        }
    }
    // Generate printable report (List → Array)
    public void generateReport() {
        try {
            Movie[] movieArray = movies.toArray(new Movie[0]);
            System.out.println("\nPrintable Movie Report:");
            for (int i = 0; i < movieArray.length; i++) {
                System.out.println((i + 1) + ". " + movieArray[i].getFormattedDetails());
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error while generating report.");
        }
    }
}
// Presentation Layer
public class CinemaTimeApp {
    public static void main(String[] args) {
        CinemaTimeManager manager = new CinemaTimeManager();
        try {
            manager.addMovie("Inception", "18:30");
            manager.addMovie("Avengers Endgame", "21:15");
            manager.addMovie("Interstellar", "15:00");
            // Uncomment to test exception
            // manager.addMovie("Invalid Movie", "25:99");
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n--- All Movies ---");
        manager.displayAllMovies();
        System.out.println("\n--- Search Result ---");
        manager.searchMovie("end");
        manager.generateReport();
    }
}
