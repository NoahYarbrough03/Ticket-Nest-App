package Event;

import java.util.Date; // Import Date from java.util
import java.util.UUID;

public class Event {
    private UUID eventId;
    private String name;
    private String venue;
    private Date date; // Changed type to java.util.Date
    private int ticketsAvailable;
    private double ticketPrice;

    // Constructor
    public Event(String name, String venue, Date date, int ticketsAvailable, double ticketPrice) {
        this.eventId = UUID.randomUUID();
        this.name = name;
        this.venue = venue;
        this.date = date;
        this.ticketsAvailable = ticketsAvailable;
        this.ticketPrice = ticketPrice;
    }

    // Getters and setters
    public UUID getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTicketsAvailable() {
        return ticketsAvailable;
    }

    public void setTicketsAvailable(int ticketsAvailable) {
        this.ticketsAvailable = ticketsAvailable;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
