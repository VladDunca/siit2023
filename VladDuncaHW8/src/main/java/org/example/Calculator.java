package org.example;

import org.example.helpers.MetricConverter;

import java.util.Scanner;

public class Calculator {
    private final MetricConverter metricConverter;
    private final Scanner scanner;

    public Calculator() {
        metricConverter = new MetricConverter();
        scanner = new Scanner(System.in);
    }

    public Calculator(Scanner scanner) {
        metricConverter = new MetricConverter();
        this.scanner = scanner;
    }

    public String calculate() {
        String expression = scanner.nextLine();
        String convertedExpression = metricConverter.convertExpression(expression);
        if ("".equals(convertedExpression)){
            return "Invalid Format";
        }
        String[] expressionArr = convertedExpression.split(" ");
        int result = Integer.parseInt(expressionArr[0]);

        for (int i = 1; i < expressionArr.length; i++) {
            if ("+".equals(expressionArr[i])) {
                result += Integer.parseInt(expressionArr[i + 1]);
            }
            if ("-".equals(expressionArr[i])) {
                result -= Integer.parseInt(expressionArr[i + 1]);
            }
        }
        return " = " + result + " mm";
    }
}

