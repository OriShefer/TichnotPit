import org.junit.Test;

import static org.junit.Assert.*;

public class CampTest {

    @Test
    public void calculateInstructors() {
    }

    @Test
    public void fibonacciByIndex() {
        final int EXPECTED = 21;

        int actual = Camp.fibonacciByIndex(8);

        assertEquals(EXPECTED,actual);
    }
}