package model;


/**
 * Implements the position and movement of turtle
 */
public class Turtle extends GameObject {
    int health;
    private ObjectVector velocity = new ObjectVector(0,0);
    private double directionFacing = 0;
    private double rotateVel = 0;
    private Game game;

    public Turtle(ObjectVector position, double size, Game game) {
        setPosition(position);
        this.size = size;
    }

    public void changeVel(int direction){
        ObjectVector nextVel = new ObjectVector(1,0);
        nextVel.setAngle(directionFacing);
        nextVel = nextVel.getUnitVector();
        velocity = nextVel.scalarMultiply(direction);;
    }

    // side: -1 = left, 1 = right
    public void turn(int side) {
        rotateVel = side*0.1;
    };

    public void move(double timeStep) {
        ObjectVector posChange = velocity.scalarMultiply(timeStep);
        position = position.addVector(velocity);
        setPosition(position);
        directionFacing += rotateVel;
        System.out.println("updating");
    }

    public void interact(GameObject other) {
        if (other instanceof Bullet && closeTo(other)) {
            Bullet bullet = (Bullet) other;
            if (bullet.getParentTurtle() != this) {
                health -= bullet.getDamage();
            }
        }
    }

    public boolean isDead() {
        if (health <= 0) {
            return true;
        } else return false;
    }

    public void shoot(){
        ObjectVector vector = new ObjectVector(0,1);
        vector.setAngle(directionFacing);
        vector.getUnitVector();
        game.addBullet(new Bullet(position, vector, this));
    }

    public ObjectVector getVelocity() {return velocity;}
    public double getSize() {return size;}
    public double getDirectionFacing() {return directionFacing;}
}