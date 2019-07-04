package com.plexus.glass;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GlassTest
{
    @Test
    void initGlassTest(){
        IGlass glass = new Glass();
    }

    @Test
    void testIsGlassFull(){
        IGlass glass = new Glass();
        assertEquals(false, glass.isFull());
    }

    @Test
    void testAddLiquid(){
        IGlass glass = new Glass();
        glass.addLiquid(100);
    }

}
