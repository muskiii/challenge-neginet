package challenge.neginet;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameModifierTests {

    @Test
    void processUniqueFullNamesLimitTen() {
        List<String> uniqueFullNames = NameModifier.modifyNames("shortInput.txt", 5);
        assertEquals(Arrays.asList("Graham, Mckenna", "Marvin, Garfield", "McLaughlin, Mariah", "Lang, Agustina", "Bradtke, Nikko"), uniqueFullNames);
    }

    @Test
    void processUniqueFullNamesLimitThree() {
        List<String> uniqueFullNames = NameModifier.modifyNames("shortInput.txt", 3);
        assertEquals(Arrays.asList("Graham, Mckenna", "Marvin, Garfield", "McLaughlin, Mariah"), uniqueFullNames);
    }

    @Test
    void processOneUniqueFullNameLimitTen() {
        List<String> uniqueFullNames = NameModifier.modifyNames("oneUniqueFullNameInput.txt", 10);
        assertEquals(1, uniqueFullNames.size());
    }

    @Test
    void createNamesFromList() {
        List<String> UniqueFullNames = Arrays.asList("Graham, Mckenna", "Marvin, Garfield", "McLaughlin, Mariah");
        assertEquals(List.of("Graham, Garfield", "Marvin, Mariah", "McLaughlin, Mckenna"), NameModifier.createNames(UniqueFullNames));
    }
}
