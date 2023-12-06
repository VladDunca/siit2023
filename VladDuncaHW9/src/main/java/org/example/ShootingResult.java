package org.example;
public enum ShootingResult {
    HIT('x'),
    MISS('o');

    private final char symbol;

    ShootingResult(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static ShootingResult fromSymbol(char symbol) {
        for (ShootingResult result : ShootingResult.values()) {
            if (result.getSymbol() == symbol) {
                return result;
            }
        }
        throw new IllegalArgumentException("Invalid symbol for shooting result");
    }
}

