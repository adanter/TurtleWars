package model;


import java.util.ArrayList;

/**
 * Implements the position and movement of turtle
 */
public class Turtle extends GameObject {
    int health;
    private ObjectVector velocity = new ObjectVector(0,0);
    private double direction_facing = 0;
    private double rotateVel = 0;
    private Game game;

    public Turtle(ObjectVector position, double size, Game game) {
        setPosition(position);
        this.size = size;
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
    };

    public void update(double timeStep) {
        velocity.scalarMultiply(timeStep);
        position.addVector(velocity);
        setPosition(position);
        direction_facing += rotateVel;
    }

    public void interact(GameObject other) {
        if (other instanceof Bullet) {
            Bullet bullet = (Bullet) other;
            if (bullet.getParentTurtle() != this) {
                health -= bullet.getDamage();
            }
        }
    }

    public void shoot(){
        ObjectVector vector = new ObjectVector(0,1);
        vector.setAngle(direction_facing);
        vector.getUnitVector();
        game.addObject(new Bullet(position, vector, this));
    }

    public ObjectVector getVelocity() {return velocity;}
    public double getSize() {return size;}
}