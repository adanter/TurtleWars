
package model;

/**
 * Created by Adante on 4/14/2017.
 */
public class Bullet {
    private ObjectVector velocity;
    private ObjectVector position;
    private double size;
    private int damage;
    private Turtle parentTurtle;

    public Bullet (ObjectVector position, ObjectVector velocity, Turtle parentTurtle) {
        this.velocity = velocity;
        this.position = position;
        this.parentTurtle = parentTurtle;
        this.size = 3; //TODO: Scale bullet size when we have an idea of what coordinates are like
    }

    public ObjectVector getPosition() {
        return position;
    }

    public ObjectVector getVelocity() {
        return velocity;
    }

    public double getSize() {
        return size;
    }

    public void update(double timestep) {
        velocity.scalarMultiply(timestep);
        position.addVector(velocity);
    }

    public Turtle getParentTurtle() {
        return parentTurtle;
    }

    public int getDamage() {
        return damage;
    }
}
