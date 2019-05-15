package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A projekt fő osztálya.
 */
public class FxMain extends Application {
    /**
     * A Main osztály hívja meg.
     *
     * @param args parancssori argumentumok.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * A játékprogram indulását kezelő függvény.
     *
     * @param stage a fő programablak
     */
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/FXML/MainMenu.fxml"));

        stage.setTitle("FXML Welcome");
        stage.setScene(new Scene(root));
        //Scene scene = new Scene(root,300,275);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.show();
    }
}
