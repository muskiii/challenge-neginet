package challenge.neginet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Statistic {
    private final Map<String, Integer> fullNamesRepetitions = new HashMap<>();
    private final Map<String, Integer> lastNamesRepetitions = new HashMap<>();
    private final Map<String, Integer> firstNamesRepetitions = new HashMap<>();

    public void printStatisticFromFile(String fileName) {
        populateStatisticsFromFile(fileName);

        System.out.println(getCardinalityString(getFullNamesRepetitionsSize(), getLastNamesRepetitionsSize(), getFirstNamesRepetitionsSize()));
        System.out.println(getMostCommonLastNamesString(lastNamesRepetitions));
        System.out.println(getMostCommonFirstNamesString(firstNamesRepetitions));
    }

    public void populateStatisticsFromFile(String fileName) {
        FileUtils.process(fileName, line -> {
            if (!FileUtils.isValid(line)) return;

            String[] fullName = Arrays.copyOf(line.split(",\\s*|\\s*--"), 2);
            String firstName = fullName[1];
            String lastName = fullName[0];

            fullNamesRepetitions.merge(String.join(", ", fullName), 1, Integer::sum);
            lastNamesRepetitions.merge(lastName, 1, Integer::sum);
            firstNamesRepetitions.merge(firstName, 1, Integer::sum);
        });
    }

    public String getCardinalityString(int fullNames, int lastNames, int firstNames) {
        return String.format("The names cardinality for full, last, and first names: Full names: %d Last names: %d First names: %d", fullNames, lastNames, firstNames);
    }

    public String getMostCommonFirstNamesString(Map<String, Integer> firstNames) {
        return String.format("The most common first names are:%s", getLimitedDescSortedString(firstNames, 10));
    }

    public String getMostCommonLastNamesString(Map<String, Integer> lastName) {
        return String.format("The most common last names are:%s", getLimitedDescSortedString(lastName, 10));
    }

    private static String getLimitedDescSortedString(Map<String, Integer> lastName, Integer limit) {
        StringBuilder stringBuilder = new StringBuilder();
        lastName
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .forEachOrdered(stringIntegerEntry -> stringBuilder.append(" ")
                        .append(stringIntegerEntry.getKey())
                        .append(": ")
                        .append(stringIntegerEntry.getValue()));
        return stringBuilder.toString();
    }

    public Integer getFullNamesRepetitionsSize() {
        return fullNamesRepetitions.size();
    }

    public Integer getLastNamesRepetitionsSize() {
        return lastNamesRepetitions.size();
    }

    public Integer getFirstNamesRepetitionsSize() {
        return firstNamesRepetitions.size();
    }
}
