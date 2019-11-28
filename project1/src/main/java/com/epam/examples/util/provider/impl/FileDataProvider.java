package com.epam.examples.util.provider.impl;


import com.epam.examples.util.provider.DataProvider;
import com.epam.examples.util.provider.ProviderException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataProvider implements DataProvider<List<String>> {
    private String dataHolder;

    public FileDataProvider(String dataHolder) {
        this.dataHolder = dataHolder;
    }

    @Override
    public List<String> getData() throws ProviderException {
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
