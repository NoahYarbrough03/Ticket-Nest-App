package Ticket;

import java.util.List;
import User.User;
import Event.Event;
import DBmanager.DatabaseManager;

public class TicketManager {
    private DatabaseManager databaseManager;

    public TicketManager() {
        this.databaseManager = new DatabaseManager();
    }

    // Method to purchase a ticket
    public boolean purchaseTicket(Event event, User user) {
        // Check if the event has available tickets
        if (event.getTicketsAvailable() <= 0) {
            System.out.println("Failed to purchase ticket. No available tickets for the event.");
            return false;
        }

        // Create a new ticket object
        Ticket ticket = new Ticket(event, user);

        // Add the ticket to the database
        if (databaseManager.purchaseTicket(ticket)) {
            // Decrement available tickets for the event
            event.setTicketsAvailable(event.getTicketsAvailable() - 1);
            System.out.println("Ticket purchased successfully.");
            return true;
        } else {
            System.out.println("Failed to purchase ticket.");
            return false;
        }
    }

    // Method to transfer a ticket from one user to another
    public boolean transferTicket(Ticket ticket, User sender, User recipient) {
        // Transfer the ticket in the database
        return databaseManager.transferTicket(ticket, sender, recipient);
    }

    // Method to cancel a ticket
    public boolean cancelTicket(Ticket ticket, User user) {
        // Cancel the ticket in the database
        return databaseManager.cancelTicket(ticket, user);
    }

    // Method to retrieve all tickets for a user
    public List<Ticket> getTicketsByUser(User user) {
        // Retrieve tickets for the user from the database
        return databaseManager.getTicketsByUser(user);
    }

    // Method to retrieve all tickets
    public List<Ticket> getAllTickets() {
        // Retrieve all tickets from the database
        return databaseManager.getAllTickets();
    }
}
