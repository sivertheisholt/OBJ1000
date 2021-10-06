package Eksamen;

import java.util.ArrayList;

import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

public class SluttKursVisuelt extends HBox {
    public SluttKursVisuelt(ArrayList<Verdipapir> verdipapirer) {
        super();
        for (Verdipapir verdipapir : verdipapirer) {
            Rectangle r = new Rectangle();
            double[] kurser = verdipapir.getSluttKurser();
            for (int i = 0; i < kurser.length; i++) {
                r.setX(0);
                r.setY(0);
                r.setWidth(1);
                r.setHeight(kurser[i]);
                getChildren().add(r);
            }
        }
    }
}
