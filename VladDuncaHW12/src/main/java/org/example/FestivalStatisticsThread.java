package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FestivalStatisticsThread extends Thread {
    private final FestivalGate gate;
    private static final int MIN_ATTENDEES_PER_SCAN = 3;
    private static final int MAX_ATTENDEES_PER_SCAN = 18;
    private final AtomicInteger totalAttendeesScanned;
    private final Map<TicketType, AtomicInteger> totalTicketCounts;

    FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
        this.totalAttendeesScanned = new AtomicInteger(0);
        this.totalTicketCounts = new HashMap<>();
        initializeTicketCounts();
    }

    private void initializeTicketCounts() {
        for (TicketType ticketType : TicketType.values()) {
            totalTicketCounts.put(ticketType, new AtomicInteger(0));
        }
    }

    @Override
    public void run() {
        while (true) {
            int attendeesPerScan = getRandomAttendeesPerScan();
            generateStatistics(attendeesPerScan);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Every attendee has been scanned");
                System.exit(0);
            }
        }
    }

    private int getRandomAttendeesPerScan() {
        return (int) (Math.random() * (MAX_ATTENDEES_PER_SCAN - MIN_ATTENDEES_PER_SCAN + 1)) + MIN_ATTENDEES_PER_SCAN;
    }

    private void generateStatistics(int attendeesPerScan) {
        int totalScanned = 0;

        TicketType ticket;
        while (totalScanned < attendeesPerScan && (ticket = gate.validateTicket()) != null) {
            totalTicketCounts.get(ticket).incrementAndGet();
            totalScanned++;
            totalAttendeesScanned.incrementAndGet();
        }

        displayTotalTicketCounts();
    }

    private void displayTotalTicketCounts() {
        System.out.println("Total attendees scanned: " + totalAttendeesScanned.get());
        System.out.println("Total ticket counts:");
        for (TicketType ticketType : TicketType.values()) {
            System.out.println(ticketType + ": " + totalTicketCounts.get(ticketType).get());
        }
        System.out.println("----------------------------");
    }

    public AtomicInteger getTotalAttendeesScanned() {
        return totalAttendeesScanned;
    }
}
