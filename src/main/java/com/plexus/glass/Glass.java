package com.plexus.glass;

public class Glass implements IGlass {

    private int volume;
    private int capacity;

    public boolean isFull() {
        return capacity == volume ;
    }

    public int getVolume() {
        return volume;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addLiquid(int liquid){
        this.volume = this.volume + liquid > capacity ? capacity : this.volume + liquid;
    }
}
