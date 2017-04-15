package model;


/**
 * The human player responds to key input and calls the methods of its turtle
 */
public class HumanPlayer implements PlayerInterface {
    int keys;
    Turtle turtle;

    public boolean isHuman(){
        return true;
    }

    public void getKeyAction(int keyPressed){}

    // don't implement - for computers
    public void getAutoAction(){}

}
