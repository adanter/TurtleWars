package model;

/**
 * Created by Adante on 4/14/2017.
 */
public class ObjectVector {

    private double x;
    private double y;

    public ObjectVector (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getMagnitude () {
        double mag = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return mag;
    }

    public ObjectVector scalarMultiply (double scalar) {
        double newX = x * scalar;
        double newY = y * scalar;
        return new ObjectVector(newX, newY);
    }

    public double getAngle () {
        double angle = Math.atan2(y, x);
        return angle;
    }

    public void setAngle (double angle) {
        double mag = getMagnitude();
        y = mag * Math.sin(angle);
        x = mag * Math.cos(angle);
    }

    public ObjectVector addVector (ObjectVector vector) {
        double newY = y + vector.y;
        double newX = x + vector.x;
        return new ObjectVector(newX, newY);
    }

    public ObjectVector getUnitVector () {
        double mag = getMagnitude();
        double newX;
        double newY;
        if (mag == 0) {
            newX = x;
            newY = y;
        } else {
            newX = x / mag;
            newY = y / mag;
        }
        ObjectVector u = new ObjectVector(newX, newY);
        return u;
    }

    public double getDistance(ObjectVector vector2) {
        double difX = x - vector2.getX();
        double difY = y - vector2.getY();
        double dist = Math.sqrt(Math.pow(difX,2) + Math.pow(difY,2));
        return dist;
    }
}