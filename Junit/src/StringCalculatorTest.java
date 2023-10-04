import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void execute_AddOperation() {
        final int EXPECTED = 3;

        assertEquals(EXPECTED, StringCalculator.execute("1+2"));
    }

    @Test
    public void execute_SubOperation() {
        final int EXPECTED = 5;

        assertEquals(EXPECTED, StringCalculator.execute("8-3"));
    }

    @Test
    public void execute_MultiMathOperations() {
        final int EXPECTED = 14;

        assertEquals(EXPECTED, StringCalculator.execute("8-3+10-2+1"));
    }

    @Test
    public void execute_NegativeResult() {
        final int EXPECTED = -2;

        assertEquals(EXPECTED, StringCalculator.execute("8-10"));
    }

    @Test
    public void execute_ZeroResult() {
        final int EXPECTED = 0;

        assertEquals(EXPECTED, StringCalculator.execute("8-8"));
    }

    @Test
    public void removeSpaces_WithoutSpaces() {
        final String EXPECTED = "abc";

        assertEquals(EXPECTED, StringCalculator.removeSpaces("abc"));
    }

    @Test
    public void removeSpaces_OneSpace() {
        final String EXPECTED = "abc";

        assertEquals(EXPECTED, StringCalculator.removeSpaces("ab c"));
    }

    @Test
    public void removeSpaces_MultiSpaces() {
        final String EXPECTED = "abc";

        assertEquals(EXPECTED, StringCalculator.removeSpaces("a b c"));
    }

    @Test
    public void removeSpaces_SpaceAtTheStart() {
        final String EXPECTED = "abc";

        assertEquals(EXPECTED, StringCalculator.removeSpaces(" abc"));
    }

    @Test
    public void removeSpaces_SpaceAtTheEnd() {
        final String EXPECTED = "abc";

        assertEquals(EXPECTED, StringCalculator.removeSpaces("abc "));
    }

    @Test
    public void getOperators_NoOperators() {
        final String[] EXPECTED = {};

        assertArrayEquals(EXPECTED, StringCalculator.getOperators("6666"));
    }

    @Test
    public void getOperators_OneOperator() {
        final String[] EXPECTED = {"+"};

        assertArrayEquals(EXPECTED, StringCalculator.getOperators("66+66"));
    }

    @Test
    public void getOperators_MultiOperators() {
        final String[] EXPECTED = {"+", "+"};

        assertArrayEquals(EXPECTED, StringCalculator.getOperators("66+66+1"));
    }

    @Test
    public void getOperators_DifferentOperators() {
        final String[] EXPECTED = {"+", "-"};

        assertArrayEquals(EXPECTED, StringCalculator.getOperators("66+66-1"));
    }

    @Test
    public void getOperands_OneOperand() {
        final String[] EXPECTED = {"6"};

        assertArrayEquals(EXPECTED, StringCalculator.getOperands("6"));
    }

    @Test
    public void getOperands_MultiOperand() {
        final String[] EXPECTED = {"6", "5"};

        assertArrayEquals(EXPECTED, StringCalculator.getOperands("6+5"));
    }

    @Test
    public void getOperands_NonSingleDigitOperand() {
        final String[] EXPECTED = {"999", "5"};

        assertArrayEquals(EXPECTED, StringCalculator.getOperands("999+5"));
    }

    @Test
    public void validateExpression_ExpressionValid() {
        assertTrue(StringCalculator.validateExpression("5+7-8"));
    }

    @Test
    public void validateExpression_InvalidLetterAtTheStart() {
        assertFalse(StringCalculator.validateExpression("%5+7-8"));
    }

    @Test
    public void validateExpression_InvalidLetterAtTheEnd() {
        assertFalse(StringCalculator.validateExpression("5+7-8%"));
    }

    @Test
    public void validateExpression_MultiInvalidLetters() {
        assertFalse(StringCalculator.validateExpression("5+#7&-_8"));
    }
}