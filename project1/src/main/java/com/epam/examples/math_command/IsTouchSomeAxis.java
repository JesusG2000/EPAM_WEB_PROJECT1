package com.epam.examples.math_command;

import com.epam.examples.entity.Dot;
import com.epam.examples.entity.Glob;
import com.epam.examples.controller.Command;
import com.epam.examples.service.CalcService;
import com.epam.examples.service.ServiceException;
import com.epam.examples.service.ServiceFactory;

public class IsTouchSomeAxis implements Command {
    @Override
    public String execute(String data) {
        String []info= data.split(" ");
        double x=Double.parseDouble(info[0]);
        double y=Double.parseDouble(info[1]);
        double z=Double.parseDouble(info[2]);
        double radius=Double.parseDouble(info[3]);
        try{
            CalcService calcService = ServiceFactory.getCalcService();
            return calcService.isTouchSomeAxis(new Glob(new Dot(x,y,z),radius))+"";
        }catch (ServiceException e) {
            return e.getMessage();
        }
    }
}
