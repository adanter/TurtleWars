package view;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
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
        fillStatusBar();
    }

    @FXML
    public void fillStatusBar(){
        VBox v = new VBox(1.0);
        v.setAlignment(Pos.CENTER_RIGHT);
        v.getChildren().addAll(genHealthBar(7), new Label("Player"));
        statusBar.getChildren().addAll(v);
    }

    public HBox genHealthBar(int curHealth){
        HBox result = new HBox(1);
        for (int i = 0; i < curHealth; i++){
            Rectangle r = new Rectangle(4,7, Paint.valueOf("red"));
            result.getChildren().add(r);
        }
        for (int i = curHealth; i < 10; i++) {
            Rectangle r = new Rectangle(4,7, Paint.valueOf("black"));
            result.getChildren().add(r);
        }
        return result;
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
