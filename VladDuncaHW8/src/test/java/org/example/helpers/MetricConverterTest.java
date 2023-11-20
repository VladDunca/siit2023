package org.example.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MetricConverterTest {
    private MetricConverter metricConverter;

    @BeforeEach
    void setUp() {
        metricConverter = new MetricConverter();
    }

    @Test
    void testConvertElement() {
        assertEquals("120", metricConverter.convertElement("12", "cm"));
    }

    @Test
    void testConvertExpression() {
        assertEquals("120 + 2000 - 3000000", metricConverter.convertExpression("12 cm + 20 dm - 3 km"));
    }

    @Test
    void testInvalidExpressionConversion() {
        assertEquals("", metricConverter.convertExpression("12 cm + 20 - 3 km"));
    }
}
