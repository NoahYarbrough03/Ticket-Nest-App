package User;


import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> userList;

    public UserManager() {
        this.userList = new ArrayList<>();
    }

    public void createUser(String username, String email, String password) {
        User user = new User(username, email, password);
        userList.add(user);
        System.out.println("User created successfully.");
    }

    public void updateUser(User user, String newUsername, String newEmail, String newPassword) {
        if (userList.contains(user)) {
            user.setUsername(newUsername);
            user.setEmail(newEmail);
            user.setPassword(newPassword);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("Failed to update user. User not found.");
        }
    }

    public void deleteUser(User user) {
        if (userList.contains(user)) {
            userList.remove(user);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("Failed to delete user. User not found.");
        }
    }

    public List<User> getAllUsers() {
        return userList;
    }
}
