package game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * A tábla kinézetét tartalmazza.
 */
public class Table {
    /**
     * Ez a tábla az egész játékban.
     */
    public static char[][] table;

    /**
     * A Table konstruktor tölti fel a táblát.
     */
    public Table() {
        table = new char[][]{
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
        };
    }

    public static void setTable(char[][] table) {
        Table.table = table;
    }

    /**
     * @param table A paraméterként beadott tábla kiíratása.
     */
    public static void print2D(char table[][]) {
        for (char[] row : table)
            System.out.println(Arrays.toString(row));
        System.out.println(" ");
    }

}
