
package model;

/**
 * Created by Adante on 4/14/2017.
 */
public class Bullet {
    private ObjectVector vector;
    private double xPosition;
    private double yPosition;
    private int damage;

    public Bullet (double x, double y, ObjectVector vector) {
        this.vector = vector;
        this.xPosition = x;
        this.yPosition = y;
    }

    public double getxPosition() {
        return xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public void update() {
        xPosition += vector.getx();
        yPosition += vector.getY();
    }
}
