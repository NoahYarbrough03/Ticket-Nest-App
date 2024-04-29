package Event;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import DBmanager.DatabaseManager;

public class EventManager {
    private DatabaseManager databaseManager;

    public EventManager() {
        this.databaseManager = new DatabaseManager();
    }

    // Method to create a new event
    public boolean createEvent(String name, String venue, Date date, int ticketsAvailable, double ticketPrice) {
        // Create a new event object
        Event newEvent = new Event(name, venue, date, ticketsAvailable, ticketPrice);

        // Add the event to the database
        if (databaseManager.createEvent(newEvent)) {
            System.out.println("Event created successfully.");
            return true;
        } else {
            System.out.println("Failed to create event.");
            return false;
        }
    }

    // Method to update an existing event
    public boolean updateEvent(Event event, String name, String venue, Date date, int ticketsAvailable, double ticketPrice) {
        // Update the event in the database
        // Note: This method might require additional validation or checks
        // For simplicity, let's assume that the event is updated directly in the database
        // without further checks
        return databaseManager.updateEvent(event, name, venue, date, ticketsAvailable, ticketPrice);
    }

    // Method to delete an existing event
    public boolean deleteEvent(Event event) {
        // Delete the event from the database
        // Note: This method might require additional checks or confirmation
        // For simplicity, let's assume that the event is deleted directly from the database
        // without further checks
        return databaseManager.deleteEvent(event);
    }

    // Method to retrieve all events
    public List<Event> getAllEvents() {
        // Retrieve all events from the database
        return databaseManager.getAllEvents();
    }

    // Method to retrieve an event by its unique identifier
    public Event getEventById(UUID eventId) {
        // Retrieve the event from the database
        return databaseManager.getEventById(eventId);
    }
}
