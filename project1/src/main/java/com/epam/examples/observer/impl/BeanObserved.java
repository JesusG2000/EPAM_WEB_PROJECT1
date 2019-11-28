package com.epam.examples.observer.impl;

import com.epam.examples.bean.Dot;
import com.epam.examples.bean.Glob;
import com.epam.examples.bean.dto.ISectionCalcParameters;
import com.epam.examples.bean.dto.impl.SectionCalcParameters;
import com.epam.examples.observer.Observable;
import com.epam.examples.observer.Observer;
import com.epam.examples.service.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class BeanObserved implements Observable, ISectionCalcParameters {
    private List<Observer> observers = new ArrayList<>();
    private SectionCalcParameters parameters;


    public void setSectionCalcParameters(SectionCalcParameters calcParameters) {
        parameters = calcParameters;
        notifyObservers();
    }

    public void setGlob(Glob glob) {
        parameters.setGlob(glob);
        notifyObservers();
    }

    public void setAxis(String axis) {
        parameters.setAxis(axis);
        notifyObservers();
    }

    public void setDot(Dot dot) {
        parameters.setDot(dot);
        notifyObservers();
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        try {

            for (Observer observer : observers) {
                observer.handleEvent(parameters);
            }

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
