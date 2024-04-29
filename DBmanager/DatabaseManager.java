package DBmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import Event.Event;
import Ticket.Ticket;
import User.User;

public class DatabaseManager {
    private Connection connection;
    
    public DatabaseManager() {
        // Initialize the database connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket_app", "TicketAppUser", "TicketAppUser");
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }
    
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close the database connection: " + e.getMessage());
        }
    }
    
    // User management methods
    public boolean registerUser(User user) {
        String query = "INSERT INTO users (user_id, username, email, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, user.getUserId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Failed to register user: " + e.getMessage());
            return false;
        }
    }
    
    public boolean changePassword(UUID userId, String newPassword) {
        String query = "UPDATE users SET password = ? WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newPassword);
            statement.setObject(2, userId);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Failed to change password: " + e.getMessage());
            return false;
        }
    }
    
    public boolean updateEmail(UUID userId, String newEmail) {
        String query = "UPDATE users SET email = ? WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newEmail);
            statement.setObject(2, userId);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Failed to update email: " + e.getMessage());
            return false;
        }
    }
    
    // Event management methods
    public boolean createEvent(Event event) {
        String query = "INSERT INTO events (event_id, name, venue, date, tickets_available, ticket_price) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, event.getEventId());
            statement.setString(2, event.getName());
            statement.setString(3, event.getVenue());
            statement.setDate(4, new java.sql.Date(event.getDate().getTime()));
            statement.setInt(5, event.getTicketsAvailable());
            statement.setDouble(6, event.getTicketPrice());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Failed to create event: " + e.getMessage());
            return false;
        }
    }
    
    public boolean updateEvent(UUID eventId, String newName, String newVenue, Date newDate, int newTicketsAvailable, double newTicketPrice) {
        String query = "UPDATE events SET name=?, venue=?, date=?, tickets_available=?, ticket_price=? WHERE event_id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newName);
            statement.setString(2, newVenue);
            statement.setDate(3, new java.sql.Date(newDate.getTime()));
            statement.setInt(4, newTicketsAvailable);
            statement.setDouble(5, newTicketPrice);
            statement.setObject(6, eventId);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Failed to update event: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteEvent(UUID eventId) {
        String query = "DELETE FROM events WHERE event_id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, eventId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Failed to delete event: " + e.getMessage());
            return false;
        }
    }
    
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM events";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UUID eventId = UUID.fromString(resultSet.getString("event_id"));
                String name = resultSet.getString("name");
                String venue = resultSet.getString("venue");
                Date date = resultSet.getDate("date");
                int ticketsAvailable = resultSet.getInt("tickets_available");
                double ticketPrice = resultSet.getDouble("ticket_price");
                events.add(new Event(eventId, name, venue, date, ticketsAvailable, ticketPrice));
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve events: " + e.getMessage());
        }
        return events;
    }
    
    public Event getEventById(UUID eventId) {
        String query = "SELECT * FROM events WHERE event_id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, eventId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String venue = resultSet.getString("venue");
                Date date = resultSet.getDate("date");
                int ticketsAvailable = resultSet.getInt("tickets_available");
                double ticketPrice = resultSet.getDouble("ticket_price");
                return new Event(eventId, name, venue, date, ticketsAvailable, ticketPrice);
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve event: " + e.getMessage());
        }
        return null;
    }
    
    // Ticket management methods
    public boolean purchaseTicket(Ticket ticket) {
        String query = "INSERT INTO tickets (ticket_id, event_id, user_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, ticket.getTicketId());
            statement.setObject(2, ticket.getEvent().getEventId());
            statement.setObject(3, ticket.getUser().getUserId());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Failed to purchase ticket: " + e.getMessage());
            return false;
        }
    }
    
    public boolean transferTicket(Ticket ticket, User sender, User recipient) {
        // Your implementation for ticket transfer
        return false;
    }
    
    public boolean cancelTicket(Ticket ticket, User user) {
        // Your implementation for ticket cancellation
        return false;
    }
    
    public List<Ticket> getTicketsByUser(User user) {
        // Your implementation to retrieve tickets by user
        return new ArrayList<>();
    }
    
    public List<Ticket> getAllTickets() {
        // Your implementation to retrieve all tickets
        return new ArrayList<>();
    }
}
