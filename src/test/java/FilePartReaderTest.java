import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FilePartReaderTest {

    @Test
    public void AreInstanceVariablesInvalid() {
        FilePartReader fpr = new FilePartReader();
        assertThrows(IOException.class, fpr::read);
    }
}
