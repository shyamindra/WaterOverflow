package com.plexus.exceptions;

public class LiquidOverFlowException extends RuntimeException {

    private static final String message = "Glass is full, liquid will overflow into lower glass";
    public LiquidOverFlowException(){
        super(message);
    }
}
