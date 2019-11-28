package com.epam.examples.observer;

import com.epam.examples.bean.dto.impl.SectionCalcParameters;
import com.epam.examples.service.ServiceException;


public interface Observer {
    void handleEvent(SectionCalcParameters obj) throws ServiceException;
}
