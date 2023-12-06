package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BiathlonAthleteTest {

    @Test
    public void testCalculatePenaltyTime_NoPenalty() {
        BiathlonAthlete athlete = new BiathlonAthlete(1, "John Doe", "USA", "30:00");
        athlete.setFirstShooting("xxxxx");
        athlete.setSecondShooting("xxxxx");
        athlete.setThirdShooting("xxxxx");

        int expectedPenalty = 0;
        int actualPenalty = athlete.calculatePenaltyTime();

        assertEquals(expectedPenalty, actualPenalty);
    }

    @Test
    public void testCalculateTotalTime_NoPenalty() {
        BiathlonAthlete athlete = new BiathlonAthlete(2, "Jane Smith", "CAN", "28:30");
        athlete.setFirstShooting("xxxxx");
        athlete.setSecondShooting("xxxxx");
        athlete.setThirdShooting("xxxxx");

        String expectedTotalTime = "28:30";
        String actualTotalTime = athlete.calculateTotalTime();

        assertEquals(expectedTotalTime, actualTotalTime);
    }

    @Test
    public void testCalculateTotalTime_WithPenalty() {
        BiathlonAthlete athlete = new BiathlonAthlete(3, "Alice Johnson", "GER", "32:00");
        athlete.setFirstShooting("xxxxo");
        athlete.setSecondShooting("xxxxx");
        athlete.setThirdShooting("xxxxo");

        String expectedTotalTime = "32:20"; // 20 seconds penalty
        String actualTotalTime = athlete.calculateTotalTime();

        assertEquals(expectedTotalTime, actualTotalTime);
    }

    @Test
    public void testCalculatePenaltyTime_WithPenalties() {
        BiathlonAthlete athlete = new BiathlonAthlete(4, "Michael Brown", "SWE", "27:45");
        athlete.setFirstShooting("xxoxo");
        athlete.setSecondShooting("xxxxx");
        athlete.setThirdShooting("ooxxx");

        int expectedPenalty = 40; // Four penalties, 10 seconds each
        int actualPenalty = athlete.calculatePenaltyTime();

        assertEquals(expectedPenalty, actualPenalty);
    }
}
