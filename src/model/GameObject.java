package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableDoubleValue;

/**
 * Any object in the game that moves and can interact with other objects
 */
public class GameObject {
    ObjectVector position;
    public ObservableDoubleValue x;
    public ObservableDoubleValue y;
    double size;

    public void setPosition(ObjectVector new_position) {
        position = new_position;
        x = new SimpleDoubleProperty(new_position.getX());
        y = new SimpleDoubleProperty(new_position.getY());
    }

    public void update(double timeStep) {}
    public void interact(GameObject other) {}
    public boolean isDead() {return false;}

    public ObjectVector getPosition() {return position;}

    public boolean closeTo(GameObject other) {
        return position.getDistance(other.getPosition()) < size + other.getSize();
    }

    public double getSize() {return size;}

    public void addPositionListener() {}
}
