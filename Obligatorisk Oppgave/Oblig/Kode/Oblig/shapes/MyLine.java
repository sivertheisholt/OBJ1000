package Oblig.shapes;

import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;

public class MyLine extends Line {
    public MyLine(double x, double y, double x2, double y2) {
        super(x, y, x2, y2);
    }

    public MyLine() {
    }

    public void drawLineEffect(GraphicsContext frame, Canvas canvas, double pX1, double pY1, double pX2, double pY2,
            Color color) {
        frame.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        frame.setStroke(color);
        frame.strokeLine(pX1, pY1, pX2, pY2);
    }

    public void rotateForward() {
        this.getTransforms()
                .add(new Rotate(15, this.getBoundsInParent().getCenterX(), getBoundsInParent().getCenterY()));
    }

    public void rotateBackward() {
        this.getTransforms()
                .add(new Rotate(-15, this.getBoundsInParent().getCenterX(), getBoundsInParent().getCenterY()));
    }

    public double getLineLength() {
        return Math.round((Math
                .sqrt(Math.pow(this.getEndX() - this.getStartX(), 2) + Math.pow(this.getEndY() - this.getStartY(), 2))))
                / 100.0;
    }
}
