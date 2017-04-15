
package model;

/**
 * Created by Adante on 4/14/2017.
 */
public class Bullet {
    private ObjectVector vector;
    private double xPosition;
    private double yPosition;
    private double size;
    private int damage;
    private Turtle parentTurtle;
    private double distanceTraveled = 0;
    private double range = 100; //TODO: Scale when we know more about coordinates

    public Bullet (ObjectVector position, ObjectVector vector) {
        this.vector = vector;
        this.xPosition = position.getX();
        this.yPosition = position.getY();
    }

    public void update(double timeStep) {
        velocity.scalarMultiply(timeStep);
        position.addVector(velocity);
        setPosition(position);
        distanceTraveled += velocity.getMagnitude();
        if (distanceTraveled >= range) isDead = true;
    public double getxPosition() {
        return xPosition;
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
    public double getyPosition() {
        return yPosition;
    }

    public double getSize() {
        return size;
    }

    public void update() {
        xPosition += vector.getX();
        yPosition += vector.getY();
    }
}
