package com.plexus.glass;

import com.plexus.exceptions.LiquidOverFlowException;

public class Glass implements IGlass {

    private final int capacity;
    private int remainingVolume;

    public Glass(final int capacity){
        this.capacity = capacity;
        this.remainingVolume = capacity;
    }

    public boolean isFull() {
        return remainingVolume == 0 ;
    }

    public int getRemainingVolume() {
        return this.remainingVolume;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addLiquid(int liquid){
        if (this.remainingVolume >= liquid ){
            this.remainingVolume -=  liquid;
        } else {
            throw new LiquidOverFlowException();
        }
    }
}
