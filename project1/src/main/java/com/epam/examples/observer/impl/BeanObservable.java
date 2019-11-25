package com.epam.examples.observer.impl;

import com.epam.examples.bean.dto.SectionCalcParameters;
import com.epam.examples.bean.Dot;
import com.epam.examples.bean.Glob;
import com.epam.examples.observer.Observed;
import com.epam.examples.observer.Observer;
import com.epam.examples.service.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class BeanObservable implements Observed {
  private List<Observer> observers = new ArrayList<>();
  private SectionCalcParameters parameters;


  public void setSectionCalcParameters(SectionCalcParameters calcParameters) throws ServiceException {
    parameters = calcParameters;
    notifyObservers();
  }

  public void setGlob(Glob glob) throws ServiceException {
    parameters.setGlob(glob);
    notifyObservers();
  }

  public void setAxis(String axis) throws ServiceException {
    parameters.setAxis(axis);
    notifyObservers();
  }

  public void setDotForSection(Dot dot) throws ServiceException {
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
  public void notifyObservers() throws ServiceException {
    for (Observer observer : observers) {
      observer.handleEvent(parameters);

    }
  }
}
