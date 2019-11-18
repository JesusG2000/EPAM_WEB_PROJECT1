package com.epam.examples.dto;

import com.epam.examples.entity.Dot;
import com.epam.examples.entity.Glob;

public class SectionCalcParameters {

  private Dot dot;
  private String axis;
  private Glob glob;

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
