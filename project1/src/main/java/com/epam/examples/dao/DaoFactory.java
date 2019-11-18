package com.epam.examples.dao;


import com.epam.examples.dao.impl.FileDataImpl;

public final class DaoFactory {
    private static FileDataAction fileDataAction = new FileDataImpl();


    private DaoFactory() {
    }

    public static FileDataAction getFileDataAction() {
        return fileDataAction;
    }
}
