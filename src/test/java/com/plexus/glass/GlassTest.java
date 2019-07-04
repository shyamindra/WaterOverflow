package com.plexus.glass;

import com.plexus.exceptions.LiquidOverFlowException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GlassTest
{
    @Test
    void initGlassTest(){
        IGlass glass = new Glass(100);
    }

    @Test
    void testIsGlassFull(){
        IGlass glass = new Glass(100);
        assertEquals(100, glass.getCapacity());
        assertEquals(false, glass.isFull());
    }

    @Test
    void testAddLiquid(){
        IGlass glass = new Glass(100);
        glass.addLiquid(100);
    }

    @Test
    void testRemainingVolume(){
        IGlass glass = new Glass(100);
        glass.addLiquid(100);
        assertEquals(0, glass.getRemainingVolume());
    }

    @Test
    void testOverFlowException(){
        IGlass glass = new Glass(100);
        assertThrows(LiquidOverFlowException.class, () -> glass.addLiquid(110));
    }

}
