package com.epam.examples.controller;

import com.epam.examples.bean.Glob;
import com.epam.examples.dao.ChangeData;
import com.epam.examples.dao.DaoException;
import com.epam.examples.dao.DaoFactory;
import com.epam.examples.dao.impl.Action;
import com.epam.examples.util.log.LogProvider;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Controller {
    private final CommandProvider commandProvider=new CommandProvider();
    private static Logger log =LogProvider.getLOGGER(Controller.class);

    public String executeTask(String request) {
        try {
            Command<?> executionCommand = commandProvider.getCommand(request);
            List<?> lines = takeData(executionCommand.getInputType());

            return takeResult(lines, executionCommand);
        } catch (DaoException e) {
            log.log(Level.WARNING,"Dao exception",e);
            return e.getMessage();
        }
    }


    private String takeResult(List<?> dataList, Command executionCommand) {
        StringBuilder result = new StringBuilder();
        log.info("execute command");
        for (Object data : dataList) {
            result.append("(").append(executionCommand.execute(data)).append(") ");
        }
        return result.toString();
    }

    private <T> List<?> takeData(Class<T> clazz) throws DaoException {
        ChangeData action = DaoFactory.getChangeData();
        log.info("take data");
        if (clazz == Glob.class) {
            return  action.getGlobs();
        } else {
            return  action.getSectionCalcParameters();
        }
    }
}
