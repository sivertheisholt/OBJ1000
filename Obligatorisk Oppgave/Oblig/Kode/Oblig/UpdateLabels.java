package Oblig;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UpdateLabels {

    public static void setLabelCircle(Figur figur, Label labelType, Label labelFarge, Label labelLineLength,
            Label labelAreal) {
        labelAreal.setText(String.valueOf(figur.getCircle().getAreal()) + "px^2");
        labelFarge.setText(String.valueOf(figur.getColor()));
        labelType.setText(String.valueOf(figur.getType()));
        labelLineLength.setText("Unsupported");
    }

    public static void setLabelRectangle(Figur figur, Label labelType, Label labelFarge, Label labelLineLength,
            Label labelAreal) {
        labelAreal.setText(String.valueOf(figur.getRetangle().getAreal()) + "px^2");
        labelFarge.setText(figur.getColor());
        labelType.setText(String.valueOf(figur.getType()));
        labelLineLength.setText("Unsupported");
    }

    public static void setLabelLine(Figur figur, Label labelType, Label labelFarge, Label labelLineLength,
            Label labelAreal) {
        labelAreal.setText("Unsupported");
        labelFarge.setText(String.valueOf(figur.getColor()));
        labelType.setText(String.valueOf(figur.getType()));
        labelLineLength.setText(String.valueOf(figur.getLine().getLineLength()) + "px");
    }

    public static void setLabelText(Figur figur, Label labelType, Label labelFarge, Label labelLineLength,
            Label labelAreal) {
        labelAreal.setText("Unsupported");
        labelFarge.setText(String.valueOf(figur.getColor()));
        labelType.setText(String.valueOf(figur.getType()));
        labelLineLength.setText("Unsupported");
    }
}
