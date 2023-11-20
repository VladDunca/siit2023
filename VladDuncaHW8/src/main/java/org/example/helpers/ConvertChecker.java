package org.example.helpers;

import org.example.enums.Metrics;

public class ConvertChecker {
    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isMetric(String str) {
        for (Metrics metrics : Metrics.values()) {
            if (metrics.getName().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSymbol(String str) {
        return "+".equals(str) || "-".equals(str);
    }

    public boolean check(String expression) {
        String[] expressionArr = expression.split(" ");

        if (expressionArr.length < 5 || expressionArr.length % 3 != 2) {
            return false;
        }

        for (int i = 0; i < expressionArr.length; i++) {
            if (i % 3 == 0) {
                if (!isInteger(expressionArr[i])) {
                    return false;
                }
            } else if (i % 3 == 1) {
                if (!isMetric(expressionArr[i])) {
                    return false;
                }
            } else if (!isSymbol(expressionArr[i])) {
                return false;
            }
        }
        return true;
    }
}
