package com.epam.examples.math.command;

import com.epam.examples.bean.dto.SectionCalcParameters;
import com.epam.examples.controller.Command;
import com.epam.examples.service.CalcService;
import com.epam.examples.service.ServiceException;
import com.epam.examples.service.ServiceFactory;

public class CalcVolumeRatio implements Command<SectionCalcParameters> {


    @Override
    public String execute(SectionCalcParameters data) {

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
