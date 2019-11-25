package com.epam.examples.util.provider;



import java.util.List;
import java.util.regex.Pattern;

public interface DataProvider{

  List<String> getData(String dataHolder) throws ProviderException;

}
