package com.epam.examples.controller;
import com.epam.examples.entity.Glob;
import com.epam.examples.math_command.AllowableGlob;
import com.epam.examples.util.parser.DataParser;
import com.epam.examples.util.parser.DataParserFactory;
import com.epam.examples.util.parser.ParserException;
import com.epam.examples.util.provider.DataProvider;
import com.epam.examples.util.provider.DataProviderFactory;
import com.epam.examples.util.provider.ProviderException;

import java.util.List;
import java.util.regex.Pattern;

public final class Controller {
    private final CommandProvider commandProvider = new CommandProvider();

    public String executeTask(String request) {
        try {

            Command<?> executionCommand = commandProvider.getCommand(request);

            List<?> lines = takeData(executionCommand.getInputType());
            return takeResult(lines, executionCommand);
        } catch (ProviderException | ParserException e) {
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


    private <T> List<T> takeData(Class<T> clazz) throws ProviderException, ParserException {
        DataParser parser = DataParserFactory.getDataParser();
        if (clazz == Glob.class) {
            return (List<T>) parser.getGlobes();

        } else {
            return (List<T>) parser.getSectionParams();
        }


    }
}
