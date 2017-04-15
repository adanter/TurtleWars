package model;


/**
 * The computer player determines its actions through some AI
 * and calls the methods of its turtle
 */
public class ComputerPlayer implements PlayerInterface{
    Turtle turtle;

    public boolean isHuman(){
        return false;
    }

    // don't implement - for humans
    public void getKeyAction(int keyPressed){}

    public void getAutoAction(){}
}
