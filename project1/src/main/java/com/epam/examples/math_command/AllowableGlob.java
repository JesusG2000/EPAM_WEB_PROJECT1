package com.epam.examples.math_command;

import com.epam.examples.controller.Command;
import com.epam.examples.entity.Dot;
import com.epam.examples.entity.Glob;
import com.epam.examples.service.CalcService;
import com.epam.examples.service.ServiceException;
import com.epam.examples.service.ServiceFactory;

public class AllowableGlob implements Command<Glob> {
    @Override
    public String execute(Glob data) {
/*        String []info= data.split(" ");
        double x=Double.parseDouble(info[0]);
        double y=Double.parseDouble(info[1]);
        double z=Double.parseDouble(info[2]);
        double radius=Double.parseDouble(info[3]);*/
        try {
            CalcService calcService = ServiceFactory.getCalcService();
            return calcService.isGlob(data) + "";
        } catch (ServiceException e) {
            return e.getMessage();
        }

    }

    @Override
    public Class<Glob> getInputType() {
        return Glob.class;
    }
}