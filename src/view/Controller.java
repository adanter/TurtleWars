package view;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

public class Controller {
    @FXML
    HBox statusBar;

    public void menuButtonClicked() {
        System.out.println("Pressed Button");
    }

    public void keyListener(KeyEvent event){
        switch (event.getCode()){
            case UP : System.out.println("UP");
            break;
            case DOWN: System.out.println("DOWN");
            break;
            case LEFT : System.out.println("LEFT");
            break;
            case RIGHT : System.out.println("RIGHT");
            break;
        }

    }
}
