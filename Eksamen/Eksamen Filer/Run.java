package Eksamen;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import Eksamen.Aksje.Sektor;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Run extends Application {
    static ArrayList<Verdipapir> verdipapirer;
    static SluttKursVisuelt tegning = new SluttKursVisuelt(verdipapirer);
    ComboBox<String> box = new ComboBox<>();
    CheckBox aksjer = new CheckBox("Aksjer");
    CheckBox tegningsretter = new CheckBox("Tegningsretter");
    CheckBox aksjefond = new CheckBox("Aksjefond");

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage window) throws Exception {
        BorderPane hovedPane = new BorderPane();

        hovedPane.setCenter(tegning);
        hovedPane.setTop(lagTop());
        hovedPane.setLeft(lagListe());

        Scene scene = new Scene(hovedPane, 800, 400);
        window.setTitle("Eksamen");
        window.setScene(scene);
        window.show();

        aksjer.setOnAction(action -> {
            hovedPane.setCenter(new SluttKursVisuelt(verdipapirer));
        });
        tegningsretter.setOnAction(action -> {
            hovedPane.setCenter(new SluttKursVisuelt(verdipapirer));
        });
        aksjefond.setOnAction(action -> {
            hovedPane.setCenter(new SluttKursVisuelt(verdipapirer));
        });

    }

    protected Pane lagListe() {
        VBox vBox = new VBox();
        vBox.getChildren().addAll(new Label("Velg verdipapir:"));
        for (Verdipapir verdipapir : verdipapirer) {
            box.getItems().add(verdipapir.toString());
        }
        return vBox;
    }

    protected Pane lagTop() {
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(aksjer, tegningsretter, aksjefond);
        vBox.getChildren().add(new Label("Inkluder følgende verdipapirtyper:"));
        vBox.getChildren().addAll(hBox);
        return vBox;
    }
}
