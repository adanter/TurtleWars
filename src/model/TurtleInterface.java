package model;

interface TurtleInterface {
    void changeVel(int direction);
    void move(double timeStep);
    void shoot();
    int[] getPos();
}