package Oblig;

import Oblig.shapes.MyEllipse;
import Oblig.shapes.MyLine;
import Oblig.shapes.MyPolygon;
import Oblig.shapes.MyPolyline;
import Oblig.shapes.MyText;
import javafx.scene.paint.Color;

public class Figur {
    private MyPolygon rectangle;
    private MyEllipse circle;
    private MyLine line;
    private MyPolyline polyline;
    private MyText text;
    private int id;
    private String type;
    private String color;

    //////////////////////////////////////////
    // *** Shapes ***
    //////////////////////////////////////////

    public void setRectangle(double pX1, double pY1, double pX2, double pY2) {
        double[] points = rectangle.getPointsRectangle(pX1, pY1, pX2, pY2);
        double length = rectangle.getLength(points);
        double width = rectangle.getWidth(points);
        this.rectangle = new MyPolygon(points, length, width);
    }

    public void setRectangle() {
        this.rectangle = new MyPolygon();
    }

    public MyPolygon getRetangle() {
        return this.rectangle;
    }

    public void setCircle(double pX1, double pY1, double pX2, double pY2) {
        double radius = circle.getPointsCircle(pX1, pY1, pX2, pY2);
        this.circle = new MyEllipse(pX1, pY1, radius, radius);
    }

    public void setCircle() {
        this.circle = new MyEllipse();
    }

    public MyEllipse getCircle() {
        return this.circle;
    }

    public void setLine(double x, double y, double x2, double y2) {
        this.line = new MyLine(x, y, x2, y2);
    }

    public void setLine() {
        this.line = new MyLine();
    }

    public MyLine getLine() {
        return this.line;
    }

    public void setPolyline(double x, double y, double x2, double y2) {
        this.polyline = new MyPolyline(x, y, x2, y2);
    }

    public MyPolyline getPolyline() {
        return this.polyline;
    }

    public void setText(double x, double y, String text) {
        this.text = new MyText(x, y, text);
    }

    public void setText() {
        this.text = new MyText();
    }

    public MyText getText() {
        return this.text;
    }

    //////////////////////////////////////////
    // *** Other ***
    //////////////////////////////////////////
    public Figur(int id, String type, String color) {
        this.id = id;
        this.type = type;
        this.color = color;
    }

    public Figur() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGeneralInfo() {
        return this.id + ": " + this.type;
    }

    public void rotateForward() {
        switch (this.getType()) {
            case "Rectangle":
                this.getRetangle().rotateForward();
                break;
            case "Circle":
                this.getCircle().rotateForward();
                break;
            case "Line":
                this.getLine().rotateForward();
                break;
            case "Text":
                this.getText().rotateForward();
                break;
        }
    }

    public void rotateBackward() {
        switch (this.getType()) {
            case "Rectangle":
                this.getRetangle().rotateBackward();
                break;
            case "Circle":
                this.getCircle().rotateBackward();
                break;
            case "Line":
                this.getLine().rotateBackward();
                break;
            case "Text":
                this.getText().rotateBackward();
                break;
        }
    }

    public void changeColor(Color color) {
        switch (this.getType()) {
            case "Rectangle":
                this.getRetangle().setFill(color);
                break;
            case "Circle":
                this.getCircle().setFill(color);
                break;
            case "Line":
                this.getLine().setStroke(color);
                break;
            case "Text":
                this.getText().setFill(color);
                break;
        }
    }
}