package Controller;

import game.Players;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Ez felel a játékosok neveiért.
 */
public class ChooseNameController {


    /**
     * Egy textfiled id, ami a beírandó négyzetbe promptexttel jelzi, milyen inputot vár.
     */
    @FXML
    TextField player1;
    /**
     * Egy textfiled id, ami a beírandó négyzetbe promptexttel jelzi, milyen inputot vár.
     */
    @FXML
    TextField player2;
    /**
     * Egy label, amivel ha nem adnak be nevet, és úgy lépne tovább, egy text-et dob ki.
     */
    @FXML
    Label warning;

    /**
     * Egy label id, ami a player1 fölé kiírja a megadott textet.
     */
    @FXML
    Label blue;
    /**
     * Egy label id, ami a player2 fölé kiírja a megadott textet.
     */
    @FXML
    Label red;

    /**
     * Logger.
     */
    private static Logger logger = LoggerFactory.getLogger(ChooseNameController.class);

    /**
     * Visszalépésre alkalmas gomb.
     * Rákattintva a MainMenu.fxml-be dob vissza minket.
     */
    @FXML
    public void BackButtonClicked() {
        Scene scene = warning.getScene();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/MainMenu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scene.setRoot(root);

    }

    /**
     * A két megadott név után, a továbblépésre alkalmas gomb.
     * Game.fxml-be lép be.
     * Ha nincs megadva mind a két név, akkor a warning.setText()-et dobja ki, míg meg nem adjuk őket.
     */

    @FXML
    public void ContinueButtonClicked() {
        if (player1.getText().equals("") || player2.getText().equals("")) {
            warning.setText("Type both name!");
            logger.info("Nem adta meg mind a két nevet.");
        } else {
            Players.setFirstPlayer(player1.getText());
            Players.setSecondPlayer(player2.getText());
            Scene scene = warning.getScene();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/FXML/Game.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            scene.setRoot(root);
        }
        logger.info("Sikeres Game.fxml betöltés.");
    }
}
