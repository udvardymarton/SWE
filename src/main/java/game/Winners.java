package game;

/**
 * A Winners class, ez tartalmazza az existWinner boolean típusú függvényt, ami a győztesekről dönt, vagy elfogyott hely esetén, döntetlen eredményt ad.
 */
public class Winners {
    /**
     * Kezdetben üres a winner, ha valaki nyer vagy döntetlen lesz, akkor kerül bele érték.
     */
    public static String winner = null;

    /**
     * A játék végén a játék nyertesét, vagy döntetlen esetén döntetlent kiíró függvény.
     * A vizsgálat elemenként történik.
     * A kék játékos akkor nyer, ha egy oszlopban kigyűlik a kék szín.
     * A piros pedig, ha egy sorban.
     * Döntetlen akkor lesz, ha ez nem történt meg, és a fehér helyek elfogytak.
     *
     * @return A függvény boolean típusú, ha van nyertes vagy döntetlen van true-val tér vissza.
     * A return false visszatérés addig működik, míg van fehér mező.
     */
    public static boolean existWinner() {
        char eredmenyKek = 'K';
        char eredmenyPiros = 'P';
        char eredmenyFeher = 'F';

        for (int i = 0; i < 11; i++) {
            if (Table.table[i][0] == eredmenyPiros && Table.table[i][1] == eredmenyPiros && Table.table[i][2] == eredmenyPiros && Table.table[i][3] == eredmenyPiros &&
                    Table.table[i][4] == eredmenyPiros && Table.table[i][5] == eredmenyPiros && Table.table[i][6] == eredmenyPiros && Table.table[i][7] == eredmenyPiros &&
                    Table.table[i][8] == eredmenyPiros && Table.table[i][9] == eredmenyPiros && Table.table[i][10] == eredmenyPiros) {
                winner = Players.getSecondPlayer();
                return true;
            }
        }
        for (int j = 0; j < 11; j++) {
            if (Table.table[0][j] == eredmenyKek && Table.table[1][j] == eredmenyKek && Table.table[2][j] == eredmenyKek && Table.table[3][j] == eredmenyKek &&
                    Table.table[4][j] == eredmenyKek && Table.table[5][j] == eredmenyKek && Table.table[6][j] == eredmenyKek && Table.table[7][j] == eredmenyKek &&
                    Table.table[8][j] == eredmenyKek && Table.table[9][j] == eredmenyKek && Table.table[10][j] == eredmenyKek) {
                winner = Players.getFirstPlayer();
                return true;
            }
        }
        for (int k = 0; k < 11; k++) {
            for (int l = 0; l < 11; l++) {
                if (Table.table[k][l] == eredmenyFeher) {
                    return false;
                }
            }
        }
        winner = "Döntetlen";
        return true;
    }

}
