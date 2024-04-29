package Ticket;

import java.util.UUID;
import User.User;
import Event.Event;
import DBmanager.DatabaseManager;

public class Ticket {
    private UUID ticketId;
    private Event event;
    private User user;
    private DatabaseManager databaseManager;

    // Constructor
    public Ticket(Event event, User user) {
        this.ticketId = UUID.randomUUID();
        this.event = event;
        this.user = user;
        this.databaseManager = new DatabaseManager();
    }

    // Method to purchase ticket
    public boolean purchaseTicket() {
        // Purchase the ticket in the database
        return databaseManager.purchaseTicket(event, user);
    }

    // Method to transfer ticket to another user
    public boolean transferTicket(User recipient) {
        // Transfer the ticket in the database
        return databaseManager.transferTicket(this, user, recipient);
    }

    // Method to cancel ticket
    public boolean cancelTicket() {
        // Cancel the ticket in the database
        return databaseManager.cancelTicket(this, user);
    }

    // Getters and setters
    public UUID getTicketId() {
        return ticketId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
