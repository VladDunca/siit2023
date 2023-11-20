package org.example.helpers;

import org.example.enums.Metrics;

public class MetricConverter {
    private final ConvertChecker convertChecker;

    public MetricConverter() {
        convertChecker = new ConvertChecker();
    }

    public String convertElement(String value, String metric) {
        int number = Integer.parseInt(value);

        for (Metrics metrics : Metrics.values()) {
            if (metrics.getName().equalsIgnoreCase(metric)) {
                number *= metrics.getMultiplier();
                break;
            }
        }
        return String.valueOf(number);
    }

    public String convertExpression(String expression) {
        if (!convertChecker.check(expression)) {
            return "";
        }

        String[] expressionArr = expression.split(" ");
        StringBuilder newExpression = new StringBuilder();

        for (int i = 0; i < expressionArr.length; i++) {
            if (convertChecker.isInteger(expressionArr[i])) {
                newExpression.append(convertElement(expressionArr[i], expressionArr[i + 1]));
            }
            if (convertChecker.isSymbol(expressionArr[i])) {
                newExpression.append(" ").append(expressionArr[i]).append(" ");
            }
        }

        return newExpression.toString();
    }
}
