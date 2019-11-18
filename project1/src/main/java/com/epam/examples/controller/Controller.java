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
            List<?> lines = takeData(executionCommand.getInputType());
            return takeResult(lines, executionCommand);
        } catch (DaoException e) {
            return e.getMessage();
        }
    }

    private String takeResult(List<?> dataList, Command executionCommand) {
        StringBuilder result = new StringBuilder();
        for (Object data : dataList) {
            result.append("(").append(executionCommand.execute(data)).append(") ");
        }
        return result.toString();
    }

    private <T> List<T> takeData(Class<T> clazz) throws DaoException {
        FileDataAction fileDataAction = DaoFactory.getFileDataAction();
        return (List<T>) fileDataAction.pickLinesByRule(fileDataAction.takeAllLines("data\\information"), pattern);
    }
}
