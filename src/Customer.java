import java.util.HashSet;
import java.util.Set;

class Customer {
    private String name;
    private Set<String> tickets;

    public Customer(String name) {
        this.name = name;
        this.tickets = new HashSet<>();
    }

    public String getName() {
        return name;
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