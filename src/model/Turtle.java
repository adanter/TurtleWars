package model;


/**
 * Implements the position and movement of turtle
 */
public class Turtle extends GameObject {
    /**
     * INSTANCE VARIABLES
     */
    int health;
    Weapon weapon;
    double size;
    int color;
    private ObjectVector position = new ObjectVector(0,0);
    private ObjectVector velocity = new ObjectVector(0,0);
    private double direction_facing = 0;
    private double rotateVel = 0;

    public Turtle(ObjectVector position, double size, int color) {
        this.position = position;
        this.size = size;
        this.color = color;
    }

    public void changeVel(int direction){
        ObjectVector nextVel = new ObjectVector(1,0);
        nextVel.setAngle(direction_facing);
        nextVel = nextVel.getUnitVector();
        nextVel.scalarMultiply(direction);
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

    public void interact(GameObject other) {}
    public void shoot(){}
    public ObjectVector getPosition() {return position;}
    public ObjectVector getVelocity() {return velocity;}

}