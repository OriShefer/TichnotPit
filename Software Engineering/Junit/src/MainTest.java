import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void isGoodEncode_specialNumberInFirstIndex() {
        boolean actual = Main.isGoodEncode(84425823105L, 8);

        assertFalse(actual);
    }

    @Test
    public void isGoodEncode_goodEncode() {
        boolean actual = Main.isGoodEncode(84435843435L, 3);

        assertTrue(actual);
    }

    @Test
    public void isGoodEncode_specialNumber9() {
        boolean actual = Main.isGoodEncode(89495893195L, 9);

        assertFalse(actual);
    }

    @Test
    public void isGoodEncode_noSpecialNumber() {
        boolean actual = Main.isGoodEncode(89495893195L, 2);

        assertFalse(actual);
    }





    @Test
    public void whiteSmokeCode_multipleSpecialDigit() {

        final long EXPECTED = 68841251;

        long actual = Main.whiteSmokeCode(68128451,8,3);

        assertEquals(EXPECTED,actual);
    }

    @Test
    public void whiteSmokeCode_moreReverseThenDigits() {

        final long EXPECTED = 58521;

        long actual = Main.whiteSmokeCode(58125,8,5);

        assertEquals(EXPECTED,actual);
    }

    @Test
    public void reverseNumFromIndex_inRange() {
        final long EXPECTED = 8123;

        long actual = Main.reverseNumFromIndex(8321,3,1);

        assertEquals(EXPECTED,actual);
    }

    @Test
    public void reverseNumFromIndex_outOfRange() {
        final long EXPECTED = 8123;

        long actual = Main.reverseNumFromIndex(8321,4,1);

        assertEquals(EXPECTED,actual);
    }

    @Test
    public void reverseNumFromIndex_fromStart() {
        final long EXPECTED = 8123;

        long actual = Main.reverseNumFromIndex(3218,4,0);

        assertEquals(EXPECTED,actual);
    }

    @Test
    public void reverseNumFromIndex_fromStartAndOutOfRange() {
        final long EXPECTED = 8123;

        long actual = Main.reverseNumFromIndex(3218,5,0);

        assertEquals(EXPECTED,actual);
    }


}