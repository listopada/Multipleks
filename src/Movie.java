import java.util.*;

// Klasa reprezentująca film
class Movie {
    private String title;
    private String description;
    private int duration; // w minutach

    public Movie(String title, String description, int duration) {
        this.title = title;
        this.description = description;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return title + " (" + duration + " min)";
    }
}
