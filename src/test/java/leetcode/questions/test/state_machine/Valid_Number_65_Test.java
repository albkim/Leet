package leetcode.questions.test.state_machine;

import leetcode.questions.state_machine.Valid_Number_65;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/18/2016.
 */
public class Valid_Number_65_Test {

    @Test
    public void testEdge() {
        assertFalse(Valid_Number_65.isNumber(" "));
    }

    @Test
    public void testEdge2() {
        assertTrue(Valid_Number_65.isNumber(".1"));
        assertTrue(Valid_Number_65.isNumber("+.1"));
    }

    @Test
    public void testEdge3() {
        assertFalse(Valid_Number_65.isNumber("0e"));
    }

    @Test
    public void testEdge4() {
        assertTrue(Valid_Number_65.isNumber("3."));
        assertTrue(Valid_Number_65.isNumber("3. "));
    }

    @Test
    public void testEdge5() {
        assertTrue(Valid_Number_65.isNumber("46.e3"));
        assertFalse(Valid_Number_65.isNumber(".e3"));
        assertFalse(Valid_Number_65.isNumber("7.e-."));
    }

    @Test
    public void testSimple() {
        assertTrue(Valid_Number_65.isNumber("0"));
        assertTrue(Valid_Number_65.isNumber(" 0.1 "));
        assertTrue(Valid_Number_65.isNumber("2e10"));
        assertFalse(Valid_Number_65.isNumber("abc"));
        assertFalse(Valid_Number_65.isNumber("1 a"));
    }

}
