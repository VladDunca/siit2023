package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShootingResultTest {

    @Test
    public void testGetSymbol_Hit() {
        char symbol = ShootingResult.HIT.getSymbol();
        assertEquals('x', symbol);
    }

    @Test
    public void testGetSymbol_Miss() {
        char symbol = ShootingResult.MISS.getSymbol();
        assertEquals('o', symbol);
    }

    @Test
    public void testFromSymbol_ValidHit() {
        ShootingResult result = ShootingResult.fromSymbol('x');
        assertEquals(ShootingResult.HIT, result);
    }

    @Test
    public void testFromSymbol_ValidMiss() {
        ShootingResult result = ShootingResult.fromSymbol('o');
        assertEquals(ShootingResult.MISS, result);
    }

    @Test
    public void testFromSymbol_InvalidSymbol() {
        assertThrows(IllegalArgumentException.class, () -> ShootingResult.fromSymbol('z'));
    }
}
