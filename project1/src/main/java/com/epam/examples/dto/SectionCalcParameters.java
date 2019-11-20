package com.epam.examples.dto;

import com.epam.examples.entity.Dot;
import com.epam.examples.entity.Glob;

public class SectionCalcParameters {

  private Glob glob;
  private String axis;
  private Dot dot;


  public SectionCalcParameters(Glob glob, String axis, Dot dot) {
    this.glob = glob;
    this.axis = axis;
    this.dot = dot;
  }


  public Dot getDot() {
    return dot;
  }

  public void setDot(Dot dot) {
    this.dot = dot;
  }

  public String getAxis() {
    return axis;
  }

  public void setAxis(String axis) {
    this.axis = axis;
  }

  public Glob getGlob() {
    return glob;
  }

  public void setGlob(Glob glob) {
    this.glob = glob;
  }
}
