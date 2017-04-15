package model;

/**
 * A common interface for human and computer players
 * to store them in lists and call common methods
 */
interface PlayerInterface {
    boolean isHuman();
    void getKeyAction(int keyPressed);
    void getAutoAction();
}
