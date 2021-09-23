package com.robot;

/**
 * Defines the bounds in which our robot will move
 */
public class Boundary {

    private Integer xBound;

    private Integer yBound;

    public Boundary(Integer xBound, Integer yBound) {
        this.xBound = xBound;
        this.yBound = yBound;
    }

    public Integer getxBound() {
        return xBound;
    }

    public void setxBound(Integer xBound) {
        this.xBound = xBound;
    }

    public Integer getyBound() {
        return yBound;
    }

    public void setyBound(Integer yBound) {
        this.yBound = yBound;
    }

    public String toString() {
        return "(" + xBound + "," + yBound + ")";
    }

}
