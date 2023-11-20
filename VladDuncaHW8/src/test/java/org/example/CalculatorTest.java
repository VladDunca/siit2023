package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @AfterEach
    void restoreSystemInput() {
        System.setIn(System.in);
    }
    @Test
    void testCalculateValidExpression() {
        String input = "12 cm + 20 mm - 3 km";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);

        Calculator calculator = new Calculator(scanner);
        assertEquals(" = -2999860 mm", calculator.calculate());
    }

    @Test
    void testCalculateInvalidExpression() {
        String input = "12 cm + 20 - 3 km";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);

        Calculator calculator = new Calculator(scanner);
        assertEquals("Invalid Format", calculator.calculate());
    }
    @ParameterizedTest
    @CsvSource({
            "12 cm + 20 mm - 3 km, -2999860",
            "2 m - 5 cm + 3 km, 3001950"
    })
    void testCalculateWithDifferentInputs(String inputExpression, String expectedResult) {
        InputStream inputStream = new ByteArrayInputStream(inputExpression.getBytes());
        System.setIn(inputStream);

        Calculator calculator = new Calculator();
        String result = calculator.calculate();
        assertEquals("= " + expectedResult + " mm", result.trim());
    }
}
