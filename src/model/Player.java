package model;

public class Player{
    Turtle turtle;
    public void addPositionListener() {turtle.addPositionListener();}
    public boolean isHuman() { return true;}
    public void getKeyAction(String keyPressed) {}
    public void getAutoAction() {}
    public Turtle getTurtle() {return turtle;}
}
