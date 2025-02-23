import java.util.HashSet;
import java.util.Set;

class Customer {
    private String name;
    private Set<String> tickets;
    private String reservationCode;

    public Customer(String name) {
        this.name = name;
        this.tickets = new HashSet<>();
        this.reservationCode = null;
    }

    public Customer(String name, String reservationCode) {
        this.name = "Gość_" + reservationCode;
        this.tickets = new HashSet<>();
        this.reservationCode = reservationCode;
    }

    public String getName() {
        return name;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void addTicket(String seat) {
        tickets.add(seat);
    }

    public void printTickets() {
        if (tickets.isEmpty()) {
            System.out.println("Brak zakupionych biletów.");
        } else {
            System.out.println("Zakupione bilety klienta " + name + ":");
            for (String ticket : tickets) {
                System.out.println("Bilet na miejsce: " + ticket);
            }
        }
    }
}
