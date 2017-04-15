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
    private ObjectVector position = new ObjectVector(0,0);
    private ObjectVector velocity = new ObjectVector(0,0);
    private double direction_facing;
    private double rotateVel = 0;

    public void changeVel(int direction){
        ObjectVector nextVel = new ObjectVector(0,0);
        nextVel.setAngle(direction_facing);
        nextVel = nextVel.getUnitVector();
        nextVel.scalarMultiply(direction_facing);
        velocity = nextVel;
    }
    // side: -1 = left, 1 = right
    public void turn(int side) {
        rotateVel = side*0.1;
    }

    public void update(double timeStep) {
        velocity.scalarMultiply(timeStep);
        position.addVector(velocity);
        ObjectVector angleVector = new ObjectVector(0,0);
        direction_facing += rotateVel;
    }
    public void shoot(){}
    public ObjectVector getPosition() {return position;}
    public ObjectVector getVelocity() {return velocity;}

}