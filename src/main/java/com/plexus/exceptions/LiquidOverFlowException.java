package com.plexus.exceptions;

public class LiquidOverFlowException extends RuntimeException {

    private static final String message = "Glass(es) full, liquid will overflow";
    public LiquidOverFlowException(){
        super(message);
    }
}
