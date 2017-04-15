package view;

import javafx.fxml.FXML;
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

    public void menuButtonPressed() {
        System.out.println("Pressed Button");
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
