package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.FxMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * A játék indításakor fogadó osztály.
 * Teljes képernyősként nyitja meg a játékot.
 */

public class MainMenuController {
    /**
     * Egy label, ezzel hozom be a contentet, és az ablakot.
     */
    @FXML
    Label warning;
    private static Logger logger = LoggerFactory.getLogger(MainMenuController.class);

    /**
     * Ez a gomb visz tovább a PlayerName.fxml-be.
     */
    public void ButtonClicked() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/PlayerName.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Sikeres PlayerName.fxml betöltés");

        Stage stage = (Stage) warning.getScene().getWindow();
        stage.setTitle("FXML Welcome");
        stage.setScene(new Scene(root, 300, 275));
        stage.setFullScreen(true);
        stage.show();
    }

}
