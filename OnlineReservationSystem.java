import java.util.ArrayList;
import java.util.Scanner;

class Reservation {
    String name;
    String date;
    int numberOfGuests;

    Reservation(String name, String date, int numberOfGuests) {
        this.name = name;
        this.date = date;
        this.numberOfGuests = numberOfGuests;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", numberOfGuests=" + numberOfGuests +
                '}';
    }
}

class ReservationSystem {
    private ArrayList<Reservation> reservations = new ArrayList<>();

    void makeReservation(String name, String date, int numberOfGuests) {
        Reservation reservation = new Reservation(name, date, numberOfGuests);
        reservations.add(reservation);
        System.out.println("Reservation made successfully!");
    }

    void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }

    void cancelReservation(String name) {
        boolean found = false;
        for (Reservation reservation : reservations) {
            if (reservation.name.equals(name)) {
                reservations.remove(reservation);
                System.out.println("Reservation cancelled successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Reservation not found.");
        }
    }
}

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        while (true) {
            System.out.println("1. Make a reservation");
            System.out.println("2. View all reservations");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter the date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    System.out.print("Enter the number of guests: ");
                    int numberOfGuests = sc.nextInt();
                    reservationSystem.makeReservation(name, date, numberOfGuests);
                    break;
                case 2:
                    reservationSystem.viewReservations();
                    break;
                case 3:
                    System.out.print("Enter the name for the reservation to cancel: ");
                    String cancelName = sc.nextLine();
                    reservationSystem.cancelReservation(cancelName);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
