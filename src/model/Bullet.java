
package model;

/**
 * Created by Adante on 4/14/2017.
 */
public class Bullet {
    private ObjectVector velocity;
    private ObjectVector position;
    private int damage;

    public Bullet (ObjectVector position, ObjectVector velocity) {
        this.velocity = velocity;
        this.position = position;
    }

    public ObjectVector getPosition() {
        return position;
    }

    public ObjectVector getVelocity() {
        return velocity;
    }

    public void update() {
        position.addVector(velocity);
    }
}
