
package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableDoubleValue;

/**
 * Bullets are produced by turtles and deal damage if they hit another turtle
 */
public class Bullet extends GameObject{
    private ObjectVector velocity;
    private int damage;

    public Bullet (ObjectVector position, ObjectVector velocity) {
        setPosition(position);
        this.velocity = velocity;
    }

    public void update(double timeStep) {
        velocity.scalarMultiply(timeStep);
        position.addVector(velocity);
        setPosition(position);
    }

    public void interact(GameObject other) {}
}
