
package model;

/**
 * Created by Adante on 4/14/2017.
 */
public class Bullet {
    private ObjectVector velocity;
    private ObjectVector position;
    private double size;
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

    public double getSize() {
        return size;
    }

    public void update() {
        position.addVector(velocity);
    }
}
