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
import java.util.ArrayList;

public class Controller {
    @FXML
    HBox statusBar;
    private int numPlayers;
    private Map<Player, Turtle> playerTurtleMap;
    ArrayList<Player> players = new ArrayList<Player>();

    public Controller() {
        Player testPlayer = new HumanPlayer();
        players.add(testPlayer);
    }

    public void menuButtonClicked() {
        System.out.println("Pressed Button");
    }

    public void keyListener(KeyEvent event){
        String keyCode = "none";
        switch (event.getCode()){
            case UP : keyCode = "forward";
                break;
            case DOWN: keyCode = "back";
                break;
            case LEFT : keyCode = "left";
                break;
            case RIGHT : keyCode = "right";
                break;
        }
        for (Player thisPlayer: players) {
            if (thisPlayer.isHuman()) {
                thisPlayer.getKeyAction(keyCode);
            }
        }
    }
    public void keyReleaseListener(KeyEvent release) {
        String keyCode = "none";
        switch(release.getCode()){
            case UP : keyCode = "notf";
                break;
            case DOWN: keyCode = "notb";
                break;
            case LEFT : keyCode = "notl";
                break;
            case RIGHT : keyCode = "notr";
                break;
        }
        for (Player thisPlayer: players) {
            if (thisPlayer.isHuman()) {
                thisPlayer.getKeyAction(keyCode);
            }
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
