package model;

import java.util.ArrayList;

/**
 * Created by Adante on 4/14/2017.
 */
public class Game implements Runnable{
    private int numPlayers;
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    private ArrayList<Turtle> turtles = new ArrayList<>();
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();

    public Game() {
    }

    /**
     * Once the game has been set up (i.e., players and turtles have been instantiated), this method will run the game
     * in real time.  The idea is that it will loop over all game objects (turtles, bullets) and move them.
     */
    public void run() {
        boolean gameOver = false;
        long prevTime;
        long curTime = System.currentTimeMillis();
        double elapsedTime;
        int index = 0;
        while (!gameOver) {
            prevTime = curTime;
            curTime = System.currentTimeMillis();
            elapsedTime = (double) (curTime - prevTime) * 0.001; //elapsed time in seconds

            //Resolve player actions
            for (Player player : players) {
                player.getAutoAction();
            }

            //Update turtles
            for (Turtle turtle : turtles) {
                //turtle.move(elapsedTime);
                turtle.move(1);
            }

            ArrayList<Bullet> nextBullets = new ArrayList<>();
            ArrayList<Turtle> nextTurtles = new ArrayList<>();

            //Update bullets, run interactions, and perform death checks
            for (Bullet bullet : bullets) {
                bullet.move(elapsedTime);
                for (Turtle turtle : turtles) {
                    bullet.interact(turtle);
                }
                if (!bullet.isDead()) nextBullets.add(bullet);
            }

            //Run turtle interactions and perform death checks
            for (Turtle turtle : turtles) {
                for (Bullet bullet : bullets) {
                    turtle.interact(bullet);
                }
                if (!turtle.isDead()) nextTurtles.add(turtle);
            }

            turtles = nextTurtles;
            bullets = nextBullets;

            //if (turtles.size() <= 1) gameOver = true;
            //gameOver = true; //TODO: Remove this when we're ready to run!
            if (index > 5){
                gameOver = true;
            }
            index ++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
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
