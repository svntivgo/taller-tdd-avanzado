package taller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    public StringCalculator stringCalculatorInstance = new StringCalculator();
    //An empty string returns zero
    @Test
    public void emptyStringTest() throws Exception {
        assertEquals(0, stringCalculatorInstance.add(""));
    }
    // A single number returns the value
    @Test
    public void singleNumberReturnItsValueTest() throws Exception {
        assertEquals(2, stringCalculatorInstance.add("2"));
        assertEquals(1, stringCalculatorInstance.add("1"));
    }
    //Two numbers, comma delimited, returns the sum
    @Test
    public void twoNumbersCommaDelimitedReturnsTheSumTest() throws Exception {
        assertEquals(2, stringCalculatorInstance.add("0,2"));
        assertEquals(2, stringCalculatorInstance.add("1,1"));
        assertEquals(3, stringCalculatorInstance.add("1,2"));
    }
    // Two numbers, newline delimited, returns the sum
    @Test
    public void sameThatBeforeButNewLineDelimitedTest() throws Exception {
        assertEquals(2, stringCalculatorInstance.add("0\n2"));
        assertEquals(2, stringCalculatorInstance.add("1\n1"));
        assertEquals(3, stringCalculatorInstance.add("1\n2"));
    }

    // Three numbers, delimited either way, returns the sum
    @Test
    public void sameThatBeforeButAllDelimitersWorksTest() throws Exception {
        assertEquals(6, stringCalculatorInstance.add("1\n2,3"));
        assertEquals(7, stringCalculatorInstance.add("1,2\n4"));
    }

    // Negative numbers throw an exception
    @Test
    public void negativeNumbersThrowsAnExceptionTest() throws Exception {
        assertThrows(Exception.class, () -> stringCalculatorInstance.add("-1,-1"));
    }

    // Numbers greater than 1000 are ignored
    @Test
    public void greaterThan1000AreIgnoredTest() throws Exception {
        assertEquals(1002, stringCalculatorInstance.add("2,1000"));
        assertEquals(2, stringCalculatorInstance.add("2,1001"));
    }
    // A single char delimiter can be defined on the first line
    @Test
    public void singleCharDelimiterTest() throws Exception {
        assertEquals(1002, stringCalculatorInstance.add("#2#1000"));
    }
}