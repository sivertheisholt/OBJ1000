package Oblig;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class Run extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage window) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Run.fxml"));
        Scene scene = new Scene(root);
        window.setResizable(false);

        // Finalize
        window.setTitle("Oblig");
        window.setScene(scene);
        window.show();

    }
}
