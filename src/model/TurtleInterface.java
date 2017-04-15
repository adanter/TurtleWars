package model;

interface TurtleInterface {
    void accelerate(int direction);
    void turn(int direction);
    void shoot();
    int[] getPos();
}