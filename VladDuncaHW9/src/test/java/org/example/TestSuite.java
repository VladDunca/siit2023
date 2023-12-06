package org.example;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("All Tests")
@SelectClasses({
        BiathlonAthleteTest.class,
        BiathlonCSVParserTest.class,
        ShootingResultTest.class
})
public class TestSuite {
}

