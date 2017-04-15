package view;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import model.ComputerPlayer;
import model.HumanPlayer;
import model.Player;
import model.Turtle;

import java.util.Map;

public class Controller {
    @FXML
    HBox statusBar;
    private int numPlayers;
    private Map<Player, Turtle> playerTurtleMap;

    public void menuButtonClicked() {
        System.out.println("Pressed Button");
    }

    public void keyListener(KeyEvent event){
        switch (event.getCode()){
            case UP : System.out.println("UP");
                break;
            case DOWN: System.out.println("DOWN");
                break;
            case LEFT : System.out.println("LEFT");
                break;
            case RIGHT : System.out.println("RIGHT");
                break;
        }
    }
    public void keyReleaseListener(KeyEvent release) {
        switch(release.getCode()){
            case UP : System.out.println("Not UP");
                break;
            case DOWN: System.out.println("Not DOWN");
                break;
            case LEFT : System.out.println("Not LEFT");
                break;
            case RIGHT : System.out.println("Not RIGHT");
                break;
        }
    }

    /**
     * Method for creating a new player and a corresponding turtle
     */
    private void addPlayer(boolean isHuman) {
        Player newPlayer;
        if (isHuman) {
            newPlayer = new HumanPlayer();
        } else {
            newPlayer = new ComputerPlayer();
        }
        Turtle newTurtle = new Turtle();
        playerTurtleMap.put(newPlayer, newTurtle);
    }

}
