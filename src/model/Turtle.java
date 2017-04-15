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
    private double[] pos = new double[2];
    private double[] velocity = new double[2];
    private double direction_facing;
    private double rotate_vel = 0;

    public void changeVel(int direction){
        // set velocity to vector(direction_facing) times direction
    }
    // side: -1 = left, 1 = right
    public void turn(int side) {
        rotate_vel = side;
    }

    public void move(double timeStep) {
        //pos += velocity;
        //direction_facing += rotate_vel
    }
    public void shoot(){}
    public double[] getPos() {return pos;}
    public double[] getVelocity() {return velocity;}
}