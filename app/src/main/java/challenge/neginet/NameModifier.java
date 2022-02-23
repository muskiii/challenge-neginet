package challenge.neginet;

import java.util.*;
import java.util.stream.Collectors;

public class NameModifier {

    public static List<String> modifyNames(String fileName, Integer limit) {
        LinkedHashMap<String, String> fullNames = new LinkedHashMap<>();
        LinkedHashMap<String, String> names = new LinkedHashMap<>();

        FileUtils.process(fileName, line -> {
            if (!FileUtils.isValid(line)) return;

            String[] fullName = Arrays.copyOf(line.split(",\\s*|\\s*--"), 2);
            String firstName = fullName[1];
            String lastName = fullName[0];
            if (!fullNames.containsKey(lastName) && !names.containsKey(firstName)) {
                fullNames.put(lastName, firstName);
                names.put(firstName, "");
            }
        });

        return fullNames
                .entrySet()
                .stream()
                .map(stringStringEntry -> stringStringEntry.getKey() + ", " + stringStringEntry.getValue())
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static List<String> createNames(List<String> uniqueNames) {
        List<String> createdNames = new ArrayList<>();

        for (int i = 0, j = 1; j < uniqueNames.size(); i++, j++) {
            String fullName = uniqueNames.get(i);
            String nextFullName = uniqueNames.get(j);
            String lastName = fullName.substring(0, fullName.indexOf(","));
            String nextFirstName = nextFullName.substring(nextFullName.indexOf(",") + 1);

            createdNames.add(lastName + "," + nextFirstName);
        }

        // Add missing fullName from Last lastName and First firstNAme
        createdNames.add(
                uniqueNames.get(uniqueNames.size() - 1).substring(0, uniqueNames.get(uniqueNames.size() - 1).indexOf(","))
                        + ","
                        + uniqueNames.get(0).substring(uniqueNames.get(0).indexOf(",") + 1)
        );

        return createdNames;
    }

    public static void printCreatedNames(String fileName, Integer limit) {
        List<String> uniqueNames = NameModifier.modifyNames(fileName, limit);
        List<String> createdNames = NameModifier.createNames(uniqueNames);
        System.out.println(createdNames);
    }

}
