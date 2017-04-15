package model;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableDoubleValue;
import javafx.beans.value.ObservableObjectValue;

/**
 * Implements the position and movement of turtle
 */
public class Turtle extends GameObject {
    int health;
    double size;
    //private ObjectVector position = new ObjectVector(0,0);
    public ObservableDoubleValue x = new SimpleDoubleProperty(0);
    public ObservableDoubleValue y = new SimpleDoubleProperty(0);
    private ObjectVector velocity = new ObjectVector(0,0);
    private double direction_facing = 0;
    private double rotateVel = 0;

    public Turtle(ObjectVector position, double size) {
        this.position = position;
        this.size = size;
    }

    public void changeVel(int direction){
        ObjectVector nextVel = new ObjectVector(1,0);
        nextVel.setAngle(direction_facing);
        nextVel = nextVel.getUnitVector();
        nextVel.scalarMultiply(direction);
        velocity = nextVel;
    }

    // side: -1 = left, 1 = right
    public void turn(int side) {
        rotateVel = side*0.1;
    };

    public void update(double timeStep) {
        velocity.scalarMultiply(timeStep);
        position.addVector(velocity);
        direction_facing += rotateVel;
        System.out.println("updating to " + position.getX() + ',' + position.getY());
    }

    public void interact(GameObject other) {}
    public void shoot(){
        ObjectVector vector = new ObjectVector(0,1);
        vector.setAngle(direction_facing);
        vector.getUnitVector();
        new Bullet(position, vector);
    }
    public ObjectVector getVelocity() {return velocity;}
    public double getSize() {return size;}

}