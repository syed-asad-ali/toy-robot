# Toy Robot

A simple Java application to process actions of a toy robot on a given grid system

`mvn package`

+ The package goal will compile your Java code, run any tests, and finish by packaging the code up in a JAR file within
  the target directory. The JAR file will be named `toy-robot-1.0-SNAPSHOT-shaded.jar`.

Run project
---

+ To run this project run the following command:
  + `java -cp target/toy-robot-1.0-SNAPSHOT-shaded.jar com.robot.Runner`
+ Note: Make sure you have java runtime version 11+ installed


+ Available commands (not case sensitive):
  + `PLACE` - Places the robot on a 5x5 Grid system with coordinates `(0,0,NORTH)`. If the different facing is required, then use the overloaded command `PLACE X,Y,F`
  + `MOVE` - Moves the robot in the Facing direction. Will be ignore if the result causes the robot to be out of bounds of the grid
  + `LEFT` - Turns the robot 90 degrees left
  + `RIGHT` - Turns the robot 90 degrees right
  + `REPORT` - Reports the current coordinates in the form `(X,Y,F)` i.e. `(0,0,NORTH)`, `(1,2,EAST)` etc.

### Assumptions
+ The grid sized is fixed to 5x5 for the execution but can be changed (within the code only) There are no means to alter it using any commands available
+ All commands are ignored until the `PLACE` command is executed
+ `PLACE` command should be used with or without arguments. If used with arguments then ALL three arguments MUST BE given else the DEFAULT (0,0,NORTH) is executed