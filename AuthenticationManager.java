package Authentication;


import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    private Map<String, String> credentials; // Map of username-password pairs

    public AuthenticationManager() {
        this.credentials = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        if (!credentials.containsKey(username)) {
            credentials.put(username, password);
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Username already exists. Please choose a different username.");
        }
    }

    public boolean authenticateUser(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            System.out.println("Authentication successful.");
            return true;
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
            return false;
        }
    }

    public void unregisterUser(String username) {
        if (credentials.containsKey(username)) {
            credentials.remove(username);
            System.out.println("User unregistered successfully.");
        } else {
            System.out.println("Username not found.");
        }
    }
}
