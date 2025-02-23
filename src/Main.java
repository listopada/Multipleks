import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Multipleks multipleks = new Multipleks();

        Movie movie1 = new Movie("Avatar 2", "Film 3D o futurystycznym świecie", 180);
        Movie movie2 = new Movie("Oppenheimer", "Historia życia J. Roberta Oppenheimera", 150);

        multipleks.addMovie(movie1);
        multipleks.addMovie(movie2);

        Cinema cinema1 = new Cinema("Milenium", "ul. Śliczna 50", multipleks);

        CinemaHall hall1 = new CinemaHall("Sala 1", 100);
        CinemaHall hall2 = new CinemaHall("Sala 2", 80);

        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.FEBRUARY, 1, 20, 0);  // 1 lutego 2025, godz. 20:00
        Date dateTime1 = cal.getTime();
        Show show1 = new Show("Avatar 2", dateTime1, hall1, true, false, multipleks);

        cal.set(2025, Calendar.FEBRUARY, 2, 18, 30);  // 2 lutego 2025, godz. 18:30
        Date dateTime2 = cal.getTime();
        Show show2 = new Show("Oppenheimer", dateTime2, hall2, false, true, multipleks);

        hall1.addShow(show1);
        hall2.addShow(show2);

        cinema1.addHall(hall1);
        cinema1.addHall(hall2);

        cinema1.printProgramme();

        Customer customer = new Customer("Jan Kowalski");

        String guestCode = UUID.randomUUID().toString().substring(0, 8);
        Customer guest = new Customer("Gość", guestCode);

        show1.reservePlaces(guest, "H35", "H36");
        show2.reservePlaces(customer, "H12", "H13");

        show1.purchaseTicket(customer, "H37");

        System.out.println("\nBilety klienta:");
        customer.printTickets();

        show1.purchaseTicket(guest, "H38");

        System.out.println("\nBilety gościa (użyj kodu do odbioru):");
        guest.printTickets();
        System.out.println("Kod odbioru biletu: " + guestCode);
    }
}
