package Ticket;

import java.util.UUID;
import User.User;

public class TicketTransfer {
    private UUID transferId;
    private Ticket ticket;
    private User sender;
    private User recipient;

    public TicketTransfer(Ticket ticket, User sender, User recipient) {
        this.transferId = UUID.randomUUID();
        this.ticket = ticket;
        this.sender = sender;
        this.recipient = recipient;
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

    // Additional functionality: Transfer ticket to another user
    public void transferTicket(User newRecipient) {
        if (newRecipient != null) {
            this.recipient = newRecipient;
            System.out.println("Ticket transfer successful!");
        } else {
            System.out.println("Invalid recipient.");
        }
    }

    // Additional functionality: Cancel ticket transfer
    public void cancelTransfer() {
        this.recipient = this.sender;
        System.out.println("Ticket transfer cancelled.");
    }
}