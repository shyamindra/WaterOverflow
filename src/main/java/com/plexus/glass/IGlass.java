package com.plexus.glass;

public interface IGlass {

    boolean isFull();
    void addLiquid(int volume);
    int getVolume();
    int getCapacity();
}
