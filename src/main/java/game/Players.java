package game;

/**
 * Ez az osztály tartalmazza a játszható playerek neveihez szükséges két Stringet, a gettert és a settert.
 */
public class Players {

    /**
     * A két felhasznált változó.
     */
    private static String firstPlayer, secondPlayer;

    /**
     * Első játékos gettere.
     *
     * @return Visszatér az általa beírt névvel.
     */
    public static String getFirstPlayer() {
        return firstPlayer;
    }

    /**
     * Az első játékos settere.
     *
     * @param firstPlayer Egyenlővé teszi a beadott nevet, a private static változójával.
     */
    public static void setFirstPlayer(String firstPlayer) {
        Players.firstPlayer = firstPlayer;
    }

    /**
     * A második játékos settere.
     *
     * @param secondPlayer Egyenlővé teszi a beadott nevet, a private static változójával.
     */
    public static void setSecondPlayer(String secondPlayer) {
        Players.secondPlayer = secondPlayer;
    }

    /**
     * A második játékos gettere.
     *
     * @return Visszatér az általa beírt névvel.
     */
    public static String getSecondPlayer() {
        return secondPlayer;
    }
}
