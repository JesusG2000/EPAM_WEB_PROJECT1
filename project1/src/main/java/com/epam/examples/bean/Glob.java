package com.epam.examples.bean;

import java.util.Objects;


public class Glob {
    private Dot dot;
    private double radius;

    public Glob(Dot dot, double radius) {
        this.dot = dot;
        this.radius = radius;
    }


    public Dot getDot() {
        return dot;
    }


    public void setDot(Dot dot) {
        this.dot = dot;
    }


    public double getRadius() {
        return radius;
    }


    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Glob glob = (Glob) o;
        return Double.compare(glob.radius, radius) == 0 &&
                Objects.equals(dot, glob.dot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dot, radius);
    }

    @Override
    public String toString() {
        return "Glob{" +
                "dot=" + dot +
                ", radius=" + radius +
                '}';
    }
}
