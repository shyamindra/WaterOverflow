package com.plexus.glass;

import com.plexus.dimensions.Coordinates;
import com.plexus.exceptions.LiquidOverFlowException;

import java.util.HashMap;
import java.util.Map;

public class GlassStack {


    private final Map<Coordinates, Glass> glassStack;
    private final int rows;


    public GlassStack(int rows, int capacity){
        this.rows = rows;
        this.glassStack = buildGlassStack(this.rows, capacity);
    }

    public Map<Coordinates, Glass> getGlassStack(){
        return this.glassStack;
    }

    /*
        This class assumes that the rows and columns are always equal,
        without which the stack can't be balanced
     */
    public Map<Coordinates, Glass> buildGlassStack(int rows, int capacity){

        Map<Coordinates, Glass> glassStack = new HashMap<Coordinates, Glass>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                glassStack.put(new Coordinates(i, j), new Glass(capacity));
            }
        }
        return glassStack;
    }

    /*
        params: takes volume in ml
     */
    public void fillLiquid(int volume){
        fillLiquid(0, 0, volume);
    }

    /*
        This method iteratively fills the liquid in the glass stack. Once the glass is full,
        it moves on to the next row.

        Throws LiquidOverFlowException at Runtime if there are no glasses underneath and the liquid overflows
     */
    public void fillLiquid(int i, int j, int volume){
        Glass currentGlass = glassStack.get(new Coordinates(i, j));
        if(currentGlass.getRemainingVolume() >= volume) {
            currentGlass.addLiquid(volume);
        } else if( i < this.rows - 1) {

            int remainingVolume = volume - currentGlass.getRemainingVolume();

            // Fill up the current glass before moving on to the lower glasses
            currentGlass.addLiquid(currentGlass.getRemainingVolume());

            // Fill liquid evenly between both the lower glasses
            fillLiquid(i + 1, j, remainingVolume/2);
            fillLiquid(i + 1, j + 1, remainingVolume/2);

        } else {
            throw new LiquidOverFlowException();
        }
    }

    public int getGlassFilledVolume(int i, int j){
        Glass glass = this.glassStack.get(new Coordinates(i, j));
        if(glass == null){
            throw new RuntimeException("Invalid coordinates");
        }
        return this.glassStack.get(new Coordinates(i, j)).getFilledVolume();
    }

    @Override
    public String toString() {
        return "GlassStack{" +
                "glassStack=" + glassStack +
                '}';
    }
}
