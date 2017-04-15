package model;

import java.util.ArrayList;

/**
 * The computer player determines its actions through some AI
 * and calls the methods of its turtle
 */
public class ComputerPlayer extends Player{
    Turtle turtle;
    Game game;

    public ComputerPlayer(Game game) {
        this.game = game;
    }

    public boolean isHuman(){
        return false;
    }

    public void getAutoAction(){
        Bullet closestBullet = null;
        double closestBulletDist = 1000;
        ArrayList<Bullet> bullets = game.getBullets();
        for (Bullet bullet: bullets) {
            if (bullet.getParentTurtle() != turtle) {
                double thisDist = turtle.getPosition().getDistance(bullet.getPosition());
                if (thisDist < closestBulletDist) {
                    closestBulletDist = thisDist;
                    closestBullet = bullet;
                }
            }
        }

        if (closestBullet != null) {
            ObjectVector negPosition = turtle.getPosition().scalarMultiply(-1);
            ObjectVector bullet_direction = closestBullet.getPosition().addVector(negPosition);
            double bullet_angle = bullet_direction.getAngle();
            double turtle_angle = turtle.getDirectionFacing();
            if (turtle_angle % (Math.PI*2) - bullet_angle % (Math.PI*2) > 0) {
                turtle.turn(1);
            } else {
                turtle.turn(-1);
            }
        }
    }

    // don't implement - for humans
    public void getKeyAction(int keyPressed){}
}
