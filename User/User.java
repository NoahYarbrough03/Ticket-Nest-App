package User;

import java.util.UUID;
import DBmanager.DatabaseManager;

public class User {
    private UUID userId;
    private String username;
    private String email;
    private String password;
    private DatabaseManager databaseManager;

    public User(String username, String email, String password) {
        this.userId = UUID.randomUUID();
        this.username = username;
        this.email = email;
        this.password = password;
        this.databaseManager = new DatabaseManager();
    }

    // Method to change password
    public boolean changePassword(String newPassword) {
        // Change password in the database
        return databaseManager.changePassword(userId, newPassword);
    }

    // Method to update email
    public boolean updateEmail(String newEmail) {
        // Update email in the database
        return databaseManager.updateEmail(userId, newEmail);
    }

    // Getters and setters
    public UUID getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
