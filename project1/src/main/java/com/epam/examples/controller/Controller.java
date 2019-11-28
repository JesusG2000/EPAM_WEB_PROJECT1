package com.epam.examples.controller;

import com.epam.examples.bean.Glob;
import com.epam.examples.dao.DaoException;
import com.epam.examples.dao.DaoFactory;
import com.epam.examples.dao.GlobDao;
import com.epam.examples.dao.SectionCalcParametersDao;
import org.apache.log4j.Logger;

import java.util.List;


public final class Controller {
    private static Logger log = Logger.getLogger(Controller.class);
    private final CommandProvider commandProvider = new CommandProvider();

    public String executeTask(String request) {
        try {
            Command<?> executionCommand = commandProvider.getCommand(request);
            List<?> lines = takeData(executionCommand.getInputType());

            return takeResult(lines, executionCommand);
        } catch (DaoException e) {
            log.error("Dao exception", e);
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

        log.info("take data");
        if (clazz == Glob.class) {
            GlobDao factory = DaoFactory.getGlobDao();
            return factory.getGlobs();
        } else {
            SectionCalcParametersDao factory = DaoFactory.getSectionCalcParametersDao();
            return factory.getSectionCalcParameters();
        }
    }
}
