package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String inputFilename = "input.txt";
        String outputFilename = "output.txt";

        // Running the BirthdayMatcher application
        String[] appArgs = {inputFilename, "7", outputFilename};
        BirthdayMatcher.main(appArgs);

        // Displaying the content of the output file
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFilename))) {
            String line;
            System.out.println("Output:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}