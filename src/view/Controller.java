package view;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class Controller {
    @FXML
    HBox statusBar;

    public void menuButtonPressed() {
        System.out.println("Pressed Button");
    }
}
