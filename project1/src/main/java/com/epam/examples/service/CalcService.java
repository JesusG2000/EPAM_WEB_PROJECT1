package com.epam.examples.service;

import com.epam.examples.bean.Dot;
import com.epam.examples.bean.Glob;

public interface CalcService {

    double takeSurfaceArea(Glob glob) throws ServiceException;

    double takeCapacity(Glob glob) throws ServiceException;

    boolean isGlob(Glob glob) throws ServiceException;

    double takeVolumeRatio(Glob glob, String axis, Dot first) throws ServiceException;

    boolean isTouchSomeAxis(Glob glob) throws ServiceException;
}
