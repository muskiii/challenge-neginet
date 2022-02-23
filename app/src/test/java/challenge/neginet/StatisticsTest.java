package challenge.neginet;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsTest {

    @Test
    void populateStatisticsFromFile(){
        final Statistic statistic = new Statistic();
        statistic.populateStatisticsFromFile("cardinalityInput.txt");
        assertEquals(5, statistic.getFullNamesRepetitionsSize());
        assertEquals(4, statistic.getLastNamesRepetitionsSize());
        assertEquals(3, statistic.getFirstNamesRepetitionsSize());
    }

    @Test
    void getCardinalityString(){
        final Statistic statistic = new Statistic();

        String expected = "The names cardinality for full, last, and first names: Full names: 5 Last names: 4 First names: 3";
        assertEquals(expected, statistic.getCardinalityString(5,4,3));
    }

    @Test
    void getMostCommonLastNamesString(){
        final Statistic statistic = new Statistic();

        Map <String, Integer> firstNames = new LinkedHashMap<>();
        firstNames.put("Smith",2);
        firstNames.put("Thomas",1);
        firstNames.put("Upton",1);
        firstNames.put("Cartman", 1);

        String expected = "The most common last names are: Smith: 2 Thomas: 1 Upton: 1 Cartman: 1";
        assertEquals(expected, statistic.getMostCommonLastNamesString(firstNames));
    }

    @Test
    void getMostCommonFirstNamesString(){
        final Statistic statistic = new Statistic();

        Map <String, Integer> lastNames = new LinkedHashMap<>();
        lastNames.put("Joan",3);
        lastNames.put("Eric",1);
        lastNames.put("Sam",1);

        String expected = "The most common first names are: Joan: 3 Eric: 1 Sam: 1";
        assertEquals(expected, statistic.getMostCommonFirstNamesString(lastNames));
    }
}
