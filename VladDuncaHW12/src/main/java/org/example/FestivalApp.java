package org.example;

public class FestivalApp {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
        statisticsThread.start();

        int totalAttendees = 100;
        int generatedAttendees = 0;

        while (generatedAttendees < totalAttendees) {
            FestivalAttendeeThread attendeeThread = new FestivalAttendeeThread(gate);
            attendeeThread.start();
            generatedAttendees++;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (statisticsThread.getTotalAttendeesScanned().get() < totalAttendees) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        statisticsThread.interrupt();

    }
}

