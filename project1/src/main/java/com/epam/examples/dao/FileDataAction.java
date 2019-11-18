package com.epam.examples.dao;

import java.util.List;
import java.util.regex.Pattern;

public interface FileDataAction {
    List<String> pickLinesByRule(List<String> lines, Pattern pattern) throws DaoException;

    List<String> takeAllLines(String fileWay) throws DaoException;
}
