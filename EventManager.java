package Event;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> eventList;

    public EventManager() {
        this.eventList = new ArrayList<>();
    }

    public void createEvent(String name, String venue, Date date, int ticketsAvailable, double ticketPrice) {
        Event event = new Event(name, venue, date, ticketsAvailable, ticketPrice);
        eventList.add(event);
        System.out.println("Event created successfully.");
    }

    public void updateEvent(Event event, String name, String venue, Date date, int ticketsAvailable, double ticketPrice) {
        if (eventList.contains(event)) {
            event.setName(name);
            event.setVenue(venue);
            event.setDate(date);
            event.setTicketsAvailable(ticketsAvailable);
            event.setTicketPrice(ticketPrice);
            System.out.println("Event updated successfully.");
        } else {
            System.out.println("Failed to update event. Event not found.");
        }
    }

    public void deleteEvent(Event event) {
        if (eventList.contains(event)) {
            eventList.remove(event);
            System.out.println("Event deleted successfully.");
        } else {
            System.out.println("Failed to delete event. Event not found.");
        }
    }

    public List<Event> getAllEvents() {
        return eventList;
    }
}
