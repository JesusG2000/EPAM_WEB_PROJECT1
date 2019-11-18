package com.epam.examples.service;

import com.epam.examples.service.impl.CalcServiceImpl;

public final class ServiceFactory {
    private static final CalcService calcService = new CalcServiceImpl();

    private ServiceFactory(){}

    public static CalcService getCalcService() {
        return calcService;
    }
}
