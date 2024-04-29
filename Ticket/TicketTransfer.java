package Ticket;

import java.util.UUID;
import User.User;
import DBmanager.DatabaseManager;

public class TicketTransfer {
    private UUID transferId;
    private Ticket ticket;
    private User sender;
    private User recipient;
    private DatabaseManager databaseManager;

    public TicketTransfer(Ticket ticket, User sender, User recipient) {
        this.transferId = UUID.randomUUID();
        this.ticket = ticket;
        this.sender = sender;
        this.recipient = recipient;
        this.databaseManager = new DatabaseManager();
    }

    // Method to transfer ticket to another user
    public boolean transferTicket() {
        // Transfer the ticket in the database
        return databaseManager.transferTicket(ticket, sender, recipient);
    }

    // Method to cancel ticket transfer
    public boolean cancelTransfer() {
        // Cancel the ticket transfer in the database
        return databaseManager.cancelTicketTransfer(ticket);
    }

    // Getters and setters
    public UUID getTransferId() {
        return transferId;
    }

    public void setTransferId(UUID transferId) {
        this.transferId = transferId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}
