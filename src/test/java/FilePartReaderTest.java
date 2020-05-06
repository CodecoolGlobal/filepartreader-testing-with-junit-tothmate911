import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FilePartReaderTest {
    private FilePartReader fpr;
    private String simpleFilePath = "src/test/resources/test.txt";

    @BeforeEach
    public void clearFilePathReader() {
        fpr = new FilePartReader();
        System.out.println("new fpr: " + fpr.toString());
    }

    @Test
    public void testAreInstanceVariablesInvalid() {
        assertThrows(IOException.class, fpr::read);
    }

    @Test
    public void testFromLineZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> fpr.setup("somePath", 0, 2));
    }

    @Test
    public void testFromLineGreaterThanToLineThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> fpr.setup("somePath", 2, 1));
    }

    @Test
    public void testReadExistingFile() throws IOException {
        fpr.setup(simpleFilePath, 1, 2);
        assertEquals("First line\n" +
                "Second line\n" +
                "Third line\n" +
                "Forth line", fpr.read());
    }

    @Test
    public void testReadNonExistingFile() {
        fpr.setup("nonExistingFile", 1, 2);
        assertThrows(IOException.class, fpr::read);
    }

    @Test
    public void testReadLinesSimple() {
        fpr.setup(simpleFilePath, 1, 2);
        assertEquals("First line\n" +
                "Second line", fpr.readLines());
    }

    @Test
    public void testReadLines1to1() {
        fpr.setup(simpleFilePath, 1, 1);
        assertEquals("First line", fpr.readLines());
    }

}
