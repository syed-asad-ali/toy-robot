package com.robot;

/**
 * Defines which direction the Robot is facing. Additionally we keep the left and
 * right bearing for each direction for easier traversal.
 */
public enum Bearing {

    NORTH("WEST", "EAST"),
    SOUTH("EAST", "WEST"),
    EAST("NORTH", "SOUTH"),
    WEST("SOUTH", "NORTH");

    private final String leftHand;

    private final String rightHand;

    Bearing(String leftHand, String rightHand) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
    }

    public String getLeftHand() {
        return leftHand;
    }

    public String getRightHand() {
        return rightHand;
    }
}
