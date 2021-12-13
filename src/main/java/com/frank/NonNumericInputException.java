package com.frank;

// Custom exception class is a subclass of RuntimeException
public class NonNumericInputException extends RuntimeException{
    public NonNumericInputException() {}
    public NonNumericInputException(String aMessage) {
        super(aMessage);
    }
}
