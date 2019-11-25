package com.epam.examples.util.log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

public  class LogProvider {

    public static Logger getLOGGER(Class aClass) {
        try (FileInputStream ins = new FileInputStream("logs\\log.property")) {
            java.util.logging.LogManager.getLogManager().readConfiguration(ins);
            return Logger.getLogger(aClass.getName());
        } catch (IOException exp) {
            exp.printStackTrace();
            return null;
        }
    }
}



