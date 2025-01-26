import java.util.Date;
import java.util.HashSet;
import java.util.Set;

class Show {
    private Movie movie;
    private Date dateTime;
    private String hallName;
    private Set<String> reservedSeats;
    private Set<String> purchasedTickets;  // Zbiór zakupionych biletów
    private boolean is3D;
    private boolean isVIP;

    public Show(Movie movie, Date dateTime, boolean is3D, boolean isVIP) {
        this.movie = movie;
        this.dateTime = dateTime;
        this.hallName = hallName;
        this.reservedSeats = new HashSet<>();
        this.purchasedTickets = new HashSet<>();
        this.is3D = is3D;
        this.isVIP = isVIP;
    }

    public String getHallName() {
        return hallName;
    }

    public Movie getMovie() {
        return movie;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void reservePlaces(Customer customer, String... seats) {
        if (customer != null) {
            // Jeżeli klient jest zarejestrowany, to przypisujemy rezerwacje do klienta
            for (String seat : seats) {
                if (reservedSeats.contains(seat)) {
                    System.out.println("Miejsce " + seat + " jest już zarezerwowane.");
                } else {
                    reservedSeats.add(seat);
                    customer.addTicket(seat);  // Dodajemy miejsce do biletów klienta
                    System.out.println("Miejsce " + seat + " zostało zarezerwowane przez klienta " + customer.getName());
                }
            }
        } else {
            // Jeżeli klient nie jest zarejestrowany (null), rezerwujemy tylko miejsce
            for (String seat : seats) {
                if (reservedSeats.contains(seat)) {
                    System.out.println("Miejsce " + seat + " jest już zarezerwowane.");
                } else {
                    reservedSeats.add(seat);
                    System.out.println("Miejsce " + seat + " zostało zarezerwowane.");
                }
            }
        }
    }

    public void purchaseTicket(String seat, Customer customer) {
        if (reservedSeats.contains(seat)) {
            System.out.println("Miejsce " + seat + " jest już zarezerwowane, nie można go kupić.");
        } else if (purchasedTickets.contains(seat)) {
            System.out.println("Bilet na miejsce " + seat + " został już zakupiony.");
        } else {
            purchasedTickets.add(seat);
            if (customer != null) {
                customer.addTicket(seat);
            }
            System.out.println("Bilet na miejsce " + seat + " został zakupiony.");
        }
    }

    public boolean is3D() {
        return is3D;
    }

    public boolean isVIP() {
        return isVIP;
    }

    @Override
    public String toString() {
        return movie.getTitle() + " - " + dateTime.toString() + " w " + hallName
                + (is3D ? " [3D]" : "") + (isVIP ? " [VIP]" : "");
    }
}