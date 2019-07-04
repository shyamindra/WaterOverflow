package com.plexus.glass;

import com.plexus.exceptions.LiquidOverFlowException;

public interface IGlass {

    boolean isFull();
    void addLiquid(int volume);
    int getRemainingVolume();
    int getFilledVolume();
    int getCapacity();
}
