import java.util.Arrays;
import java.util.List;
public class TopTrendingMoviesApplication {
    public static void main(String[] args) {
        // Movie list
        List<Movie> movies = Arrays.asList(
                new Movie("Movie A", 8.9, 2024),
                new Movie("Movie B", 7.5, 2022),
                new Movie("Movie C", 9.2, 2025),
                new Movie("Movie D", 8.7, 2023),
                new Movie("Movie E", 9.0, 2024),
                new Movie("Movie F", 6.8, 2021)
        );
        // Fetches top 5 trending movies
        movies.stream().filter(movie -> movie.getRating() >= 8.5).sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating())).limit(5).forEach(System.out::println);
    }
}
class Movie {
    private String name;
    private double rating;
    private int releaseYear;
    public Movie(String name, double rating, int releaseYear) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }
    public double getRating() {
        return rating;
    }
    @Override
    public String toString() {
        return name + " (" + releaseYear + ") - Rating: " + rating;
    }
}
