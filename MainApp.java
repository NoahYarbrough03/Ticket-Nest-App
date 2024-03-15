package MainApp;

import java.util.Date; // Import Date class

import Ticket.Ticket;
import Event.Event;
import User.User;

public class MainApp {
    public static void main(String[] args) {
        // Create sample users
        User user1 = new User("user1", "user1@example.com", "password1");
        User user2 = new User("user2", "user2@example.com", "password2");

        // Create sample events with a date
        Date date = new Date(); // Current date
        Event event1 = new Event("Concert", "Venue A", date, 100, 50.0);
        Event event2 = new Event("Sports Game", "Venue B", date, 200, 75.0);

        // Create tickets
        Ticket ticket1 = new Ticket(event1, user1);
        Ticket ticket2 = new Ticket(event2, user2);

        // Display ticket information
        System.out.println("Ticket 1:");
        System.out.println("Ticket ID: " + ticket1.getTicketId());
        System.out.println("Event: " + ticket1.getEvent().getName());
        System.out.println("User: " + ticket1.getUser().getUsername());

        System.out.println("\nTicket 2:");
        System.out.println("Ticket ID: " + ticket2.getTicketId());
        System.out.println("Event: " + ticket2.getEvent().getName());
        System.out.println("User: " + ticket2.getUser().getUsername());
    }
}
