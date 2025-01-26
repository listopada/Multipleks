import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Tworzymy kino
        Cinema cinema1 = new Cinema("Milenium", "ul. Śliczna 50");

        // Tworzymy filmy
        Movie movie1 = new Movie("Avatar 2", "Film 3D o futurystycznym świecie", 180);
        Movie movie2 = new Movie("Oppenheimer", "Historia życia J. Roberta Oppenheimera", 150);

        // Tworzymy sale kinowe
        CinemaHall hall1 = new CinemaHall("Sala 1", 100);
        CinemaHall hall2 = new CinemaHall("Sala 2", 80);

        // Tworzymy seanse
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.FEBRUARY, 1, 20, 0);  // 1 lutego 2025, godz. 20:00
        Date dateTime1 = cal.getTime();
        Show show1 = new Show(movie1, dateTime1, true, false);

        cal.set(2025, Calendar.FEBRUARY, 2, 18, 30);  // 2 lutego 2025, godz. 18:30
        Date dateTime2 = cal.getTime();
        Show show2 = new Show(movie2, dateTime2, false, true);

        hall1.addShow(show1);
        hall2.addShow(show2);

        // Dodajemy sale do kina
        cinema1.addHall(hall1);
        cinema1.addHall(hall2);

        // Wyświetlamy repertuar
        cinema1.printProgramme();

        // Tworzymy klienta
        Customer customer = new Customer("Jan Kowalski");

        // Rezerwujemy miejsca
        show1.reservePlaces(null,"H35", "H36"); // Rezerwacja miejsc bez klienta
        show2.reservePlaces( customer,"H12", "H13"); // Rezerwacja miejsc przez klienta

        // Kupowanie biletów z wyprzedzeniem
        show1.purchaseTicket("H37", customer);  // Zakup biletu na miejsce H37

        // Wyświetlanie biletów klienta
        customer.printTickets();

        // Zakup biletów bez konta (gość)
        Customer guest = null; // Gość, który nie ma konta
        show1.purchaseTicket("H38", guest);  // Zakup biletu przez gościa

    }
}