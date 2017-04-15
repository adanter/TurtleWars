package view;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableDoubleValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import model.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import model.ComputerPlayer;
import model.HumanPlayer;
import model.Player;
import model.Turtle;
import model.Game;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Map;
import java.util.ArrayList;
import java.util.Observable;

public class Controller{
    @FXML
    HBox statusBar;
    @FXML
    GridPane display;
    private int numPlayers;
    private ArrayList<GameObject> turtles;
    ArrayList<Player> players = new ArrayList<Player>();
    ArrayList<HBox> healthBarList = new ArrayList<>();
    private Game game = new Game();

    public Controller() {
        addPlayer(true);
    }

    public void runGame() {
        game.runGame();
    }

    public void newGameButtonClicked() {
        Player firstPlayer = new HumanPlayer(game);
        players.add(firstPlayer);
        game.addPlayer(firstPlayer);
        game.addTurtle(firstPlayer.getTurtle());
        runGame();
    }


    public void menuButtonClicked() {
        System.out.println("Pressed Button");
        fillStatusBar();
        updateHealth(healthBarList.get(0));
    }

    public void updateHealth(HBox healthBar){
        int curHealth = 10; //replace with actual health value
        for (int i = 0; i < curHealth; i++) {
            Rectangle r = (Rectangle) healthBar.getChildren().get(i);
            r.setFill(Paint.valueOf("red"));
        }
        for (int i = curHealth; i < 10; i++) {
            Rectangle r = (Rectangle) healthBar.getChildren().get(i);
            r.setFill(Paint.valueOf("black"));
        }
    }

    @FXML
    public void fillStatusBar(){
        VBox v = new VBox(1.0);
        v.setAlignment(Pos.CENTER_RIGHT);
        HBox newBar = genHealthBar(7);
        healthBarList.add(newBar);
        v.getChildren().addAll(newBar, new Label("Player"));
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

    public void update(Observable o,Object arg){

    }

    /**
     * Method for creating a new player and a corresponding turtle
     */
    private void addPlayer(boolean isHuman) {
        Player newPlayer;
        if (isHuman) {
            newPlayer = new HumanPlayer(game);
        } else {
            newPlayer = new ComputerPlayer(game);
        }
        players.add(newPlayer);
        newPlayer.turtle.addObserver(new ObjectObserver());
    }

}
