package com.epam.examples.util.provider.impl;



import com.epam.examples.util.provider.DataProvider;
import com.epam.examples.util.provider.ProviderException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDataProvider implements DataProvider {

    @Override
    public List<String> getData(String dataHolder) throws ProviderException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(dataHolder)))) {
            String line = reader.readLine();
            while (line != null) {
                if (!line.equals("")) {
                    lines.add(line);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new ProviderException("File is not found", e);
        }
        return lines;
    }


}
