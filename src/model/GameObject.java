package model;

/**
 * Any object in the game that moves and can interact with other objects
 */
public class GameObject {
    ObjectVector position;
    double size;

    public void update(double timeStep) {}
    public void interact(GameObject other) {}

    public ObjectVector getPosition() {return position;}

    public boolean closeTo(GameObject other) {
        return position.getDistance(other.getPosition()) < size + other.getSize();
    }

    public double getSize() {return size;}
}
