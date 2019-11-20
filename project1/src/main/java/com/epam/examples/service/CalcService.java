package com.epam.examples.service;

import com.epam.examples.entity.Dot;
import com.epam.examples.entity.Glob;

public interface CalcService {

    double takeSurfaceArea(Glob glob) throws ServiceException;

    double takeCapacity(Glob glob) throws ServiceException;

    boolean isGlob(Glob glob) throws ServiceException;

    double takeVolumeRatio(Glob glob, String axis, Dot first) throws ServiceException;

    boolean isTouchSomeAxis(Glob glob) throws ServiceException;
}
