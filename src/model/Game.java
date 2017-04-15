package model;

import java.util.ArrayList;

/**
 * Created by Adante on 4/14/2017.
 */
public class Game {
    private int numPlayers;
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();

    /**
     * Once the game has been set up (i.e., players and turtles have been instantiated), this method will run the game
     * in real time.  The idea is that it will loop over all game objects (turtles, bullets) and update them.
     */
    public void runGame() {
        boolean gameOver = false;
//        long prevTime;
//        long curTime = System.currentTimeMillis();
//        long elapsedTime;
        while (!gameOver) {
//            prevTime = curTime;
//            curTime = System.currentTimeMillis();
//            elapsedTime = curTime - prevTime;
            // TODO: Update all game objects
            for (int i = 0; i < objects.size(); i++) {
                GameObject object = objects.get(i);
                object.update(0.001);
                for (int j = i+1; j < objects.size(); j++) {
                    GameObject object2 = objects.get(j);
                    if (object2 != object) {
                        if (object.closeTo(object2)) {
                            object.interact(object2);
                            object2.interact(object);
                        }
                    }
                }
            }
            gameOver = true;
        }
    }
}
