package com.robot;

/**
 * Our Main Object that moves across the defined boundary. It can move MOVE
 * (forward in facing direction), turn LEFT and RIGHT
 */
public class Robot {
    private Coordinate coordinate;

    // default is 0,0 NORTH
    public Robot() {
        this.coordinate = new Coordinate(0, 0, Bearing.NORTH);
    }

    public Robot(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void moveForward() {
        move(calculateBearing());
    }

    public Coordinate calculateBearing() {
        Integer coordinateX = 0;
        Integer coordinateY = 0;
        Bearing bearing = coordinate.getBearing();

        switch (coordinate.getBearing()) {
            case NORTH:
                coordinateX = coordinate.getCoordinateX();
                coordinateY = coordinate.getCoordinateY() + 1;
                bearing = Bearing.NORTH;
                break;
            case SOUTH:
                coordinateX = coordinate.getCoordinateX();
                coordinateY = coordinate.getCoordinateY() - 1;
                bearing = Bearing.SOUTH;
                break;
            case EAST:
                coordinateX = coordinate.getCoordinateX() + 1;
                coordinateY = coordinate.getCoordinateY();
                bearing = Bearing.EAST;
                break;
            case WEST:
                coordinateX = coordinate.getCoordinateX() - 1;
                coordinateY = coordinate.getCoordinateY();
                bearing = Bearing.WEST;
                break;
        }

        return new Coordinate(coordinateX, coordinateY, bearing);
    }

    public void turnLeft() {
        // our current bearing becomes what ever is on the left hand
        coordinate.setBearing(Bearing.valueOf(coordinate.getBearing().getLeftHand()));
    }

    public void turnRight() {
        // our current bearing becomes what ever is on the right hand
        coordinate.setBearing(Bearing.valueOf(coordinate.getBearing().getRightHand()));
    }

    private void move(Coordinate coordinate) {
        this.coordinate.setCoordinateX(coordinate.getCoordinateX());
        this.coordinate.setCoordinateY(coordinate.getCoordinateY());
        this.coordinate.setBearing(coordinate.getBearing());
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String toString() {
        return "(" + this.coordinate.getCoordinateX() + "," + this.coordinate.getCoordinateY() + ","
                + this.coordinate.getBearing() + ")";
    }

}
