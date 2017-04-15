
package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableDoubleValue;

/**
 * Bullets are produced by turtles and deal damage if they hit another turtle
 */
public class Bullet extends GameObject{
    private ObjectVector velocity;
    private int damage;
    private Turtle parentTurtle;

    public Bullet (ObjectVector position, ObjectVector velocity, Turtle parentTurtle) {
        setPosition(position);
        this.velocity = velocity;
        this.parentTurtle = parentTurtle;
    }

    public void update(double timeStep) {
        velocity.scalarMultiply(timeStep);
        position.addVector(velocity);
        setPosition(position);
    }

    public void interact(GameObject other) {}


    public ObjectVector getVelocity() {
        return velocity;
    }

    public Turtle getParentTurtle() {
        return parentTurtle;
    }

    public int getDamage() {
        return damage;
    }
}
