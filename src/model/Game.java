package model;

import java.util.ArrayList;

/**
 * Created by Adante on 4/14/2017.
 */
public class Game {
    private int numPlayers;
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    private ArrayList<Turtle> turtles = new ArrayList<>();
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();

    public Game() {
    }

    /**
     * Once the game has been set up (i.e., players and turtles have been instantiated), this method will run the game
     * in real time.  The idea is that it will loop over all game objects (turtles, bullets) and update them.
     */
    public void runGame() {
        boolean gameOver = false;
        long prevTime;
        long curTime = System.currentTimeMillis();
        double elapsedTime;
        while (!gameOver) {
            prevTime = curTime;
            curTime = System.currentTimeMillis();
            elapsedTime = (double) (curTime - prevTime) * .001; //elapsed time in seconds

            //Resolve player actions
            for (Player player : players) {
                player.getAutoAction();
            }

            //Update objects and run interactions
            for (int i = 0; i < objects.size(); i++) {
                GameObject object = objects.get(i);
                object.update(elapsedTime);
                for (int j = i + 1; j < objects.size(); j++) {
                    GameObject object2 = objects.get(j);
                    if (object2 != object) {
                        if (object.closeTo(object2)) {
                            object.interact(object2);
                            object2.interact(object);
                        }
                    }
                }
            }

            ArrayList<Turtle> nextTurtles = new ArrayList<>();
            ArrayList<Bullet> nextBullets = new ArrayList<>();
            //Run death checks
            for (Turtle turtle : turtles) {
                if (!turtle.isDead()) nextTurtles.add(turtle);
            }
            for (Bullet bullet : bullets) {
                if (!bullet.isDead()) nextBullets.add(bullet);
            }

            turtles = nextTurtles;
            bullets = nextBullets;

            if (turtles.size() <= 1) gameOver = true;

            gameOver = true; //TODO: Remove this when we're ready to run!
        }
    }

    public void addTurtle(Turtle turtle) {
        turtles.add(turtle);
    }

    public void addBullet(Bullet bullet) {
        bullets.add(bullet);
    }

    public void addPlayer(Player player) {
        players.add(player);
        turtles.add(player.getTurtle());
    }

    public ArrayList<Turtle> getTurtles() {
        return turtles;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

}

