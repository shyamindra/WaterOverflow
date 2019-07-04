package com.plexus.glass;

import com.plexus.exceptions.LiquidOverFlowException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GlassStackTest {

    @Test
    void testBuildGlassStack(){
        assertEquals(6, new GlassStack(3, 250).getGlassStack().size());
    }

    @Test
    void testFillVolume_200ml(){
        GlassStack glassStack = new GlassStack(3, 250);
        glassStack.fillLiquid(200);
        assertEquals(200, glassStack.getGlassFilledVolume(0,0));
    }

    @Test
    void testFillVolume_300ml(){
        GlassStack glassStack = new GlassStack(3, 250);
        glassStack.fillLiquid(300);
        assertEquals(250, glassStack.getGlassFilledVolume(0,0));
        assertEquals(25, glassStack.getGlassFilledVolume(1,0));
        assertEquals(25, glassStack.getGlassFilledVolume(1,1));
    }

    @Test
    void testFillVolume_1250ml(){
        GlassStack glassStack = new GlassStack(3, 250);
        glassStack.fillLiquid(1250);
        assertEquals(250, glassStack.getGlassFilledVolume(0,0));
        assertEquals(250, glassStack.getGlassFilledVolume(1,0));
        assertEquals(250, glassStack.getGlassFilledVolume(1,1));
    }

    @Test
    void testFillVolume_1500ml(){
        GlassStack glassStack = new GlassStack(3, 250);
        assertThrows(LiquidOverFlowException.class, () -> glassStack.fillLiquid(1500));
    }

    @Test
    void testFillVolume_1600ml(){
        GlassStack glassStack = new GlassStack(3, 250);
        assertThrows(LiquidOverFlowException.class, () -> glassStack.fillLiquid(1600));
    }

    @Test
    void testInvalidCoordinatesException(){
        GlassStack glassStack = new GlassStack(3, 250);
        assertThrows(RuntimeException.class, () -> glassStack.getGlassFilledVolume(3,3));
    }

}
