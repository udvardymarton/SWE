package Controller;

import game.Table;
import game.Winners;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Ebbe található maga a tábla kattintással való megoldása, és annak formája.
 * Az onnal való visszalépés a nevekhez, és kilépés a táblából.
 */

public class GameController {
    /**
     * Ez a változó dönti el, hogy kié a kék szín, és kié a piros.
     */
    int korSzamlalo = 0;

    /**
     * Ez a gridpane tartalmazza a onMouseCliked-et.
     */
    @FXML
    GridPane table; //board
    /**
     * Egy label, ezzel hozom be a contentet, és az ablakot.
     */
    @FXML
    Label warning;
    /**
     * A text-ben megadott szöveget írom ki vele.
     */
    @FXML
    Label tableText;
    /**
     * A tábla létrehozásakor a négyzetek színeit állítja be.
     */
    private static Logger logger = LoggerFactory.getLogger(GameController.class);

    @FXML
    private void initialize() {
        new Table();
        for (int i = 0; i < Table.table.length; i++) {
            for (int j = 0; j < Table.table[i].length; j++) {
                StackPane square = new StackPane();
                square.setMinSize(75, 75);

                if (Table.table[j][i] == 'P') {
                    square.setStyle("-fx-background-color: red;");
                } else if (Table.table[j][i] == 'K') {
                    square.setStyle("-fx-background-color: blue;");
                } else if (Table.table[j][i] == 'F') {
                    square.setStyle("-fx-background-color: white;");
                }
                table.add(square, i, j);
            }
        }
    }

    /**
     * Benne van megírva a táblának a kiíratása és a játék végén a Winner.fxml betöltése.
     * Le van kezelve az az eset, ha a táblán kívülre kattintasz, akkor az Exception e résznél lévő szöveget adja ki.
     * Benne található a 2 játékos esetén a színeldöntés a korSzamlalo nevű változóval.
     *
     * @param mouseEvent Ez a paraméterként kapott objektum felelős a kattintások eldöntéséért.
     */
    @FXML
    protected void gridClicked(MouseEvent mouseEvent) {
        Node clickedNode = mouseEvent.getPickResult().getIntersectedNode();
        Integer colIndex = GridPane.getColumnIndex(clickedNode);
        Integer rowIndex = GridPane.getRowIndex(clickedNode);
        logger.info("{} {}", colIndex, rowIndex);
        try {
            if (Table.table[rowIndex][colIndex] == 'F') {
                if (korSzamlalo == 0) {
                    clickedNode.setStyle("-fx-background-color: blue;");
                    Table.table[rowIndex][colIndex] = 'K';
                    korSzamlalo++;
                } else if (korSzamlalo == 1) {
                    clickedNode.setStyle("-fx-background-color: red;");
                    Table.table[rowIndex][colIndex] = 'P';
                    korSzamlalo--;
                }
            }
        } catch (Exception e) {
            System.out.println("Mellékattintottál");
            logger.info("Táblán kívülre kattintott");
        }
        //Table.print2D(Table.table);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Winner.fxml"));
        logger.info("Sikeres Winner.fxml betöltés");
        if (Winners.existWinner()) {
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage stage = (Stage) table.getScene().getWindow();
            stage.setScene(new Scene(root, 300, 275));
            stage.setFullScreen(true);
            stage.show();
        }

    }

    /**
     * Kilép a játékból.
     */
    @FXML
    public void exitTable() {
        System.exit(0);
    }

    /**
     * Visszalép a PlayerName.fxml-be.
     */
    @FXML
    public void BackToNames() {
        Scene scene = warning.getScene();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/PlayerName.fxml"));
        } catch (IOException d) {
            d.printStackTrace();
        }
        scene.setRoot(root);
    }

}
