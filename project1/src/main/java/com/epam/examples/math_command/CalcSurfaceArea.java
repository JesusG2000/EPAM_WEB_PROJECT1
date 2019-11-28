package com.epam.examples.math_command;

import com.epam.examples.bean.Glob;
import com.epam.examples.controller.Command;
import com.epam.examples.service.CalcService;
import com.epam.examples.service.ServiceException;
import com.epam.examples.service.ServiceFactory;

public class CalcSurfaceArea implements Command<Glob> {
    @Override
    public String execute(Glob data) {

        try {
            CalcService calcService = ServiceFactory.getCalcService();
            return calcService.takeSurfaceArea(data) + "";
        } catch (ServiceException e) {
            return e.getMessage();
        }
    }

    @Override
    public Class<Glob> getInputType() {
        return Glob.class;
    }
}
