package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Calculator;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

class CalculatorTest {

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
}
