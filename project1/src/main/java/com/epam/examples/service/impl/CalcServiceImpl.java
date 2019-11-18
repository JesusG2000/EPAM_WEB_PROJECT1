package com.epam.examples.service.impl;

import com.epam.examples.bean.Dot;
import com.epam.examples.bean.Glob;
import com.epam.examples.math_operation.MathException;
import com.epam.examples.math_operation.MathFactory;
import com.epam.examples.math_operation.Operation;
import com.epam.examples.service.CalcService;
import com.epam.examples.service.ServiceException;

public class CalcServiceImpl implements CalcService {
    @Override
    public double takeSurfaceArea(Glob glob) throws ServiceException {
        try {
            Operation operation = MathFactory.getOperation();
            return operation.takeSurfaceArea(glob);
        } catch (MathException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public double takeCapacity(Glob glob) throws ServiceException {

        try {
            Operation operation = MathFactory.getOperation();
            return operation.takeCapacity(glob);
        } catch (MathException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean isGlob(Glob glob) throws ServiceException {

        try {
            Operation operation = MathFactory.getOperation();
            return operation.isGlob(glob);
        } catch (MathException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public double takeVolumeRatio(Glob glob, String axis, Dot first) throws ServiceException {

        try {
            Operation operation = MathFactory.getOperation();
            return operation.takeVolumeRatio(glob, axis, first);
        } catch (MathException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean isTouchSomeAxis(Glob glob) throws ServiceException {

        try {
            Operation operation = MathFactory.getOperation();
            return operation.isTouchSomeAxis(glob);
        } catch (MathException e) {
            throw new ServiceException(e);
        }
    }
}
