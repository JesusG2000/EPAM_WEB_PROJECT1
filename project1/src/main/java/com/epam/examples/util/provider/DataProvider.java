package com.epam.examples.util.provider;

public interface DataProvider<R,T> {

  R getData(T dataHolder);
}
