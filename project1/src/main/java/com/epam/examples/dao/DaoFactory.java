package com.epam.examples.dao;

import com.epam.examples.dao.impl.GlobDaoImpl;
import com.epam.examples.dao.impl.SectionCalcParametersDaoImpl;

public final class DaoFactory {
    private static final GlobDao globDao = new GlobDaoImpl();
    private static final SectionCalcParametersDao sectionCalcParametersDao = new SectionCalcParametersDaoImpl();

    private DaoFactory() {
    }

    public static GlobDao getGlobDao() {
        return globDao;
    }

    public static SectionCalcParametersDao getSectionCalcParametersDao() {
        return sectionCalcParametersDao;
    }
}
