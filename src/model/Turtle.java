package model;

/**
 * Implements the position and movement of turtle
 */
public class Turtle {
    /**
     * INSTANCE VARIABLES
     */
    double health;
    Weapon weapon;
    int size;
    int color;
    int player;
    private int[] pos = new int[2];

    public void move() {}
    public void shoot(){}
    public int[] getPos() {
        pos[0] = 0;
        pos[1] = 0;
        return pos;
    }
}