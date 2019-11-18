package com.epam.examples.controller;

import com.epam.examples.dao.DaoException;
import com.epam.examples.dao.DaoFactory;
import com.epam.examples.dao.FileDataAction;
import com.epam.examples.dao.FileParser;

import java.util.List;
import java.util.regex.Pattern;

public final class Controller {
    private final CommandProvider commandProvider = new CommandProvider();

    public String executeTask(String request) {
        try {
            Command executionCommand = commandProvider.getCommand(request);
            List<String> lines = takeData(commandProvider.getParam(request));
            return takeResult(lines, executionCommand);
        } catch (DaoException e) {
            return e.getMessage();
        }
    }

    private String takeResult(List<String> lines, Command executionCommand) {
        StringBuilder result = new StringBuilder();
        for (String line : lines) {
            result.append("(").append(executionCommand.execute(line)).append(") ");
        }
        return result.toString();
    }

    private List<String> takeData(Pattern pattern) throws DaoException {
        FileDataAction fileDataAction = DaoFactory.getFileDataAction();
        return fileDataAction.pickLinesByRule(fileDataAction.takeAllLines("data\\information"), pattern);
    }
}
