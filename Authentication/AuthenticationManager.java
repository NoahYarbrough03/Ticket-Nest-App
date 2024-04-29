package Authentication;

import java.util.HashMap;
import java.util.Map;

import User.User;

public class AuthenticationManager {
    private Map<String, User> users; // Map of username-user pairs

    public AuthenticationManager() {
        this.users = new HashMap<>();
    }

    public void registerUser(String username, String email, String password) {
        if (!users.containsKey(username)) {
            User newUser = new User(username, email, password);
            users.put(username, newUser);
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Username already exists. Please choose a different username.");
        }
    }

    public boolean authenticateUser(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.getPassword().equals(password)) {
                System.out.println("Authentication successful.");
                return true;
            }
        }
        System.out.println("Authentication failed. Invalid username or password.");
        return false;
    }

    public void unregisterUser(String username) {
        if (users.containsKey(username)) {
            users.remove(username);
            System.out.println("User unregistered successfully.");
        } else {
            System.out.println("Username not found.");
        }
    }
}
