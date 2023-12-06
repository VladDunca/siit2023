package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BiathlonCSVParserTest {

    @Test
    public void testParseCSVData_SingleEntry() {
        String csvData = "AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting\n" +
                "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";

        List<BiathlonAthlete> athletes = BiathlonCSVParser.parseCSVData(csvData);

        assertEquals(1, athletes.size());
        BiathlonAthlete athlete1 = athletes.get(0);
        assertEquals(11, athlete1.getAthleteNumber());
        assertEquals("Umar Jorgson", athlete1.getAthleteName());
    }

    @Test
    public void testParseCSVData_EmptyData() {
        String csvData = "";

        List<BiathlonAthlete> athletes = BiathlonCSVParser.parseCSVData(csvData);

        assertEquals(0, athletes.size());
    }

    @Test
    public void testParseCSVData_NullData() {
        String csvData = null;

        List<BiathlonAthlete> athletes = BiathlonCSVParser.parseCSVData(csvData);

        assertEquals(0, athletes.size());
    }

    @Test
    public void testParseCSVData_InvalidFormat() {
        String csvData = "Invalid CSV Format";

        List<BiathlonAthlete> athletes = BiathlonCSVParser.parseCSVData(csvData);

        assertEquals(0, athletes.size());
    }
}
