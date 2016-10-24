package leetcode.test.questions.binary_search;

import leetcode.questions.binary_search.Valid_Perfect_Square_367;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albertk on 9/6/16.
 */
public class Valid_Perfect_Square_367_Test {

    @Test
    public void testErrorInput() {
        assertFalse(Valid_Perfect_Square_367.isPerfectSquare(0));
        assertFalse(Valid_Perfect_Square_367.isPerfectSquare(-1));
    }

    @Test
    public void testSimple() {
        assertTrue(Valid_Perfect_Square_367.isPerfectSquare(1));
        assertTrue(Valid_Perfect_Square_367.isPerfectSquare(9));
    }

    @Test
    public void testComplex() {
        assertTrue(Valid_Perfect_Square_367.isPerfectSquare(100));
    }

    @Test
    public void testOverflow() {
        assertFalse(Valid_Perfect_Square_367.isPerfectSquare(2147483647));
    }

}
