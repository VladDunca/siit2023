package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class BiathlonCSVParser {
    public static List<BiathlonAthlete> parseCSVData(String csvData) {
        List<BiathlonAthlete> athletes = new ArrayList<>();

        try (StringReader stringReader = new StringReader(csvData);
             CSVParser csvParser = new CSVParser(stringReader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord csvRecord : csvParser) {
                int athleteNumber = Integer.parseInt(csvRecord.get("AthleteNumber"));
                String athleteName = csvRecord.get("AthleteName");
                String countryCode = csvRecord.get("CountryCode");
                String skiTimeResult = csvRecord.get("SkiTimeResult(Minutes:Seconds)");
                String firstShooting = csvRecord.get("FirstShootingRange");
                String secondShooting = csvRecord.get("SecondShooting");
                String thirdShooting = csvRecord.get("ThirdShooting");

                BiathlonAthlete athlete = new BiathlonAthlete(athleteNumber, athleteName, countryCode, skiTimeResult);
                athlete.setFirstShooting(firstShooting);
                athlete.setSecondShooting(secondShooting);
                athlete.setThirdShooting(thirdShooting);
                athletes.add(athlete);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        return athletes;
    }
}

