package Controller;

import game.LeaderBoard;
import game.Winners;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.LinkedHashMap;

/**
 * Ez a class a Winnernek a controllere.
 * Található benne a grafikus felülethez tartózó 2db gomb metódusa.
 * A printToTable grafikus táblakiíratás.
 * A toXML kiíratás.
 * A fromXML beíratás.
 * Az initialite metódus.
 */

public class WinnerController {

    /**
     * Egy label, amivel egy szöveget és a győztes nevét íratom ki.
     */
    @FXML
    Label gyoztes;
    /**
     * Egy label, ami alatt a győztesek nevei lesznek láthatók.
     */
    @FXML
    Label names;
    /**
     * Egy label, ami alatt a győztesek pontjai lesznek láthatók.
     */
    @FXML
    Label points;
    /**
     * Egy VBox, ebben vannak benne a (Label names) nevek és a (Label points) pontok.
     */
    @FXML
    VBox idTable;
    private static Logger logger = LoggerFactory.getLogger(ChooseNameController.class);

    /**
     * A győztes kiíratásáért felel a grafikus részben.
     * Benne található a fromXML és a toXML metódusok hívása.
     * Grafikus részen a táblát íratja ki.
     * Növeli az XML fájlt, minden győztes után beleteszi a győztes nevét, ha még nem volt benne, és a pontjait.
     *
     * @throws IOException Ha az initialize függvényt használom, akkor ezt mindig bele kell írni, és ezt le kell kezelni try-catch függvénnyel.
     */
    public void initialize() throws IOException {
        if (Winners.winner.equals("Döntetlen")) {
            gyoztes.setText("Döntetlen lett a játék, nincs nyertes.");
            fromXML();
            printToTable();
        } else {
            gyoztes.setText("A nyertes: " + Winners.winner);
            fromXML();
            LeaderBoard.addToList(Winners.winner);
            printToTable();
            toXML(new LeaderBoard());
        }
    }

    /**
     * A grafikus felületnél az exit gomb.
     */
    @FXML
    public void ExitButtonClicked() {
        System.exit(0);
    }

    /**
     * A grafikus felületnél az new game gomb.
     * Újra betölti a Game.fxml-t
     */
    @FXML
    public void NewGameButtonClicked() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/Game.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) gyoztes.getScene().getWindow();
        stage.setTitle("FXML Welcome ");
        stage.setScene(new Scene(root, 300, 275));
        stage.setFullScreen(true);
        stage.show();
    }

    /**
     * A top5 játékost írja ki minden játék végén.
     * Minden fordulónál rendezi a játékosok pontjait,és úgy adja ki a top5 playert.
     * A HBox-ok igazítása látszik még benne, hogy a names alatt a játékosok nevei, a points alatt a pontjai legyenek láthatók.
     */
    @FXML
    public void printToTable() {
        LinkedHashMap<String, Integer> getTop5Player = LeaderBoard.top5();
        for (String s : getTop5Player.keySet()
        ) {
            //hozzáadja a nevet és a pontot, amíg van.
            HBox left = new HBox();
            HBox right = new HBox();
            left.setMinWidth(300);
            right.setMinWidth(300);
            left.setAlignment(Pos.CENTER_RIGHT);
            right.setAlignment(Pos.CENTER_RIGHT);
            left.getChildren().addAll(new Label(s));
            right.getChildren().addAll(new Label(getTop5Player.get(s).toString()));
            idTable.getChildren().addAll(new HBox(left, right));

            logger.info("Sikeres távolság beállítás");
        }

    }

    /**
     * A paraméterként adott objektumot az XML-be beleírja.
     * Ha a fájl nem létezik még, akkor létrehozza a user.home-ba a ColorGame mappát, és abba a leaderboard.xml-t.
     *
     * @param leaderBoard Ebben az esetben ez a leaderBoard objektum.
     */
    public static void toXML(LeaderBoard leaderBoard) {
        try {
            File file = new File(System.getProperty("user.home") + "/ColorGame");
            if (!file.exists()) {
                if (file.mkdir()) {
                }
            }
            JaxbController.toXML(leaderBoard, new FileOutputStream(System.getProperty("user.home") + "/ColorGame/leaderboard.xml"));
        } catch (FileNotFoundException | JAXBException e) {
            e.printStackTrace();
        }
        logger.info("Sikeres XML-be írás");
    }

    /**
     * A user.home helyen lévő, ColorGame mappában lévő leaderboard.xml-ből olvas.
     *
     * @return azzal az objektummal, amit az XML-ből olvas.
     */

    public static LeaderBoard fromXML() {
        LeaderBoard ranks = new LeaderBoard();
        try {
            ranks = JaxbController.fromXML(game.LeaderBoard.class, new FileInputStream(System.getProperty("user.home")
                    + "/ColorGame/leaderboard.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            ;
        }
        logger.info("Sikeres olvasás XML-ből");
        return ranks;

    }


}
