package Ticket;

import java.util.ArrayList;
import java.util.List;

import Event.Event;
import User.User;

public class TicketManager {
    private List<Ticket> ticketList;

    public TicketManager() {
        this.ticketList = new ArrayList<>();
    }

    public void purchaseTicket(Event event, User user) {
        Ticket ticket = new Ticket(event, user);
        ticketList.add(ticket);
        System.out.println("Ticket purchased successfully.");
    }

    public void transferTicket(Ticket ticket, User sender, User recipient) {
        if (ticketList.contains(ticket) && ticket.getUser().equals(sender)) {
            ticket.setUser(recipient);
            System.out.println("Ticket transferred successfully.");
        } else {
            System.out.println("Failed to transfer ticket. Invalid ticket or sender.");
        }
    }

    public void cancelTicket(Ticket ticket, User user) {
        if (ticketList.contains(ticket) && ticket.getUser().equals(user)) {
            ticketList.remove(ticket);
            System.out.println("Ticket cancelled successfully.");
        } else {
            System.out.println("Failed to cancel ticket. Invalid ticket or user.");
        }
    }

    public List<Ticket> getTicketsByUser(User user) {
        List<Ticket> userTickets = new ArrayList<>();
        for (Ticket ticket : ticketList) {
            if (ticket.getUser().equals(user)) {
                userTickets.add(ticket);
            }
        }
        return userTickets;
    }

    public List<Ticket> getAllTickets() {
        return ticketList;
    }
}
