
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

    public Bullet (ObjectVector position, ObjectVector vector) {
        this.vector = vector;
        this.xPosition = position.getx();
        this.yPosition = position.getY();
    }

    public double getxPosition() {
        return xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public double getSize() {
        return size;
    }

    public void update() {
        xPosition += vector.getx();
        yPosition += vector.getY();
    }
}
