package model;

/**
 * Implements the position and movement of turtle
 */
public class TurtleAcc {
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
    private double rotateVel = 0;

    public void accelerate(int direction){
        // add direction*vector(direction_facing) to velocity
    }
    // direction: -1 = left, 1 = right
    public void turn(int side) {
        rotateVel += side;
    }

    public void move(double timeStep) {
        // some type of friction on velocity and rotateVel
        // pos += velocity;
        // direction_facing += rotateVel
    }
    public void shoot(){
        //creates bullet object with direction and starting position
    }
    public double[] getPos() {return pos;}
    public double[] getVelocity() {return velocity;}
}