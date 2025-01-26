import java.util.ArrayList;
import java.util.List;

class Cinema {
    private String name;
    private String address;
    private List<CinemaHall> halls;

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
        this.halls = new ArrayList<>();
    }

    public void addHall(CinemaHall hall) {
        halls.add(hall);
    }

    public void printProgramme() {
        System.out.println("Repertuar dla kina " + name + " (" + address + "):");
        for (CinemaHall hall : halls) {
            for (Show screening : hall.getShows()) {
                System.out.println(screening);
            }
        }
    }

    public Movie findMovie(String title) {
        for (CinemaHall hall : halls) {
            for (Show screening : hall.getShows()) {
                if (screening.getMovie().getTitle().equalsIgnoreCase(title)) {
                    return screening.getMovie();
                }
            }
        }
        return null;
    }
}