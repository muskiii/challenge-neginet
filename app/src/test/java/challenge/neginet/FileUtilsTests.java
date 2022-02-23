package challenge.neginet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileUtilsTests {
    int count = 0;

    @Test
    void processFileCountingLines() {
        FileUtils.process("shortInput.txt", (line)-> {count++;});
        assertEquals(30, count);
    }

    @Test
    void succeedingIsValid() {
        assertTrue(FileUtils.isValid("Smith, Joan -- corporis"));
    }

    @Test
    void failingIsValidWithNonAlphabeticalChars() {
        assertFalse(FileUtils.isValid("O'Shea, Peter"));
    }

    @Test
    void failingIsValidNotLeadingCharacter() {
        assertFalse(FileUtils.isValid("    Totam eos ut omnis et nemo dolore."));
    }

    @Test
    void failingIsValidWrongFormat() {
        assertFalse(FileUtils.isValid("Smith Joan"));
    }
}
