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
    private double velocity = 0;
    private double rotate_vel = 0;

    public void accelerate(int direction){
        velocity += direction;
    }
    // direction: -1 = left, 1 = right
    public void turn(int direction) {
        rotate_vel += direction;
    }
    public void shoot(){}
    public int[] getPos() {return pos;}
    public double getVelocity() {return velocity;}
}