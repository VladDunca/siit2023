package org.example;

import java.util.Random;

class FestivalAttendeeThread extends Thread {
    private final FestivalGate gate;
    private final Random random;

    FestivalAttendeeThread(FestivalGate gate) {
        this.gate = gate;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TicketType ticketType = generateRandomTicketType();
        gate.addTicket(ticketType);
    }

    private TicketType generateRandomTicketType() {
        TicketType[] ticketTypes = TicketType.values();
        return ticketTypes[random.nextInt(ticketTypes.length)];
    }
}

