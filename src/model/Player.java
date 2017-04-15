package model;

import javax.swing.event.ChangeListener;

public class Player{
    public Turtle turtle;
    public boolean isHuman() { return true;}
    public void getKeyAction(String keyPressed) {}
    public void getAutoAction() {}
    public Turtle getTurtle() {return turtle;}
}
