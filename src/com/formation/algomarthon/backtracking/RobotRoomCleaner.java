package com.formation.algomarthon.backtracking;

interface Robot {
    // Returns true if next cell is open and robot moves into the cell.
    // Returns false if next cell is obstacle and robot stays on the current cell.
    boolean move();

    // Robot will stay on the same cell after calling turnLeft/turnRight
    // Each turn will be 90 degrees.

    void turnLeft();

    void turnRight();

    // clean the current cell

    void clean();
}
public class RobotRoomCleaner {
}
