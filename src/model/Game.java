package model;

import java.util.ArrayList;

/**
 * Created by Adante on 4/14/2017.
 */
public class Game {
    private int numPlayers;
    private ArrayList<TurtleAcc> turtles = new ArrayList<TurtleAcc>();
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    /**
     * Once the game has been set up (i.e., players and turtles have been instantiated), this method will run the game
     * in real time.  The idea is that it will loop over all game objects (turtles, bullets) and update them.
     */
    private void runGame() {
        boolean gameOver = false;
//        long prevTime;
//        long curTime = System.currentTimeMillis();
//        long elapsedTime;
        while (!gameOver) {
//            prevTime = curTime;
//            curTime = System.currentTimeMillis();
//            elapsedTime = curTime - prevTime;
            // TODO: Update all game objects
        }
    }
}
