import java.util.ArrayList;
import java.util.List;

class CinemaHall {
    private String name;
    private int capacity;
    private List<Show> shows;  // Lista seansów w tej sali

    public CinemaHall(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getShows() {
        return shows;
    }
}