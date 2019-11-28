package com.epam.examples.observer.impl;

import com.epam.examples.bean.dto.impl.SectionCalcParameters;
import com.epam.examples.observer.Observer;
import com.epam.examples.service.CalcService;
import com.epam.examples.service.ServiceException;
import com.epam.examples.service.impl.CalcServiceImpl;

public class BeanObserver implements Observer {
    private boolean isAllowableGlob;
    private double capacity;
    private double surfaceArea;
    private double volumeRatio;
    private boolean isTouchSomeAxis;


    @Override
    public void handleEvent(SectionCalcParameters obj) throws ServiceException {
        CalcService calcService = new CalcServiceImpl();

        isAllowableGlob = calcService.isGlob(obj.getGlob());
        capacity = calcService.takeCapacity(obj.getGlob());
        surfaceArea = calcService.takeSurfaceArea(obj.getGlob());
        volumeRatio = calcService.takeVolumeRatio(obj.getGlob(), obj.getAxis(), obj.getDot());
        isTouchSomeAxis = calcService.isTouchSomeAxis(obj.getGlob());

    }


    public boolean isAllowableGlob() {
        return isAllowableGlob;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getVolumeRatio() {
        return volumeRatio;
    }

    public boolean isTouchSomeAxis() {
        return isTouchSomeAxis;
    }
}
