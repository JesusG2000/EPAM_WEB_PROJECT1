package com.epam.examples.math_operation;

public class MathException extends Exception {
    public MathException(){
        super();
    }
    public MathException(String message){
        super(message);
    }
    public MathException(Exception e){
        super(e);
    }
    public MathException(String message , Exception e){
        super(message,e);
    }
}
