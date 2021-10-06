package Oblig.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.scene.canvas.Canvas;

public class MyPolygon extends Polygon {
    private double areal;

    public MyPolygon(double[] xy, double length, double width) {
        super(xy);
        this.areal = Math.round((length * width)) / 100.0;
    }

    public MyPolygon() {
    }

    public void drawRectangleEffect(GraphicsContext frame, Canvas canvas, double pX1, double pY1, double pX2,
            double pY2, Color color) {
        double midX = (pX1 + pX2) / 2, midY = (pY1 + pY2) / 2;
        double diffX = midX - pX2, diffY = midY - pY2;

        double[] xs = new double[4];
        double[] ys = new double[4];
        xs[0] = pX1;
        ys[0] = pY1;
        xs[2] = pX2;
        ys[2] = pY2;
        xs[1] = midX + diffY;
        ys[1] = midY + diffX;
        xs[3] = midX - diffY;
        ys[3] = midY - diffX;

        frame.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        frame.setStroke(color);
        frame.strokePolygon(xs, ys, 4);
    }

    public double[] getPointsRectangle(double pX1, double pY1, double pX2, double pY2) {
        double midX = (pX1 + pX2) / 2, midY = (pY1 + pY2) / 2;

        double diffX = midX - pX2, diffY = midY - pY2;
        double[] xy = new double[8];
        xy[0] = pX1;
        xy[1] = pY1;
        xy[4] = pX2;
        xy[5] = pY2;
        xy[2] = midX + diffY;
        xy[3] = midY + diffX;
        xy[6] = midX - diffY;
        xy[7] = midY - diffX;

        return xy;
    }

    public double getLength(double[] xy) {
        return xy[2] - xy[0] < 0 ? Math.abs(xy[2] - xy[0]) : xy[2] - xy[0];
    }

    public double getWidth(double[] xy) {
        return xy[6] - xy[0] < 0 ? Math.abs(xy[6] - xy[0]) : xy[6] - xy[0];
    }

    public double getAreal() {
        return this.areal;
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
