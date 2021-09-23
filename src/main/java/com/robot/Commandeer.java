package com.robot;

/**
 * Defines the main Commandeering class used to initiate commands to the Robot
 * object.
 */
public class Commandeer {

    private static final String ROBOT_SYMBOL = "O--O";

    private Robot robot = null;

    private final Boundary boundary;

    public Commandeer(int x, int y) {
        this.boundary = new Boundary(x, y);
    }

    private void initialize(Integer x, Integer y, Bearing bearing) {
        robot = new Robot(new Coordinate(x, y, bearing));
    }

    public void executeCommand(String command, String... args) {
        // execute the actual command:
        switch (Command.valueOf(command.toUpperCase())) {
            case PLACE:
                // here we can receive additional arguments as well:
                if (args != null && args.length == 3) {
                    // if we are not within bounds we show error:
                    if (!isWithinBounds(new Coordinate(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
                            Bearing.valueOf(args[2].toUpperCase())))) {
                        System.out.println("Given coordinates are out of bounds ...");
                        return;
                    }
                    initialize(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
                            Bearing.valueOf(args[2].toUpperCase()));
                    return;
                }
                // without any args (or invalid args ... place it on the DEFAULT (0,0) starting point - facing north)
                initialize(0, 0, Bearing.NORTH);
                break;
            case MOVE:
                // ignore commands until robot not "placed" within the bounds
                if (!isRobotPlaced()) {
                    System.out.println("Robot not placed yet, command ignored");
                    return;
                }

                // if we are not within bounds we show error:
                if (!isWithinBounds(robot.calculateBearing())) {
                    System.out.println("Given coordinates are out of bounds ...");
                    return;
                }
                robot.moveForward();
                break;
            case LEFT:
                // ignore commands until robot not "placed" within the bounds
                if (!isRobotPlaced()) {
                    System.out.println("Robot not placed yet, command ignored");
                    return;
                }
                robot.turnLeft();
                break;
            case RIGHT:
                // ignore commands until robot not "placed" within the bounds
                if (!isRobotPlaced()) {
                    System.out.println("Robot not placed yet, command ignored");
                    return;
                }
                robot.turnRight();
                break;
            case REPORT:
                // ignore commands until robot not "placed" within the bounds
                if (!isRobotPlaced()) {
                    System.out.println("Robot not placed yet, command ignored");
                    return;
                }
                System.out.println(getCurrentCoordinate());
                break;
        }
    }

    private boolean isWithinBounds(Coordinate coordinate) {
        // return false if any coordinate is less than 0
        if (coordinate.getCoordinateX() < 0 || coordinate.getCoordinateY() < 0) {
            return false;
        }
        // we are within bounds if this passes
        return coordinate.getCoordinateX() <= boundary.getxBound()
                && coordinate.getCoordinateY() <= boundary.getyBound();
    }

    public Coordinate getCurrentCoordinate() {
        return isRobotPlaced() ? robot.getCoordinate() : null;
    }

    public boolean isRobotPlaced() {
        return robot != null;
    }

    /**
     * Optionally added method for pretty printing to a grid to see the robot
     * move
     */
    public void printGrid() {
        // we actually start printing the grid at 0,5 so we adjust offsets:
        int yOffset = this.boundary.getyBound();

        // we are on a XxY grid:
        // initialize the boundary data:
        for (int y = 0; y <= this.boundary.getyBound(); y++) {
            for (int x = 0; x <= this.boundary.getxBound(); x++) {
                // if on the same Coordinate as the robot, print the robot
                // instead of the usual
                Coordinate currentCoordindate = new Coordinate(x, yOffset - y, robot.getCoordinate().getBearing());
                if (currentCoordindate.equals(robot.getCoordinate())) {
                    System.out.print(ROBOT_SYMBOL);
                } else {
                    System.out.print("*");
                }
                System.out.print("\t");

            }
            System.out.println(); // new line feed after each increment
            System.out.println(); // new line feed after each increment
            System.out.println(); // new line feed after each increment
        }
        System.out.println(robot);
    }

}
