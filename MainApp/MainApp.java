package MainApp;

import java.util.Scanner;

import Authentication.AuthenticationManager;

public class MainApp {
    private static Scanner scanner = new Scanner(System.in);
    private static AuthenticationManager authManager = new AuthenticationManager();

    public static void main(String[] args) {
        // Interactive console interface
        while (true) {
            System.out.println("Welcome to Ticket Claw, Your home for Event Tickets!");
            System.out.println("1. Log in");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method for user login
    private static void login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        boolean isAuthenticated = authManager.authenticateUser(username, password);
        if (isAuthenticated) {
            // After successful login, show main menu for ticket options
            showTicketMenu(username);
        }
    }

    // Method for user registration
    private static void register() {
        System.out.print("Enter desired username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        authManager.registerUser(username, email, password);
    }

    // Method to show ticket options after successful login
    private static void showTicketMenu(String username) {
        // You can implement ticket purchase, sale, event browsing here
        // For now, let's just print a message
        System.out.println("Welcome, " + username + "!");
        System.out.println("Ticket options will be available here.");
    }
}
