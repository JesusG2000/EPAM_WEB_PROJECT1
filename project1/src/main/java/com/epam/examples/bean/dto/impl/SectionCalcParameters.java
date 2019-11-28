package com.epam.examples.bean.dto.impl;

import com.epam.examples.bean.Dot;
import com.epam.examples.bean.Glob;
import com.epam.examples.bean.dto.ISectionCalcParameters;

import java.util.Objects;

public class SectionCalcParameters implements ISectionCalcParameters {
    private Glob glob;
    private String axis;
    private Dot dot;


    public SectionCalcParameters(Glob glob, String axis, Dot dot) {
        this.glob = glob;
        this.axis = axis;
        this.dot = dot;
    }

    public SectionCalcParameters() {
    }


    public Dot getDot() {
        return dot;
    }

    @Override
    public void setDot(Dot dot) {
        this.dot = dot;
    }


    public String getAxis() {
        return axis;
    }

    @Override
    public void setAxis(String axis) {
        this.axis = axis;
    }


    public Glob getGlob() {
        return glob;
    }

    @Override
    public void setGlob(Glob glob) {
        this.glob = glob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionCalcParameters that = (SectionCalcParameters) o;
        return Objects.equals(glob, that.glob) &&
                Objects.equals(axis, that.axis) &&
                Objects.equals(dot, that.dot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(glob, axis, dot);
    }

    @Override
    public String toString() {
        return "SectionCalcParameters{" +
                "glob=" + glob +
                ", axis='" + axis + '\'' +
                ", dot=" + dot +
                '}';
    }
}
