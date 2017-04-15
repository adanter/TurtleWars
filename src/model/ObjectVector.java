package model;

/**
 * Created by Adante on 4/14/2017.
 */
public class ObjectVector {

    double xVelocity;
    double yVelocity;

    public ObjectVector (double xVelocity, double yVelocity) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public double getxVelocity () {
        return xVelocity;
    }

    public double getyVelocity () {
        return yVelocity;
    }

    public double getMagnitude () {
        double mag = Math.sqrt(Math.pow(xVelocity, 2) + Math.pow(yVelocity, 2));
        return mag;
    }

    public void scalarMultiply (double scalar) {
        xVelocity = xVelocity * scalar;
        yVelocity = yVelocity * scalar;
    }

    public double getAngle () {
        double angle = Math.atan2(yVelocity, xVelocity);
        return angle;
    }

    public void setAngle (double angle) {
        double mag = getMagnitude();
        yVelocity = mag * Math.sin(angle);
        xVelocity = mag * Math.cos(angle);
    }

    public void addVector (ObjectVector vector) {
        yVelocity += vector.yVelocity;
        xVelocity += vector.xVelocity;
    }
}
