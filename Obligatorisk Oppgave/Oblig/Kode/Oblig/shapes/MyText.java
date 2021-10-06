package Oblig.shapes;

import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

public class MyText extends Text {

    public MyText(double pX1, double pY1, String text) {
        super(pX1, pY1, text);
    }

    public MyText() {
    }

    public void rotateForward() {
        this.getTransforms()
                .add(new Rotate(15, this.getBoundsInParent().getCenterX(), getBoundsInParent().getCenterY()));
    }

    public void rotateBackward() {
        this.getTransforms()
                .add(new Rotate(-15, this.getBoundsInParent().getCenterX(), getBoundsInParent().getCenterY()));
    }
}
