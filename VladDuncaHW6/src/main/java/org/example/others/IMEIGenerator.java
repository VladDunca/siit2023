package org.example.others;

import org.apache.commons.lang3.RandomStringUtils;

public class IMEIGenerator {
    public static String generate(){
        boolean useLetters = false;
        boolean useNumbers = true;
        int stringLength = 15;

        return RandomStringUtils.random(stringLength, useLetters, useNumbers);
    }
}
