package com.robot;

import static com.robot.Bearing.NORTH;

/**
 * Defines the active coordinates on the movement grid. The X-axis, Y-axis and
 * the current direction (bearing) is kept for a given Coordinate object.
 */
public class Coordinate {

    private Integer coordinateX = 0; // defaulted to X=0

    private Integer coordinateY = 0; // defaulted to Y=0

    private Bearing bearing = NORTH; // defaulted to NORTH

    public Coordinate(Integer coordinateX, Integer coordinateY, Bearing bearing) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.bearing = bearing;
    }

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Bearing getBearing() {
        return bearing;
    }

    public void setBearing(Bearing bearing) {
        this.bearing = bearing;
    }

    public boolean equals(Object object) {
        if (object instanceof Coordinate) {
            return coordinateX.equals(((Coordinate) object).getCoordinateX()) //
                    && coordinateY.equals(((Coordinate) object).getCoordinateY()) //
                    && bearing.name().equalsIgnoreCase(((Coordinate) object).getBearing().name());
        }
        return false;
    }

    public String toString() {
        return "(" + coordinateX + "," + coordinateY + "," + bearing.name() + ")";
    }

}
