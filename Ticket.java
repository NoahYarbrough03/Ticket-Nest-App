package Ticket;

import Event.Event;
import User.User;
import java.util.UUID;

public class Ticket {
    private UUID ticketId;
    private Event event;
    private User user;

    // Constructor
    public Ticket(Event event, User user) {
        this.ticketId = UUID.randomUUID();
        this.event = event;
        this.user = user;
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
