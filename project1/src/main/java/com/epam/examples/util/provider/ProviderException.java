package com.epam.examples.util.provider;

public class ProviderException extends Exception {
    public ProviderException(){
        super();
    }
    public ProviderException(String message){
        super(message);
    }
    public ProviderException(Exception e){
        super(e);
    }
    public ProviderException(String message , Exception e){
        super(message,e);
    }
}
