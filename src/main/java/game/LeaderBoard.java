package game;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A ranglistát kezelő osztály.
 */
@javax.xml.bind.annotation.XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
/**
 * Ez a class felel a top5 játékosért.
 */
public class LeaderBoard {
    /**
     * A ranglista név-győzelem számpárjait tároló.
     */
    @XmlElement()
    /**
     * String,Integer alapú kulcs-érték párú HashMap létrehozása rankList néven.
     */
    private static LinkedHashMap<String, Integer> rankList = new LinkedHashMap<String, Integer>();

    public static LinkedHashMap<String, Integer> getRankList() {
        return rankList;
    }

    public static void setRankList(LinkedHashMap<String, Integer> rankList) {
        LeaderBoard.rankList = rankList;
    }

    /**
     * Végigmegy a listán, és megnézi, hogy a győztes neve szerepel-e a listában.
     * Ha a neve létezik a táblában, akkor csak növeli az értékét.
     *
     * @param name A listához adja a nevet, és pontját, ha még nem játszott ezelőtt.
     */
    public static void addToList(String name) {
        for (String s : rankList.keySet()
        ) {
            if (s.equals(name)) {
                rankList.replace(s, rankList.get(s) + 1);
                return;
            }

        }
        rankList.put(name, 1);
    }

    /**
     * @return Rendezi a játékostáblát, és visszatér a top5 nevével, és pontjaival.
     */
    public static LinkedHashMap<String, Integer> top5() {
        return rankList.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(5).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

}

