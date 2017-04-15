package view;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.value.ObservableDoubleValue;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import model.GameObject;
import javafx.scene.shape.Circle;
import model.ObjectVector;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Adam Klein on 4/15/2017.
 */
public class ObjectObserver implements Observer{
    public Shape shape;
    public ObjectObserver(){
        shape = new Circle(20, Paint.valueOf("blue"));
    }

    public void update(Observable o, Object arg){
        ObjectVector pos = (ObjectVector) arg;
        shape.layoutXProperty().setValue(pos.getX());
        shape.layoutXProperty().setValue(pos.getY());
    }
}
