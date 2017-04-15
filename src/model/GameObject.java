package model;

import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.ObjectBinding;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableDoubleValue;
import javafx.scene.layout.Region;

import java.util.Observable;

/**
 * Any object in the game that moves and can interact with other objects
 */
public class GameObject extends Observable {
    ObjectVector position;
    public ObservableDoubleValue x = new SimpleDoubleProperty(0);
    public ObservableDoubleValue y = new SimpleDoubleProperty(0);
    public ObservablePosition objectPosition = new ObservablePosition();
    //public ObservableDoubleValue x;
    //public ObservableDoubleValue y;
    boolean isDead;
    double size;

    public ObservableDoubleValue getX(){return x;}
    public ObservableDoubleValue getY(){return y;}

    public void setPosition(ObjectVector new_position) {
        position = new_position;

        x = new SimpleDoubleProperty(new_position.getX());
        y = new SimpleDoubleProperty(new_position.getY());
    }

    public void setChanged(){
        notifyObservers(position);
    }

    public void move(double timeStep) {}
    public void interact(GameObject other) {}
    public boolean isDead() {return false;}

    public ObjectVector getPosition() {return position;}

    public boolean closeTo(GameObject other) {
        return position.getDistance(other.getPosition()) < size + other.getSize();
    }

    public ObservablePosition getObservablePosition(){
        return new ObservablePosition();
    }

    public class ObservablePosition extends ObjectBinding {
        private final ObjectVector myPos = new ObjectVector(0, 0);
        public ObjectVector computeValue(){
            return (myPos);
        }

        public ObservablePosition(){
            ObjectVector myPos = position;
            bind(this);
        }
    }

    public double getSize() {return size;}

    public void addPositionListener() {}
}
