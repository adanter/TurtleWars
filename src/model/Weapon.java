/* weapon class */

package model;

public class Weapon {
    double rechargeTime = 1;
    long lastTime = 0;
    Turtle parentTurtle;

    public Weapon(Turtle parentTurtle) {
        this.parentTurtle = parentTurtle;
    }

    public void fire() {
        long curTime = System.currentTimeMillis();
        if (curTime - lastTime > rechargeTime) {

        }
        else {

        }
    }
}