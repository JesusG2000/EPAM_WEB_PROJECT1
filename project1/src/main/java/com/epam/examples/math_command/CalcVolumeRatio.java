package com.epam.examples.math_command;

import com.epam.examples.dto.SectionCalcParameters;
import com.epam.examples.entity.Dot;
import com.epam.examples.entity.Glob;
import com.epam.examples.controller.Command;
import com.epam.examples.service.CalcService;
import com.epam.examples.service.ServiceException;
import com.epam.examples.service.ServiceFactory;

public class CalcVolumeRatio implements Command<SectionCalcParameters> {


    @Override
    public String execute(SectionCalcParameters data) {
/*        String []info= data.split(" ");
        double x=Double.parseDouble(info[0]);
        double y=Double.parseDouble(info[1]);
        double z=Double.parseDouble(info[2]);
        double radius=Double.parseDouble(info[3]);
        String axis=info[4];
        double x1=Double.parseDouble(info[5]);
        double y1=Double.parseDouble(info[6]);
        double z1=Double.parseDouble(info[7]);*/
        try{
            CalcService calcService = ServiceFactory.getCalcService();
            return String.valueOf(calcService.takeVolumeRatio(data.getGlob(), data.getAxis(), data.getDot()));
        }catch (ServiceException e) {
            return e.getMessage();
        }
    }

    @Override
    public Class<SectionCalcParameters> getInputType() {
        return SectionCalcParameters.class;
    }
}
