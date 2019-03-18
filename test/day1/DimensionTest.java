package day1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class DimensionTest {
    @Test
    void shouldGiveMeTheDimension() throws Exception {
        Dimension dimension = new Dimension(3.0);
        assertEquals(dimension.getDimension(), 3.0);
    }

    @Test
    void shouldThrowExceptionForNegativeNumbers() throws Exception {
        assertThrows(Exception.class, () -> new Dimension(-1));
    }
}