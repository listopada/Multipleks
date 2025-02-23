import java.util.*;

class Multipleks {
    private Map<String, Movie> movies;

    public Multipleks() {
        this.movies = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        movies.put(movie.getTitle().toLowerCase(), movie);
    }

    public Movie getMovieByTitle(String title) {
        return movies.get(title.toLowerCase());
    }
}
