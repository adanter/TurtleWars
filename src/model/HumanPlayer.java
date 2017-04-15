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

    public void getKeyAction(String keyPressed){
        switch(keyPressed) {
            case "forward":
                turtle.changeVel(1);
                break;
            case "back":
                turtle.changeVel(-1);
                break;
            case "left":
                turtle.turn(-1);
                break;
            case "right":
                turtle.turn(1);
                break;
            case "notf":
                turtle.changeVel(0);
                break;
            case "notb":
                turtle.changeVel(0);
                break;
            case "notl":
                turtle.turn(0);
                break;
            case "notr":
                turtle.turn(0);
                break;
            default:
                break;
        }
    }

    // don't implement - for computers
    public void getAutoAction(){}

}
