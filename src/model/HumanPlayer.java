package model;


/**
 * The human player responds to key input and calls the methods of its turtle
 */
public class HumanPlayer extends Player {
    int keys;
    Turtle turtle;

    public boolean isHuman(){
        return true;
    }

    public void getKeyAction(char keyPressed){
        if (keyPressed == 'u') {
            turtle.accelerate(1);
        } else if (keyPressed == 'd') {
            turtle.accelerate(-1);
        } else if (keyPressed == 'l') {
            turtle.turn(-1);
        } else if (keyPressed == 'r') {
            turtle.turn(1);
        }

    }

    // don't implement - for computers
    public void getAutoAction(){}

}
