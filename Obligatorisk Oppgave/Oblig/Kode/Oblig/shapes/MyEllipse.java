package Oblig.shapes;

import javafx.scene.shape.Ellipse;
import javafx.scene.transform.Rotate;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;

public class MyEllipse extends Ellipse {
    private double areal;

    public MyEllipse(double x, double y, double radiusX, double radiusY) {
        super(x, y, radiusX, radiusY);
        this.areal = Math.round((radiusX * radiusY * Math.PI)) / 100.0;
    }

    public MyEllipse() {
    }

    public void drawCircleEffect(GraphicsContext frame, Canvas canvas, double pX1, double pY1, double pX2, double pY2,
            Color color) {
        double radius = Math.sqrt(Math.pow(pX2 - pX1, 2) + Math.pow(pY2 - pY1, 2));
        frame.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        frame.setStroke(color);
        frame.strokeOval(pX1 - radius, pY1 - radius, radius * 2, radius * 2);
    }

    public double getPointsCircle(double pX1, double pY1, double pX2, double pY2) {
        return Math.sqrt(Math.pow(pX2 - pX1, 2) + Math.pow(pY2 - pY1, 2));
    }

    public double getAreal() {
        return areal;
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
