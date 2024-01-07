package org.example;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FestivalGate {
    private final Queue<TicketType> ticketQueue;

    FestivalGate() {
        this.ticketQueue = new ConcurrentLinkedQueue<>();
    }

    public void addTicket(TicketType ticketType) {
        ticketQueue.add(ticketType);
    }

    public TicketType validateTicket() {
        return ticketQueue.poll();
    }

    public int getTotalTickets() {
        return ticketQueue.size();
    }
}
