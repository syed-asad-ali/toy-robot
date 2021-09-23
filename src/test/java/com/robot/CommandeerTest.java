package com.robot;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.robot.Bearing.*;
import static org.junit.jupiter.api.Assertions.*;


public class CommandeerTest {
    private static final Integer MAX_X_GRID = 5;

    private static final Integer MAX_Y_GRID = 5;

    private Commandeer commandeer = null;


    @BeforeEach
    public void setup() {
        commandeer = new Commandeer(MAX_X_GRID, MAX_Y_GRID);
    }

    @Test
    @DisplayName("Ignore commands until robot is placed")
    public void shouldIgnoreCommands_untilRobotPlaced() {
        commandeer.executeCommand("REPORT");
        assertNull(commandeer.getCurrentCoordinate());
        assertFalse(commandeer.isRobotPlaced());

        commandeer.executeCommand("MOVE");
        assertNull(commandeer.getCurrentCoordinate());
        assertFalse(commandeer.isRobotPlaced());

        commandeer.executeCommand("LEFT");
        assertNull(commandeer.getCurrentCoordinate());
        assertFalse(commandeer.isRobotPlaced());

        commandeer.executeCommand("RIGHT");
        assertNull(commandeer.getCurrentCoordinate());
        assertFalse(commandeer.isRobotPlaced());
    }

    @Test
    @DisplayName("Execute commands when robot is valid commands")
    public void shouldExecuteCommands_whenRobotValidCommandsGiven() {
        commandeer.executeCommand("PLACE");
        assertNotNull(commandeer.getCurrentCoordinate());
        assertEquals(0, commandeer.getCurrentCoordinate().getCoordinateX());
        assertEquals(0, commandeer.getCurrentCoordinate().getCoordinateY());
        assertEquals(NORTH, commandeer.getCurrentCoordinate().getBearing());
        assertTrue(commandeer.isRobotPlaced());

        commandeer.executeCommand("REPORT");
        assertNotNull(commandeer.getCurrentCoordinate());
        assertEquals(0, commandeer.getCurrentCoordinate().getCoordinateX());
        assertEquals(0, commandeer.getCurrentCoordinate().getCoordinateY());
        assertEquals(NORTH, commandeer.getCurrentCoordinate().getBearing());
        assertTrue(commandeer.isRobotPlaced());

        commandeer.executeCommand("PLACE", "1", "1", "EAST");
        assertNotNull(commandeer.getCurrentCoordinate());
        assertEquals(1, commandeer.getCurrentCoordinate().getCoordinateX());
        assertEquals(1, commandeer.getCurrentCoordinate().getCoordinateY());
        assertEquals(EAST, commandeer.getCurrentCoordinate().getBearing());
        assertTrue(commandeer.isRobotPlaced());
        commandeer.executeCommand("REPORT");


        commandeer.executeCommand("MOVE");
        assertNotNull(commandeer.getCurrentCoordinate());
        assertEquals(2, commandeer.getCurrentCoordinate().getCoordinateX());
        assertEquals(1, commandeer.getCurrentCoordinate().getCoordinateY());
        assertEquals(EAST, commandeer.getCurrentCoordinate().getBearing());
        assertTrue(commandeer.isRobotPlaced());
        commandeer.executeCommand("REPORT");

        commandeer.executeCommand("LEFT");
        assertNotNull(commandeer.getCurrentCoordinate());
        assertEquals(2, commandeer.getCurrentCoordinate().getCoordinateX());
        assertEquals(1, commandeer.getCurrentCoordinate().getCoordinateY());
        assertEquals(NORTH, commandeer.getCurrentCoordinate().getBearing());
        assertTrue(commandeer.isRobotPlaced());
        commandeer.executeCommand("REPORT");
    }

    @Test
    @DisplayName("Ignore commands when MOVE will cause robot to be out of bounds")
    public void shouldIgnoreCommands_whenMoveCausesOutOfBounds() {
        commandeer.executeCommand("PLACE", "0", "0", "WEST");
        commandeer.executeCommand("MOVE");
        assertEquals(0, commandeer.getCurrentCoordinate().getCoordinateX());
        assertEquals(0, commandeer.getCurrentCoordinate().getCoordinateY());
        assertEquals(WEST, commandeer.getCurrentCoordinate().getBearing());
        commandeer.executeCommand("REPORT");

        commandeer.executeCommand("PLACE", "5", "5", "NORTH");
        commandeer.executeCommand("MOVE");
        assertEquals(5, commandeer.getCurrentCoordinate().getCoordinateX());
        assertEquals(5, commandeer.getCurrentCoordinate().getCoordinateY());
        assertEquals(NORTH, commandeer.getCurrentCoordinate().getBearing());
        commandeer.executeCommand("REPORT");

    }
}
