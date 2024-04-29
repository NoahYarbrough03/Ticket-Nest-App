package User;

import java.util.ArrayList;
import java.util.List;

import DBmanager.DatabaseManager;

public class UserManager {
    private DatabaseManager databaseManager;

    public UserManager() {
        new ArrayList<>();
        this.databaseManager = new DatabaseManager();
    }

    // Method to create a new user
    public boolean createUser(String username, String email, String password) {
        // Check if the username already exists
        if (getUserByUsername(username) != null) {
            System.out.println("Username already exists. Please choose a different username.");
            return false;
        }

        // Create a new user
        User newUser = new User(username, email, password);

        // Add the user to the database
        if (databaseManager.registerUser(newUser)) {
            System.out.println("User created successfully.");
            return true;
        } else {
            System.out.println("Failed to create user.");
            return false;
        }
    }

    // Method to update an existing user
    public boolean updateUser(User user, String newUsername, String newEmail, String newPassword) {
        // Update the user in the database
        // Note: This method might require additional validation or checks
        // For simplicity, let's assume that the user is updated directly in the database
        // without further checks
        return databaseManager.updateUser(user, newUsername, newEmail, newPassword);
    }

    // Method to delet[[e an existing user
    public boolean deleteUser(User user) {
        // Delete the user from the database
        // Note: This method might require additional checks or confirmation
        // For simplicity, let's assume that the user is deleted directly from the database
        // without further checks
        return databaseManager.deleteUser(user);
    }

    // Method to retrieve a user by username
    public User getUserByUsername(String username) {
        // Retrieve the user from the database
        return databaseManager.getUserByUsername(username);
    }

    // Method to retrieve all users
    public List<User> getAllUsers() {
        // Retrieve all users from the database
        return databaseManager.getAllUsers();
    }
}