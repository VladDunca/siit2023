package org.example;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvData = """
                AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting
                11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo
                1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo
                27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx
                7,Laura Dahlmeier,DE,28:45,ooxxo,xxoox,ooxxx
                42,Martin Fourcade,FR,31:02,xxoxx,oooox,xoxxo
                """;

        List<BiathlonAthlete> athletes = BiathlonCSVParser.parseCSVData(csvData);

        Collections.sort(athletes);

        for (BiathlonAthlete athlete : athletes) {
            System.out.println(athlete.getAthleteName() + ": " + athlete.calculateTotalTime() + " (" + athlete.getSkiTimeResult() + " + " + athlete.calculatePenaltyTime() + ")");
        }
    }
}