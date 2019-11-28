package com.epam.examples.util.provider;


public interface DataProvider<T> {

    T getData() throws ProviderException;

}
