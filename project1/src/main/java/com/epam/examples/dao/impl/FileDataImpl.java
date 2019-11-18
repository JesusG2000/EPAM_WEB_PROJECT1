package com.epam.examples.dao.impl;

import com.epam.examples.dao.DaoException;
import com.epam.examples.dao.FileDataAction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileDataImpl implements FileDataAction {

    @Override
    public List<String> pickLinesByRule(List<String> lines,Pattern pattern) throws DaoException {
        List<String> formatList =new ArrayList<>();
        for (String l : lines) {
            Matcher matcher = pattern.matcher(l);
            while (matcher.find()) {
               // System.out.println(l + "  " + l .length());
                formatList.add(l);
            }
        }
        return formatList;
    }

    @Override
    public List<String> takeAllLines(String fileWay) throws DaoException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileWay)))) {
            String line = reader.readLine();
            while (line != null) {
                if(!line.equals("")) {
                    lines.add(line);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new DaoException("File is not found", e);
        }
        return lines;
    }
}
