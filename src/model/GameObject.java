package model;

/**
 * Any object in the game that moves and can interact with other objects
 */
public class GameObject {
    public void update(double timeStep) {}
    public void interact(GameObject other) {}
    public ObjectVector getPosition() { return new ObjectVector(0,0);}
    public double getSize() {return 0;}
}
