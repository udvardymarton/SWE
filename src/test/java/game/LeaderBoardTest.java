package game;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;

public class LeaderBoardTest {
    @BeforeEach
    public void fgv() {
        LeaderBoard.setRankList(new LinkedHashMap<>());
    }

    @Test
    public void top5Test() {
        LinkedHashMap<String, Integer> test = new LinkedHashMap<>();
        test.put("Jano", 21);
        test.put("Hzz", 75);
        test.put("Numb", 30);
        test.put("Xenny", 17);
        test.put("Bad", 28);
        test.put("Lol", 15);
        LeaderBoard.setRankList(test);

        LinkedHashMap<String, Integer> expected = new LinkedHashMap<>();
        expected.put("Hzz", 75);
        expected.put("Numb", 30);
        expected.put("Bad", 28);
        expected.put("Jano", 21);
        expected.put("Xenny", 17);

        assertEquals(expected, LeaderBoard.top5());
    }

    @Test
    public void addToListTest() {
        LeaderBoard.addToList("Nubb");
        LeaderBoard.addToList("Nubb");
        LeaderBoard.addToList("Nubb");
        LeaderBoard.addToList("Yehjj");

        LinkedHashMap<String, Integer> expected = new LinkedHashMap<>();
        expected.put("Nubb", 3);
        expected.put("Yehjj", 1);

        assertEquals(expected, LeaderBoard.getRankList());
    }
}
