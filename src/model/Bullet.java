
package model;

/**
 * Bullets are produced by turtles and deal damage if they hit another turtle
 */
public class Bullet extends GameObject{
    private ObjectVector velocity;
    private int damage;
    private Turtle parentTurtle;
    private double distanceTraveled = 0;
    private double range = 100; //TODO: Scale when we know more about coordinates

    public Bullet (ObjectVector position, ObjectVector velocity, Turtle parentTurtle) {
        setPosition(position);
        this.velocity = velocity;
        this.parentTurtle = parentTurtle;
    }

    public void update(double timeStep) {
        velocity.scalarMultiply(timeStep);
        position.addVector(velocity);
        setPosition(position);
        distanceTraveled += velocity.getMagnitude();
        if (distanceTraveled >= range) isDead = true;
    }

    public void interact(GameObject other) {
        if(other instanceof Turtle && other != parentTurtle) {
            if(closeTo(other)) {
                isDead = true;
            }
        }
    }

    public boolean isDead() {
        return isDead;
    }

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
