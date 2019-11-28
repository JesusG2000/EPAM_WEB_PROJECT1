package com.epam.examples.bean.dto;

import com.epam.examples.bean.Dot;
import com.epam.examples.bean.Glob;
import com.epam.examples.service.ServiceException;

public interface ISectionCalcParameters {


    void setDot(Dot dot);


    void setAxis(String axis) throws ServiceException;


    void setGlob(Glob glob);
}
