package org.example.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConvertCheckerTest {
    private ConvertChecker convertChecker;

    @BeforeEach
    void setUp() {
        convertChecker = new ConvertChecker();
    }

    @Test
    void testValidInteger() {
        assertTrue(convertChecker.isInteger("123"));
    }

    @Test
    void testInvalidInteger() {
        assertFalse(convertChecker.isInteger("abc"));
    }

    @Test
    void testValidMetric() {
        assertTrue(convertChecker.isMetric("mm"));
    }

    @Test
    void testInvalidMetric() {
        assertFalse(convertChecker.isMetric("inch"));
    }

    @Test
    void testSymbol() {
        assertTrue(convertChecker.isSymbol("+"));
        assertTrue(convertChecker.isSymbol("-"));
        assertFalse(convertChecker.isSymbol("*"));
    }

    @Test
    void testCheckValidExpression() {
        assertTrue(convertChecker.check("12 mm + 20 cm - 3 km"));
    }

    @Test
    void testCheckInvalidExpression() {
        assertFalse(convertChecker.check("12 mm + 20 - 3 km"));
    }
}
