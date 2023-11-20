package org.example;

import org.example.helpers.ConvertCheckerTest;
import org.example.helpers.MetricConverterTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        ConvertCheckerTest.class,
        MetricConverterTest.class,
        CalculatorTest.class
})
public class TestSuite {
    // This class doesn't contain any code as it's a test suite declaration
    // It just collects and runs the specified test classes
}

