package model;


/**
 * The computer player determines its actions through some AI
 * and calls the methods of its turtle
 */
public class ComputerPlayer extends Player{
    TurtleAcc turtle;

    public boolean isHuman(){
        return false;
    }

    public void getAutoAction(){}

    // don't implement - for humans
    public void getKeyAction(int keyPressed){}
}
