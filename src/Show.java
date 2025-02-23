import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class Show {
    private Movie movie;
    private Date dateTime;
    private CinemaHall hall;
    private Map<String, Customer> reservedSeats;
    private Map<String, Customer> purchasedTickets;
    private boolean is3D;
    private boolean isVIP;

    public Show(String movieTitle, Date dateTime, CinemaHall hall, boolean is3D, boolean isVIP, Multipleks multiplex) {
        this.movie = multiplex.getMovieByTitle(movieTitle);
        this.dateTime = dateTime;
        this.hall = hall;
        this.reservedSeats = new HashMap<>();
        this.purchasedTickets = new HashMap<>();
        this.is3D = is3D;
        this.isVIP = isVIP;
    }

    public void reservePlaces(Customer customer, String... seats) {
        for (String seat : seats) {
            if (reservedSeats.containsKey(seat) || purchasedTickets.containsKey(seat)) {
                System.out.println("Miejsce " + seat + " jest już zajęte.");
            } else {
                reservedSeats.put(seat, customer);
                customer.addTicket(seat);
                System.out.println("Miejsce " + seat + " zostało zarezerwowane przez " + customer.getName());

                if (customer.getReservationCode() != null) {
                    System.out.println("Kod rezerwacji dla gościa: " + customer.getReservationCode());
                }
            }
        }
    }

    public void purchaseTicket(Customer customer, String seat) {
        if (purchasedTickets.containsKey(seat)) {
            System.out.println("Bilet na miejsce " + seat + " został już zakupiony.");
            return;
        }

        if (reservedSeats.containsKey(seat)) {
            Customer reservedBy = reservedSeats.get(seat);
            if (!reservedBy.equals(customer)) {
                System.out.println("Miejsce " + seat + " jest zarezerwowane przez " + reservedBy.getName());
                return;
            } else {
                System.out.println("Miejsce " + seat + " jest już zarezerwowane przez ciebie. Przechodzę do zakupu.");
            }
        }

        purchasedTickets.put(seat, customer);
        reservedSeats.remove(seat);
        customer.addTicket(seat);
        System.out.println("Bilet na miejsce " + seat + " został zakupiony przez " + customer.getName());

        if (customer.getReservationCode() != null) {
            System.out.println("Kod odbioru biletu dla gościa: " + customer.getReservationCode());
        }
    }

    @Override
    public String toString() {
        return movie.getTitle() + " - " + dateTime.toString() + " w " + hall.getName()
                + (is3D ? " [3D]" : "") + (isVIP ? " [VIP]" : "");
    }
}
