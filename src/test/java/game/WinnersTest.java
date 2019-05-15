package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WinnersTest {
    @Test
    public void existWinnerTest() {
        Table table = new Table();
        assertFalse(Winners.existWinner());

        Table.setTable(new char[][]{
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
        });
        assertTrue(Winners.existWinner());
    }
}
