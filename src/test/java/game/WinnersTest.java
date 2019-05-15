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

    @Test
    public void existWinnerTest2() {

        Table.setTable(new char[][]{
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'K', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'K', 'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'K', 'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'K', 'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
                {'P', 'K', 'P', 'F', 'P', 'F', 'P', 'F', 'P', 'F', 'P'},
                {'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F', 'K', 'F'},
        });
        assertTrue(Winners.existWinner());
    }

    @Test
    public void existWinnerTest3() {

        Table.setTable(new char[][]{
                {'P', 'K', 'K', 'K', 'K', 'K', 'P', 'K', 'K', 'K', 'K'},
                {'K', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
                {'K', 'K', 'P', 'K', 'K', 'K', 'K', 'K', 'K', 'K', 'K'},
                {'K', 'P', 'P', 'P', 'P', 'K', 'P', 'P', 'P', 'K', 'P'},
                {'K', 'K', 'K', 'K', 'K', 'K', 'K', 'K', 'P', 'K', 'K'},
                {'K', 'K', 'P', 'K', 'P', 'K', 'P', 'K', 'P', 'K', 'P'},
                {'P', 'K', 'K', 'K', 'K', 'K', 'P', 'K', 'P', 'K', 'P'},
                {'P', 'K', 'P', 'K', 'P', 'K', 'P', 'K', 'P', 'P', 'P'},
                {'K', 'K', 'P', 'K', 'P', 'K', 'K', 'K', 'P', 'K', 'K'},
                {'P', 'K', 'K', 'K', 'P', 'K', 'P', 'P', 'P', 'K', 'P'},
                {'K', 'K', 'K', 'K', 'P', 'K', 'K', 'K', 'K', 'K', 'K'},
        });
        assertTrue(Winners.existWinner());
    }


}
